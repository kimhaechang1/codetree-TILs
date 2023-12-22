import java.util.*;
import java.io.*;
public class Main {
    static int [] points;
    static int n;
    static int m;
    static int [] res;
    static int [][] lines;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        points = new int[n];
        for(int i = 0;i<n;i++){
            points[i] = Integer.parseInt(stk.nextToken());
        }
        lines = new int[m][2];
        for(int i = 0;i<m;i++){
            stk= new StringTokenizer(bf.readLine());
            lines[i][0] = Integer.parseInt(stk.nextToken());
            lines[i][1] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(points);
        for(int i = 0;i<m;i++){
            int a = lines[i][0];
            int b = lines[i][1];
            int lb = lower(0, n-1, a);
            int ub = upper(0, n-1, b);
            //System.out.println("lb : "+lb+" ub : "+ub);
            if(lb == ub){
                System.out.println(0);
            }else{
                if(lb == 0){
                    System.out.println(ub - lb);
                }else if(lb > 0 && b < points[ub]){
                    System.out.println(ub - lb);
                }else{
                    System.out.println(ub-lb+1);
                }
                
            }
        }
    }
    static int lower(int s, int e, int target){
        while(s < e){
            int mid = (s+e)/2;
            if(points[mid] < target){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return e;
    }
    static int upper(int s, int e, int target){
        while(s < e){
            int mid = (s+e)/2;
            if(points[mid] <=target){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return e;
    }
}