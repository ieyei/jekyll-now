import java.io.*;
import java.util.*;

public class Solution {
	static int N, W;
	static int[] A, D;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = new int[N+1];
			for (int i=1;i<=N;i++) 
				A[i] = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(br.readLine());

			D = new int[W+1];
			for (int i=1;i<=W;i++){
				D[i] = (int)2e9;
				for (int j=1;j<=N;j++){ 
					if (i-A[j] >= 0)
						D[i] = Math.min(D[i], D[i-A[j]] + 1);
				}
			}

			System.out.println("#" + ts + " " + D[W]);
		}
		br.close();
	}
}
