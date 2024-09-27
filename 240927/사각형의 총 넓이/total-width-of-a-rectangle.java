import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        int[][] rects = new int[N][4];
        for(int i= 0;i<N;i++) {
            stk =new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            rects[i][0] = x1;
            rects[i][1] = y1;
            rects[i][2] = x2;
            rects[i][3] = y2;

            xs.add(x1);
            xs.add(x2);
            ys.add(y1);
            ys.add(y2);
        }
        // 평면 스위핑은 전체 직사각형의 좌표를 모조리 구해서, x에 대하여 정렬, y에 대하여 정렬하고
        // 꺼낸 두 좌표가 어떤 직사각형이든 포함이 된다면 계산해야할 작은 직사각형이므로 계산한다.
        int sum = 0;
        Collections.sort(xs);
        Collections.sort(ys);

        for(int i = 0;i<xs.size() - 1;i++) {
            for(int j = 0;j<ys.size() - 1;j++) {
                for(int k = 0;k<N;k++) {
                    int mnX = rects[k][0];
                    int mxX = rects[k][2];
                    int mxY = rects[k][1];
                    int mnY = rects[k][3];

                    if ( mnX <= xs.get(i) && mxX >= xs.get(i+1) && mnY <= ys.get(j) && mxY >= ys.get(j+1)) {
                        // 어떤 사각형에 포함되는 2개의 좌표라면
                        sum += ( Math.abs(xs.get(i) - xs.get(i+1)) * Math.abs(ys.get(j) - ys.get(j+1)));
                        break;
                    }
                }
            }
        }
        System.out.print(sum);
        
        


    }

}