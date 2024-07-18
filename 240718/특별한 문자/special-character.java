import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] ch = bf.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i= 0;i<ch.length;i++){
            map.put(ch[i], map.get(ch[i])== null ? 1 : map.get(ch[i])+1);
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<26;i++){
            Integer cnt = map.get((char)('a' + i));
            if(cnt != null && cnt == 1) set.add((char)('a' + i));
        }
        boolean isFind = false;
        int i = 0;
        for(;i<ch.length;i++){
            if(set.contains(ch[i])){
                isFind = true;
                break;
            }
        }
        if(isFind){
            System.out.print(ch[i]);
        }else{
            System.out.print("None");
        }
        
    }
}