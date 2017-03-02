import java.io.*;
import java.util.*;

public class Solution {
	public static int[][] cache;
	public static boolean[][] calculated;
	public static int[] A;

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){
			int N = Integer.parseInt(br.readLine());
	
			A = new int[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N + 1; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			cache = new int[N + 1][N + 1];
			calculated = new boolean[N + 1][N + 1];
	
			System.out.println("#" + ts + " " + dy(1, N));
		}
		br.close();
	}

	static int dy(int s, int e) {
		if (calculated[s][e])
			return cache[s][e];
		calculated[s][e] = true;
		if (s == e)
			return cache[s][e] = 0;
		int ret = Integer.MAX_VALUE;
		for (int k = s; k < e; k++) {
			int v = dy(s, k) + dy(k + 1, e) + A[s] * A[k + 1] * A[e + 1];
			ret = Math.min(ret, v);
		}
		return cache[s][e] = ret;
	}
}
