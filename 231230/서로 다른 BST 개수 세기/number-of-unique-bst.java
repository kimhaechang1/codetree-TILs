import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static long [] dp;
	public static void main(String [] args) throws Exception{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		dp = new long[19];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;
		for(int i = 3;i<=n;i++) {
			dp[n] = dp[n-1] * 2 + dp[n-2];
		}
		System.out.println(dp[n]);
	}
}