import java.util.*;
import java.io.*;
public class Main {
    static StringTokenizer stk;
    static int n;
    public static void main(String[] args) throws Exception{
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            stk = new StringTokenizer(bf.readLine());
            String comm = stk.nextToken();
            int key, value;
            switch(comm){
                case "add":
                    key = Integer.parseInt(stk.nextToken());
                    value = Integer.parseInt(stk.nextToken());
                    treeMap.put(key, value);
                    break;
                case "find":
                    key = Integer.parseInt(stk.nextToken());
                    sb.append(treeMap.get(key) == null ? "None": treeMap.get(key)).append("\n");
                    break;
                case "remove":
                    key = Integer.parseInt(stk.nextToken());
                    treeMap.remove(key);
                    break;
                case "print_list":
                    if(treeMap.size() == 0){
                        sb.append("None").append("\n");
                    }else{
                        for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()){
                            sb.append(entry.getValue()).append(" ");
                        }
                        sb.append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}