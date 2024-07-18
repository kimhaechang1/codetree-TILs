import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static HashMap<String, Integer> map;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        n = Integer.parseInt(bf.readLine());
        int max = 0;
        for(int i = 0;i<n;i++){
            char [] frags = bf.readLine().toCharArray();
            Arrays.sort(frags);
            StringBuilder sb =new StringBuilder();
            for(char f: frags) sb.append(f);
            String result = sb.toString();
            int before = 0;
            if(map.containsKey(result)){
                before = map.get(result);
            }
            max = Math.max(before+1, max);
            map.put(result, before+1);
        }
        System.out.print(max);
    }
}