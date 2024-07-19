import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        int sum = 0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int total = n;
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            String word = bf.readLine();
            treeMap.put(word, treeMap.get(word) == null ? 1 : treeMap.get(word) + 1);
        }
        Set<String> keys = treeMap.keySet();
        for(String key: keys){
            sb.append(key).append(" ").append(String.format("%.4f", ( (double) treeMap.get(key) / total) * 100 )).append("\n");
        }
        System.out.print(sb);
        
    }
}