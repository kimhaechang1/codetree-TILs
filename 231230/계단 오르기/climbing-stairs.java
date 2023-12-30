import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static long [] dp;
	public static void main(String [] args) throws Exception{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		dp = new long[1004];
		dp[0] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 4;i<=n;i++) {
			dp[i] = (dp[i-2] + dp[i-3]) % 10007;
		}
		//System.out.println(Arrays.toString(dp));
		System.out.print(dp[n] == 0 ? 0 : dp[n]);
	}
}