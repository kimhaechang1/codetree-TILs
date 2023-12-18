import java.util.*;
import java.io.*;

public class Main {
    static char [] equation;
    static int [] alpa2Num;
    static int max = -9999999;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        equation = bf.readLine().toCharArray();
        alpa2Num = new int[6];
        dfs(0);
        System.out.print(max);
    }
    static void dfs(int depth){
        if(depth == 6){
            int res = alpa2Num[equation[0]-'a'];
            for(int i = 1;i<equation.length;i+=2){
                    switch(equation[i]){
                        case '+':
                            res += alpa2Num[equation[i+1] - 'a'];
                            break;
                        case '-':
                            res -= alpa2Num[equation[i+1] - 'a'];
                            break;
                        case '*':
                            res *= alpa2Num[equation[i+1] - 'a'];
                            break;
                    }
                }
            
            max = Math.max(max, res);

            return;
        }
        for(int i = 1;i<=4;i++){
            alpa2Num[depth] = i;
            dfs(depth+1);
        }
    }
}