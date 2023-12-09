import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    static int m;
    static int k;
    static int total;
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        total = 0;
        map = new int[n][n];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] > 0){
                    total++;
                }
            }
        }
        while(k-- > 0){
            while(checkAndBoom()){
                go();
            }
            rotate();
            go();
        }
        
        while(checkAndBoom()){
            go();
        }
        System.out.print(count());       
    }
    static boolean checkAndBoom(){
        boolean flg = false;
        for(int i= 0;i<n;i++){
            int c = 0;
            int prev = map[0][i];
            int s = 0;
            int e = 0;
            for(int j = 0;j<n;j++){
                if(prev == map[j][i]){
                    c++;
                    e = j;
                }else{
                    if(c >= m && prev != 0){
                        flg = true;
                        for(int start = s; start <=e;start++){
                            --total;
                            map[start][i] = 0;
                        }
                    }
                    c = 1;
                    prev = map[j][i];
                    s = j;
                    e = j;
                }
            }
            if(c >= m && prev != 0){
                flg = true;
                for(int start = s; start <= e;start++){
                    --total;
                    map[start][i] = 0;
                }
            }
            
        }
        return flg;
    }
    static void go(){
        for(int i = 0;i<n;i++){
            int tempidx = n-1;
            int [] temp = new int[n];
            for(int j = n-1;j>-1;j--){
                if(map[j][i] != 0){
                    temp[tempidx--] = map[j][i];
                }
            }

            for(int j = n-1;j>-1;j--){
                if(tempidx < j){
                    map[j][i] = temp[j];
                }else{
                    map[j][i] = 0;
                }
            }
        }
    }
    static void rotate(){
        int [][] temp = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                //if(map[i][j] == 0) continue;
                temp[j][n-1-i] = map[i][j];
            }   
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                map[i][j] = temp[i][j];
            }
        }
    }
    static int count(){
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }
    static void print(){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }
}