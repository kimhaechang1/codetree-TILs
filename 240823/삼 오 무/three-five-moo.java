import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 1, 2, M, 4, M, M, 7, 8, M, M
        // 11, M, 13, 14, M, 16, 17, M, 19, M, M, 22
        // 20 / 5 =  4
        // N번째에 대한 숫자를 추측하는 이분탐색으로 생각해보자.
        // N번째 숫자라는건 특정 숫자에서 Moo가 나오는 개수를 뺏을때 나오는 숫자냐 아니냐가 갈리는것
        // 예를들어 4번째 숫자라는것은 4번째 숫자가 오기까지 Moo개수를 뺏을때 4여야 하는것
        // 그래서 7까지의 3의 배수 3, 6 그리고 5의 배수 5를 빼서 4번째 숫자가 7이됨
        
        int n = Integer.parseInt(bf.readLine());
        
        long s = 1;
        long e = Integer.MAX_VALUE-1;
        long ans = Integer.MAX_VALUE-1;
        while(s <= e) {
            long mid = (s + e) / 2;
            if(search(mid, n)) {
                e = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                s = mid + 1;
            }
        }
        System.out.print(ans);
    }
    static boolean search(long value, int n) {
        return (value - (value / 3) - (value / 5) + (value / (3 * 5))) >= n;
    }
}