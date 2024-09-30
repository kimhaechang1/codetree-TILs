import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static char[] brackets;
    static int n;
    static int[] oSum;
    static int[] cSum;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String bracket = bf.readLine();
        n = bracket.length();
        brackets = bracket.toCharArray();
        // 열린 소괄호와 닫힌 소괄호의 개수가 같아야 한다.
        // 모든 prefix에 대해서 open이 close보다 적은 경우가 존재해선 안된다.
        // 결국 왼쪽에서부터 단 한순간도 open이 close보다 적은 경우가 존재해선 안된다 가 중요함
        // 특정 부분에서 괄호를 뒤집엇을때, 
        // 그 오른쪽 openSum과 closeSum, 그리고 그것을 포함한 왼쪽 openSu과, closeSum

        oSum = new int[n];
        cSum = new int[n];

        oSum[0] = brackets[0] == '(' ? 1 : 0;
        cSum[0] = brackets[0] == ')' ? 1 : 0;
        for(int i = 1;i<n;i++) {
            oSum[i] = oSum[i-1] + (brackets[i] == '(' ? 1 : 0);
            cSum[i] = cSum[i-1] + (brackets[i] == ')' ? 1 : 0);
        }        
        //System.out.println(Arrays.toString(oSum));
        //System.out.println(Arrays.toString(cSum));
        int cnt = 0;
        // 그 바뀐부분 기준으로 왼쪽은 신경을 덜받고 포함한 오른쪽은 영향을 받는데,,
        // 그 행동 후 계속해서 접두사가 오픈이 클로즈 이상이어야 정답 카운팅이 됨

        for(int i = 0;i<n;i++) {
            if (brackets[i] == '(') {
                if (oSum[n-1] - 1 != cSum[n-1] + 1) continue;
                if (i > 0 && oSum[i-1] < cSum[i-1]) break;
                if (check(i)) {
                    cnt++;
                }
            } else {
                if (oSum[n-1] + 1 != cSum[n-1] - 1) continue;
                if (i > 0 && oSum[i-1] < cSum[i-1]) break;
                if (check(i)) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
    static boolean check(int idx) {
        boolean isCan = true;
        /*for(int i = 0;i<idx;i++) {
            if(oSum[i] < cSum[i]) return false;
        }*/
        int oOffset = brackets[idx] == '(' ? -1 : 1;
        int cOffset = brackets[idx] == '(' ? 1 : -1;
        for(int i = idx;i<n;i++) {
            if(oSum[i] + oOffset < cSum[i] + cOffset) return false;
        }

        return true;
    }
}