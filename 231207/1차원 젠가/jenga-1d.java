import java.util.*;
import java.io.*;

public class Main {
    static int arrlen;
    static int templen;
    static int [] arr;
    static int [] temp;
    static int n;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arrlen = n;
        arr = new int[n];
        templen = 0;
        temp = new int[n];
        for(int i = n-1;i>-1;i--){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for(int i = 0;i<2;i++){
            stk = new StringTokenizer(bf.readLine());
            templen = 0;
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken())-1;
            for(int j = start;j<=end;j++){
                arr[j] = 0;
            }
            
            // 떨어뜨리기
            for(int j = 0;j<arrlen;j++){
                if(arr[j]!= 0){
                    temp[templen++] = arr[j];
                }
            }
            // 떨어뜨린 결과 반영하기
            for(int j = 0;j<templen;j++){
                arr[j] = temp[j];
            }
            // 떨어뜨렸으므로 줄어든 길이만큼 사용하게 만들기
            arrlen = templen;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arrlen).append("\n");
        for(int i = arrlen-1;i>-1;i--){
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
    
}