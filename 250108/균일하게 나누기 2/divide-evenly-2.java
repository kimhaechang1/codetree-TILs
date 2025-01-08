import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] info;
    static BufferedReader bf;
    static StringTokenizer stk;

    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();
    }

    void testCase() throws Exception {

    }

    void input() throws Exception {

        n = Integer.parseInt(bf.readLine());
        info = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken());
            info[i][1] = Integer.parseInt(stk.nextToken());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {

        // x와 y에 따라 정렬을 한다는건 불가능하다.
        int answer = Integer.MAX_VALUE;
        // 애초에 X 좌표를 정렬했다고 가정해보자.
        // 그럼 y는 정렬되어있지 않을 것이다.
        // 그러면 매 순간 y에 값에 따라 크게 변동은 생길것이다. 하지만 x를 기준으로는 언제나 좌우를 계산하는건 어렵지 않다.

        // 그리고 점점 우측 위로 즉 y,x 가 증가할수록 각 사분면 별 점의 개수가 달라지게 되어있다.
        // 좌표는 홀수로 주어지기 때문에, 짝수 좌표로만 기준선을 이동시키면 된다.
        Arrays.sort(info, (a, b) -> {
            return a[0] - b[0];
        });
        for(int y = 0; y <= 1000; y+= 2) {
            
            int[] cnt = new int[5];
            
            // 현재 결정된 y에 따라 위아래 나누기

            for(int i = 0; i < n; i++) {
                if (info[i][1] > y) cnt[1]++;
                else cnt[4]++;
            }

            // x에 변화가 생기면, 그때 점의 변화도 생겨야 하므로
            for(int i = 0; i < n; i++) {
                
                if (i == 0 || info[i][0] != info[i - 1][0]) {
                    int maxCnt = 0;
                    for(int j = 1; j <= 4; j++) {
                        maxCnt = Math.max(maxCnt, cnt[j]);
                    }
                    answer = Math.min(answer, maxCnt);
                }
                

                // 현재 고정된 y에서 x의 변화에 따라 기준선이 달라지기 때문에 좌우 조절을 해준다.
                // 만약 같은 x좌표가 있다 하더라도, y는 반드시 다르기 때문에 그거에 따른 위아래로 나뉜 점의 개수에서 좌우를 나눠주어야 한다.
                if (info[i][1] > y) {
                    cnt[1]--;
                    cnt[2]++;
                } else {
                    cnt[4]--;
                    cnt[3]++;
                }
            }
        }
        System.out.print(answer);
        
        
    }
}