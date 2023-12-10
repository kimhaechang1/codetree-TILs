import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int m;
    static int k;
    static int [][] map;
    static ArrayList<int []> block = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map= new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        init(m, k-1);
        while(go());
        print();
    }
    static void init(int len, int sx){
        int tx = len-1+sx;
        block.add(new int[]{0, sx});
        while(true){
            sx += 1;
            if(sx >= n || sx > tx) break;
            block.add(new int[]{0, sx});
        }
    }
    static boolean go(){
        ArrayList<int []> temp =new ArrayList<>();
        for(int [] now : block){
            if(now[0]+1 >= n){
                return false;
            }else if(map[now[0]+1][now[1]] > 0){
                return false;
            }else{
                temp.add(new int[]{now[0]+1, now[1]});
            }
        }
        block = temp;
        return true;
    }
    static void print(){
        for(int [] now : block){
            map[now[0]][now[1]] = 1;
        }
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}