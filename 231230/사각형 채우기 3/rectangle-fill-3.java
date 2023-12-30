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
		dp[1] = 2;
		dp[2] = 7;
		dp[3] = 22;
		// 부분 문제로 나눠서 생각했을때 경우를 생각하자
		// 옆에 세로줄 하나 채워야 할 때 나올 수 있는 모양의 경우는 2가지다.
		// 옆에 2 * 2 를 채워야 할 때 나올 수 있는 모양의 수는 3가지이다.
		// 추가적으로 결국 n에서 미리 채워져 있다고 가정한 경우 k만큼을 지정하고
		// 나머지를 매꿀때 새로운 모양이 나오는 경우는 항상 2가지가 존재한다.
		// 따라서 점화식은 dp[n] = dp[n-1] * 2 + dp[n-2] * 3 + 2 * (dp[n-k]) 가 된다.
		long mod = 1_000_000_007;
		for(int i = 3;i<=n;i++) {
			dp[i] = (dp[i-1] * 2 + dp[i-2] * 3) % mod;
			for(int j = i-3;j>-1;j--) {
				dp[i] = (dp[i] + dp[j] * 2) %mod;
			}
		}
		System.out.print(dp[n]);
	}
}