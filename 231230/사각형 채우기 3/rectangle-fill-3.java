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
		// n = 2 에서 3으로 넘어가는 과정을 보면
		// =| 모양이 3개 나오므로 결국 dp[2] * 3
		// 추가적으로 막대모양은 2*1의 경우를 만드는 방법이므로 dp[i-2] 가 된다.
		// + dp[i-2]
		// 
		for(int i = 3;i<=n;i++) {
			dp[i] = (dp[i-1] * 3 + dp[i-2] - dp[i-3]) % 1_000_000_007;
		}
		System.out.print(dp[n]);
	}
}