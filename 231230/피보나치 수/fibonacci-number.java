import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int [] fibo;
	public static void main(String [] args) throws Exception{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		fibo = new int[n+3];
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 1;
		for(int i = 3;i<=n;i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.print(fibo[n]);
	}
}