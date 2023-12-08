import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int [] arr;
    static StringTokenizer stk;
    static int arrlen;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        arrlen = N;
        while(boom()){
            go();
        }
        print();
    }
    static boolean boom(){
        if(arrlen == 0) return false;
        int prev = arr[N - arrlen];
        int s = N - arrlen;
        int e = 0;
        int c = 0;
        boolean flg = false;
        for(int i = N - arrlen;i<N;i++){
            if(prev== arr[i]){
                c++;
                e = i;
            }else{
                prev = arr[i];
                if(c >= M){
                    flg = true;
                    for(int j= s;j<=e;j++){
                        arr[j] = 0;
                    }
                }
                c = 1;
                s = i;
                e = i;
            }
        }
        if(c >= M){
            flg = true;
            for(int i = s;i<=e;i++){
                arr[i] = 0;
            }
        }
        return flg;
    }
    static void go(){
        int [] temp = new int[N];
        int tempidx = N-1;
        for(int i = N-1;i>N - 1 - arrlen;i--){
            if(arr[i] != 0){
                temp[tempidx--] = arr[i];
            }
        }
        for(int i = N-1;i>tempidx;i--){
            arr[i] = temp[i];
        }
        arrlen = N - tempidx - 1;
    }
    static void print(){
        StringBuilder sb =new StringBuilder();
        sb.append(arrlen).append("\n");
        for(int i = N-arrlen;i<N;i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}