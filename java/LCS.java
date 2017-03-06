import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static char[] A, B;
	static int[][] D, E;

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){			
			String str = br.readLine();
			int M = str.length();
			B = new char[M + 1];
			for (int i=1;i<=M;i++){ 
				B[i] = str.charAt(i-1);
			}
			
			str = br.readLine();
			int N = str.length();
			A = new char[N + 1];
			for (int i=1;i<=N;i++){ 
				A[i] = str.charAt(i-1);
			}
			
			D = new int[N+1][M+1]; 
			E = new int[N+1][M+1]; // 경로저장 
			for (int i=1;i<=N;i++) for (int j=1;j<=M;j++){
				if (D[i-1][j] > D[i][j-1]){
					D[i][j] = D[i-1][j]; E[i][j] = 1; // 위
				}
				else{
					D[i][j] = D[i][j-1]; E[i][j] = 2; // 왼
				}
				if (A[i] == B[j] && D[i][j] < D[i-1][j-1]+1){
					D[i][j] = D[i-1][j-1]+1; E[i][j] = 3; // 대각선
				}
			}
			
			StringBuilder ans = new StringBuilder();
			for (int i=N,j=M;i>0&&j>0;){
				if (E[i][j] == 1) i--;
				else if (E[i][j] == 2) j--;
				else{
					ans.append(A[i]);
					i--; j--;
				}
			}
			ans.reverse();
			
			System.out.println("#" + ts + " " + ans );
		}
		br.close();
	}
}
