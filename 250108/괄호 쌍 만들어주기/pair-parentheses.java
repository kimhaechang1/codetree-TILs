import java.util.*;
import java.io.*;

public class Main {
    static char[] brakets;
    static String str;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 연속한 여는괄호 2개와 연속한 닫는괄호 두 개로 쌍을 이룰 수 있는 서로 다른 가지수
        str = bf.readLine();
        brakets = str.toCharArray();
    
        // 오른쪽에서는 닫는괄호의 연속쌍이 등장하는 인덱스에 마킹을 찍고
        // 누적함을 해야할듯
        
        int[] close = new int[brakets.length];

        for(int i = brakets.length - 2;i > -1; i--) {
            if (brakets[i + 1] == ')' && brakets[i] == ')') {
                close[i] = 1;
            }
            close[i] += close[i + 1];
        }

        int answer = 0;
        for(int i = 1;i < brakets.length; i++) {
            if (brakets[i - 1] == '(' && brakets[i] == '(') {
                answer += (close[i]);
            }
        }
        System.out.print(answer);
    }
}