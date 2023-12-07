import java.util.*;
import java.io.*;

public class Main {
    static String str;
    static ArrayDeque<Character> deque;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str = bf.readLine();
        int limit = str.length();
        int c = 0;
        int min =99999;
        deque = new ArrayDeque<>();
        init();
        while(c++ < limit){
            String res = encoding();
            //System.out.println("res : "+res);
            min = Math.min(min,res.length());
            shift();
        }
        System.out.print(min);
        
    }
    static void init(){
        char [] chs = str.toCharArray();
        for(char ch : chs){
            deque.addLast(ch);
        } 
    }
    static void shift(){
        deque.addFirst(deque.pollLast());
    }
    static String encoding(){
        
        char [] t = new char[deque.size()];
        int idx = 0;
        while(!deque.isEmpty()){
            t[idx++] = deque.pollFirst();
        }
        
        char present = t[0];
        StringBuilder sb = new StringBuilder();
        int c = 0;
        sb.append(present);
        for(char pre : t){
            if(pre == present){
                c++;
            }else{
                sb.append(c);
                present = pre;
                sb.append(present);
                c = 1;
            }
            deque.addLast(pre);
        }
        sb.append(c);
        
        
        
        return sb.toString();
    }
}