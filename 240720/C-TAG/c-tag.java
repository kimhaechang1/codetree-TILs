import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static StringTokenizer stk;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new char[2 * n][m];
        for(int i = 0;i<2 * n;i++){
            map[i] = bf.readLine().toCharArray();
        }
        int cnt = 0;
        for(int i = 0;i<m-2;i++){
            for(int j = i+1;j<m-1;j++){
                for(int k = j+1;k<m;k++){
                    if(go(i, j, k)){
                        cnt++;
                    }
                    
                }
            }
        }
        System.out.print(cnt);
    }
    static boolean go(int idx1, int idx2, int idx3){
        HashSet<String> aSet = new HashSet<>();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(map[i][idx1]).append(map[i][idx2]).append(map[i][idx3]);
            aSet.add(sb.toString());
        }

        for(int i = n;i<n * 2;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(map[i][idx1]).append(map[i][idx2]).append(map[i][idx3]);
            if(aSet.contains(sb.toString())){
                return false;
            }
        }
        return true;
    }
}