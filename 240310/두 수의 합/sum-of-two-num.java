import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static HashMap<Long, Integer> map;
    static int n;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new HashMap<>();
        stk = new StringTokenizer(bf.readLine());
        long [] key = new long[n];
        for(int i = 0;i<n;i++){
            int a = Integer.parseInt(stk.nextToken());
            key[i] = a;
        }
        int cnt = 0;
        // 두 수의 합 이기 때문에, 합을 만들 수 있는 나머지 값을 찾아서 그 경우의수를 만든다.
        // 또한 나머지 수를 통해 그 다음수를 만들 수 있는 경우 미리 해당 숫자의 경우의 수를 수열에서 만들어서 곱연산이라고 착각할 수 있다.
        // 어짜피 contstructive 형 문제는 쌓아지면서 답을 도출해내기 때문에, 덧셈연산을 해도 답이 나온다.
        for(int i= 0;i<n;i++){
            long diff = k - key[i];
            if(map.containsKey(diff)){
                cnt += map.get(diff);
            }

            if(!map.containsKey(key[i])){
                map.put(key[i], 1);
            }else{
                map.put(key[i], map.get(key[i])+1);
            }
        }
        
        System.out.print(cnt);
    }
}