import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static HashMap<Integer, Integer> map;
    static int n;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new HashMap<>();
        stk = new StringTokenizer(bf.readLine());
        int [] key = new int[n];
        for(int i = 0;i<n;i++){
            int a = Integer.parseInt(stk.nextToken());
            key[i] = a;
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else{
                map.put(a, 1);
            }
        }
        int left = 0;
        int right = n-1;
        Arrays.sort(key);
        int cnt = 0;
//        System.out.println(Arrays.toString(key));
//        for(Map.Entry<Integer, Integer> entryset : map.entrySet()) {
//        	System.out.print("key : "+ entryset.getKey()+ " value : "+entryset.getValue()+" => ");
//        }
//        System.out.println();
        while(left < right) {
//        	System.out.println("left : "+left+" right : "+right);
//        	System.out.println(" lval : "+key[left]+" rval : "+key[right]);
        	long sum = key[left] + key[right];
        	if(sum > k) {
        		right--;
        	}else if(sum == k) {
        		left++;
        		cnt += (map.get(key[left]) * map.get(key[right]));
        	}else {
        		left++;
        	}
        }
        System.out.print(cnt);
    }
}