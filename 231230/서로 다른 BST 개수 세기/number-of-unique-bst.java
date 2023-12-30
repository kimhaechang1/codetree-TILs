import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int [] dp;
	public static void main(String [] args) throws Exception{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		// 왼쪽 자식노드로 올 수 있는 경우의 수 와
		// 오른쪽 자식노드로 올 수 있는 경우의 수를 탑다운 방식으로 메모
		// 즉, 왼쪽에 들어갈 수 있는 수로 만든 서로다른 BST개수 * 오른쪽에 들어갈 수 있는 수로 만든 BST 개수가 된다.
		// 루트를 기준으로 모든 경우의 합을 구해주면됨
		// 항상 왼쪽에는 
		dp = new int[20];
		Arrays.fill(dp, -1);
		dfs(19);
		System.out.print(dp[n]);
	}
	static int dfs(int n){
		if(dp[n] != -1){
			return dp[n];
		}
		if(n <= 1){
			return 1;
		}
		int cnt = 0;
		for(int i = 0;i<n;i++){
			cnt += dfs(i) * dfs(n - i - 1);
		}
		return dp[n] = cnt;
	}
}