import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        while(n-- > 0){
            stk = new StringTokenizer(bf.readLine());
            String query = stk.nextToken();
            int key;
            int value;
            switch(query){
                case "add" :
                    key = Integer.parseInt(stk.nextToken());
                    value = Integer.parseInt(stk.nextToken());
                    map.put(key, value);
                    break;
                case "find" :
                    key = Integer.parseInt(stk.nextToken());
                    if(map.containsKey(key)){
                        sb.append(map.get(key)).append("\n");
                    }else{
                        sb.append("None").append("\n");
                    }
                    break;
                case "remove":
                    key = Integer.parseInt(stk.nextToken());
                    map.remove(key);
                    break;
            }
        }
        System.out.print(sb);
    }
}