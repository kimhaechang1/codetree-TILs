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
        }
        int left = 0;
        int right = 1;
        Arrays.sort(key);
        int cnt = 0;
        //System.out.println(Arrays.toString(key));
        if(n < 2) {
        	System.out.println(0);
        }else {
        	while(left < n) {
            	//System.out.println("left : "+left+" right : "+right);
            	//System.out.println(" lval : "+key[left]+" rval : "+key[right]);
            	long sum = key[left] + key[right];
            	if(sum > k) {
            		left++;
            		if(left + 1 < n) {
            			right = left+1;
            		}else {
            			break;
            		}
            	}else if(sum == k) {
            		right++;
            		cnt += 1;
//            		if(left + 1 < n) {
//            			right = left+1;
//            		}else {
//            			break;
//            		}
            	}else {
            		right++;
            	}
            	if(right == n) {
            		if(sum <= k) {
        				left++;
        			}
            		if(left + 1 < n) {	
            			right = left+1;
            		}else {
            			break;
            		}
            	}
            	
            }
        }
        System.out.print(cnt);
    }
}