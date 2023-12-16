import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int cnt;
    static int [] res;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        cnt = 0;
        res = new int[n];
        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int depth){
        if(depth == n){
            if(chk(res)){
                cnt++;
            }
            return;
        }

        for(int i = 1;i<=4;i++){
            res[depth] = i;
            dfs(depth+1);
        }
    }
    static boolean chk(int [] arr){
        int prev = 0;
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if(prev == arr[i]){
                if(prev == 2){
                    if(cnt == 2){
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                }else if(prev == 3){
                    if(cnt == 3){
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                }else if(prev == 4){
                    if(cnt == 4){
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                }
            }else{
                if(prev == 2){
                    if(cnt != 2){
                        return false;
                    }
                }else if(prev == 3){
                    if(cnt != 3){
                        return false;
                    }
                }else if(prev == 4){
                    if(cnt != 4){
                        return false;
                    }
                }
                prev = arr[i];
                cnt = 1;
            }
        }
        if(prev == 2){
            if(cnt != 2){
                return false;
            }
        }else if(prev == 3){
            if(cnt != 3){
                return false;
            }
        }else if(prev == 4){
            if(cnt != 4){
                return false;
            }
        }
        return true;
    }
    
}