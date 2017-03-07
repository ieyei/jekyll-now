## 2차원 배열 정렬하기
``` java
import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){
			// Input value
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// N(1≤N≤20)
			K = Integer.parseInt(st.nextToken());	// K(1≤K≤N)
			
			int[][] A = new int[N+1][N+1];
			for(int i=1; i<=N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++){
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Arrays.sort(A, new Comparator<int[]>(){

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					final int tmp1 = o1[K];
					final int tmp2 = o2[K];
						return Integer.compare(tmp1, tmp2);
				}
				
			});
			
			System.out.println("#" + ts );
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					System.out.print(A[i][j] + " ");   
				}
				System.out.println(); 
			}
			
		}
	}
}

```
