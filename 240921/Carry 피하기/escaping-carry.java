import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] nums;
    static int[][] numbers;
    static boolean[] v;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        nums= new int[n];
        v = new boolean[n];
        numbers = new int[n][9];
        for(int i = 0;i<n;i++) {
            String n = bf.readLine();
            nums[i] = Integer.parseInt(n);
            for(int j = 8 - (n.length() - 1);j < 9;j++) {
                numbers[i][j] = (int)(n.charAt( j - (8 - (n.length()-1))) - '0');
            }
        }
        max = 1;
        

        for(int i =0;i<n;i++) {
            v[i] = true;
            dfs(numbers[i], v, 1);
            v[i] = false;
        }
        System.out.println(max);
    }
    static void dfs(int[] present, boolean[] selected, int cnt) {
        for(int i = 0;i<n;i++) {
            if(selected[i]) continue;
            if(check(present, numbers[i])) {
                int[] res = sum(present, numbers[i]);
                selected[i] = true;
                max = Math.max(cnt+1, max);
                dfs(res, selected, cnt+1);
                selected[i] = false;
            }
        }
    }
    static int[] sum(int[] present, int[] select) {
        int[] result = new int[9];
        for(int i = 0;i<9;i++) {
            result[i] = present[i] + select[i];
        }
        return result;
    }
    static boolean check(int[] present, int[] select) {
        int[] res = sum(present, select);
        for(int i= 0;i<9;i++) {
            if (res[i] >= 10) return false;
        }
        return true;
    }
}