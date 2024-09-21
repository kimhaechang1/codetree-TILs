import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] nums;
    static int[][] numbers;
    static boolean[] v;
    static int max;
    static ArrayDeque<Integer> aDeq;
    static ArrayDeque<Integer> bDeq;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        nums= new int[n];
        v = new boolean[n];
        numbers = new int[n][9];
        aDeq = new ArrayDeque<>();
        bDeq = new ArrayDeque<>();
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
            dfs(nums[i], v, 1);
            v[i] = false;
        }
        System.out.println(max);
    }
    static void dfs(int pSum, boolean[] selected, int cnt) {
        for(int i = 0;i<n;i++) {
            if(selected[i]) continue;
            if(check(pSum, i)) {
                pSum += nums[i];
                selected[i] = true;
                max = Math.max(cnt+1, max);
                dfs(pSum, selected, cnt+1);
                selected[i] = false;
                pSum -= nums[i];
            }
        }
    }
    
    static boolean check(int pSum, int sIdx) {
        String pStr = String.valueOf(pSum);
        String sStr = String.valueOf(nums[sIdx]);
        for(int i = 0;i<pStr.length();i++) {
            aDeq.addLast(pStr.charAt(i)-'0');
        }
        for(int i = 0;i<sStr.length();i++) {
            bDeq.addLast(sStr.charAt(i)-'0');
        }
        while(!aDeq.isEmpty() && !bDeq.isEmpty()) {
            int a= aDeq.peekLast();
            int b= bDeq.peekLast();
            if ( a + b >= 10 ) {
                if(!aDeq.isEmpty()) {
                    aDeq.clear();
                }
                if(!bDeq.isEmpty()) {
                    bDeq.clear();
                }
                return false;
            }
            aDeq.pollLast();
            bDeq.pollLast();
        }
        if(!aDeq.isEmpty()) {
            aDeq.clear();
        }
        if(!bDeq.isEmpty()) {
            bDeq.clear();
        }
        return true;
    }
}