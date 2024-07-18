import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int k;
    public static void main(String[] args)  throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        // 1 ~ N 번호표를 든 N명의 사람
        // 1 ~ N 까지 번호가 매겨진 자리에 번호 순서대로 앉아있따.
        // 1 ~ K분까지 반복해서 바꿔지는 순서대로 바꾼다.
        // 3K 번에 걸쳐 자리바꿈이 진행될 동안 각자 몇 군데의 자리에 앉을 수 있는지 구하는 프로그램
        int cnt = 0;
        HashSet<Integer> [] set = new HashSet[n+1];
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = i+1;
            set[i+1] = new HashSet<>();
        }
        for(int i = 0;i<n;i++){
            set[arr[i]].add(i);
        }
        int [][] changes = new int[k][2];
        for(int i= 0;i<k;i++){
            stk = new StringTokenizer(bf.readLine());
            changes[i][0] = Integer.parseInt(stk.nextToken())-1;
            changes[i][1] = Integer.parseInt(stk.nextToken())-1;
        }
    
        while(cnt < k * 3){
            int idx1 = arr[changes[cnt % k][0]];
            int idx2 = arr[changes[cnt % k][1]];
            swap(arr, changes[cnt % k][0], changes[cnt % k][1]);
            set[idx1].add(changes[cnt % k][1]);
            set[idx2].add(changes[cnt % k][0]);
            cnt++;
        }   
        StringBuilder sb = new StringBuilder();     
        for(int i = 1;i<set.length;i++){
            sb.append(set[i].size()).append("\n");
        }
        System.out.print(sb);
    }
    static void swap(int [] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}