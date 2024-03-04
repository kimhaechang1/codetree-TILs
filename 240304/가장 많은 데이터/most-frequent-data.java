import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        n = Integer.parseInt(bf.readLine());
        int max = 0;
        while( n-- > 0){
            String key = bf.readLine();
            int value = 1;
            if(map.containsKey(key)){
                value = map.get(key)+1;
            }
            max = Math.max(max, value);
            map.put(key, value);
        }
        System.out.print(max);
    }
}