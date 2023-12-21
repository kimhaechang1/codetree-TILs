import java.util.*;
import java.io.*;

public class Main {
    static char [][] map;
    static int n;
    static int sy,sx,ty,tx;
    static HashMap<Integer, int[]> hashmap;
    static ArrayList<Integer> list;
    static int [] res;
    static int min = 9999999;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        int cnt = 0;
        hashmap = new HashMap<>();
        list = new ArrayList<>();
        int maximum = 0;
        for(int i = 0;i<n;i++){
            char [] ch = bf.readLine().toCharArray();
            for(int j = 0;j<n;j++){
                map[i][j] = ch[j];
                if(map[i][j] == 'S'){
                    sy = i;
                    sx = j;
                }else if(map[i][j] == 'E'){
                    ty = i;
                    tx = j;
                }else if(map[i][j]-'0' >= 1 && map[i][j]-'0' <= 9){
                    hashmap.put(map[i][j]-'0', new int[]{i, j});
                    cnt++;
                    list.add(map[i][j]-'0');
                }
            }
        }
        Collections.sort(list);
        if(cnt < 3){
            System.out.println(-1);
        }else{
            for(int i= 3;i<=cnt;i++){
                res = new int[i];
                dfs(0,0,i);
            }
            System.out.println(min);
        }
    }
    static void dfs(int depth, int cur, int limit){
        if(depth == limit){
            int sum = 0;
            int y = sy;
            int x = sx;
            //System.out.println(Arrays.toString(res));
            for(int i = 0;i<limit;i++){
                int [] pos = hashmap.get(res[i]);
                sum += (Math.abs(y - pos[0]) + Math.abs(x - pos[1]));
                y = pos[0];
                x = pos[1];
            }
            sum += (Math.abs(ty - y) + Math.abs(tx - x));
            min = Math.min(sum, min);
            return;
        }

        for(int i = cur;i<list.size();i++){
            res[depth] = list.get(i);
            dfs(depth+1, i+1, limit);
        }
    }
}