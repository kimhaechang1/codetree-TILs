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
            System.out.println(ub - lb);
            
        }
    }
    static int lower(int s, int e, int target) {
        int left = s;                          // 첫 번째 원소의 위치로 설정합니다.
        int right = e;                     // 마지막 원소의 위치로 설정합니다.
        int minIdx = n;                        // 최소이므로, 답이 될 수 있는 값보다 더 큰 값으로 설정합니다.
        while (left <= right) {                // [left, right]가 유효한 구간이면 계속 수행합니다.
            int mid = (left + right) / 2;      // 가운데 위치를 선택합니다.
            if(points[mid] >= target) {           // 만약에 선택한 원소가 target보다 같거나 크다면 
                right = mid - 1;               // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
                minIdx = Math.min(minIdx, mid);// 같거나 큰 값들의 위치 중 최솟값을 계속 갱신해줍니다.
            }
            else                               
                left = mid + 1;                // 작은 경우라면 left를 바꿔줍니다.
        }

        return minIdx;                         // 조건을 만족하는 최소 index 값을 반환합니다.
    }
    static int upper(int s, int e, int target){
        int left = s;
        int right = e;
        int minIdx = n;
        while(left <= right){
            int mid = (left + right) / 2;
            if(points[mid] > target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1;
            }
        }
        return minIdx;
    }
}