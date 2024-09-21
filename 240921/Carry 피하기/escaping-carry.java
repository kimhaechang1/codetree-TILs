import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] nums;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        nums= new int[n];
        for(int i = 0;i<n;i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        max = 1;
        // 조합인데 개수가 지정이 안되있다 -> 부분집합
        dfs(0, 0, 0);
        System.out.println(max);
    }
    static void dfs(int depth, int cnt, int sum) { 
        if(depth == n) {
            return;
        }

        max = Math.max(cnt, max);
        dfs(depth+1, cnt, sum);

        
        if(can(sum, depth)) {
            max = Math.max(cnt+1, max);
            dfs(depth+1, cnt+1, sum + nums[depth]);
        }
    }
    static boolean can(int sum, int idx) {
        int target = nums[idx];
        while(sum > 0 || target > 0) {
            int num1 = target % 10;
            int num2 = sum % 10;
            if (num1 + num2 >=10) return false;
            sum /= 10;
            target /= 10;
        }
        return true;
    }
}