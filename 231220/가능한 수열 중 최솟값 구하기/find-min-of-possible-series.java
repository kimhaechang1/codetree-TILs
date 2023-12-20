import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int [] arr;
    static boolean isFind;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 4 5 4 6 4 5 4
        // 4 5 => 추가 후 앞뒤로 1칸씩검사
        // 6 4 5 6 5 4 6 5 4
        // 4 5 
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        isFind = false;
        dfs(0);
    }
    static void dfs(int depth){
        if(isFind) return;
        if(depth == n){
            sb= new StringBuilder();
            for(int a : arr) sb.append(a);
            System.out.print(sb);
            isFind = true;
            return;
        }
        for(int i =4;i<=6;i++){
            if(isFind) return;
            arr[depth] = i;
            boolean flg = false;
            if(depth > 0){
                int len = 1;
                int total = depth+1;
                while(true){
                    int [] prev = new int[len];
                    int [] post = new int[len];
                    for(int j = total-len;j<total;j++){
                        post[j - (total-len)] = arr[j];
                    }
                    if(total-len*2 < 0){
                        flg = true;
                        break;
                    }
                    for(int j = total-len*2;j<total-len;j++){
                        prev[j - (total-len*2)] = arr[j];
                    }
                    boolean isSame = true;
                    for(int j = 0;j<len;j++){
                        if(post[j] != prev[j]) {
                        	isSame = false;
                        	break;
                        }
                    }
                    if(isSame) {
                    	break;
                    }
                    len++;
                }
                if(flg){
                    dfs(depth+1);
                }
            }else{
                dfs(depth+1);
            }
        }
    }
}