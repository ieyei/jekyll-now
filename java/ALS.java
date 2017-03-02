import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] E, X;
	static int[][] S, T, D;

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int testcase = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=testcase; ts++){
			// Input
			StringTokenizer st = new StringTokenizer(br.readLine());
			E = new int[3];
			X = new int[3];
			
			N = Integer.parseInt(st.nextToken());
			E[1] = Integer.parseInt(st.nextToken());
			E[2] = Integer.parseInt(st.nextToken());
			X[1] = Integer.parseInt(st.nextToken());
			X[2] = Integer.parseInt(st.nextToken());

			S = new int[3][N + 1];
			T = new int[3][N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				S[1][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				S[2][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N - 1; i++) {
				T[1][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N - 1; i++) {
				T[2][i] = Integer.parseInt(st.nextToken());
			}

			D = new int[3][N + 1];
			// initial value
			for (int i = 1; i < 3; i++)
				D[i][1] = E[i] + S[i][1];
			
			for (int j = 2; j <= N; j++) {
				for (int i = 1; i < 3; i++) {
					D[i][j] = Math.min(D[i][j - 1], D[3 - i][j - 1] + T[3 - i][j - 1]) + S[i][j];
				}
			}
			System.out.println("#" + ts + " " + Math.min(D[1][N] + X[1], D[2][N] + X[2]));
		}
		br.close();
	}
}
