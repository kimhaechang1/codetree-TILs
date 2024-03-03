import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int q;
    static int [][] typeOfStone;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        typeOfStone = new int[n+1][4];
        for(int i= 1;i<n+1;i++){
            int num = Integer.parseInt(bf.readLine());
            typeOfStone[i][num] = 1;
        }
        int [][] s = new int[n+1][4];
        for(int type = 1;type<=3;type++){
            for(int i= 1;i<n+1;i++){
                s[i][type] = s[i-1][type] + typeOfStone[i][type];
            }
        }
        StringBuilder sb = new StringBuilder();
        while(q-- > 0){
            stk =new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b= Integer.parseInt(stk.nextToken());
            for(int type = 1;type<=3;type++){
                sb.append(s[b][type] - s[a-1][type]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}