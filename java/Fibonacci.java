import java.io.*;
import java.util.*;

public class test {
	static long N;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){
			N = Long.parseLong(br.readLine()); // (0 ≤ N ≤ 10^12)
			System.out.println("#" + ts + " " + fibo(N));
		}
	}
	static int fibo(long n){
		if(n < 2) return (int)n;
		Matrix now = new Matrix(1,0,0,1);
		
		Matrix v = new Matrix(1,1,1,0);
		
		/* Repeated Squaring */
		for(long p=n-1; p>0; p>>=1, v=v.multiply(v)){
			if(p % 2 == 1)
				now = now.multiply(v);
		}
		
		return now.m[0][0];
	}
	
	static class Matrix{
		static final int MOD = (int)1e9 + 7;
		int[][] m;
		public Matrix(int a, int b, int c, int d){
			m = new int[2][2];
			m[0][0] = a;
			m[0][1] = b;
			m[1][0] = c;
			m[1][1] = d;
		}
		
		public Matrix multiply(Matrix ot){
			Matrix ret = new Matrix(0,0,0,0);
			for(int i=0; i<2; i++){
				for(int j=0; j<2; j++){
					for(int k=0; k<2; k++){
						ret.m[i][j] = (int)((ret.m[i][j] + (long)m[i][k]*ot.m[k][j]) % MOD);
					}
				}
			}
			return ret;
		}
	}
}
