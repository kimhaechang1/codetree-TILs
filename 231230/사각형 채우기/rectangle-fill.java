import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static long [] dp;
	public static void main(String [] args) throws Exception{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		dp = new long[1004];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 5;
		dp[5] = 8;
		for(int i = 3;i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		System.out.print(dp[n]);
	}
}