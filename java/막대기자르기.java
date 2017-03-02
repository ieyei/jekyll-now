import java.io.*;
import java.util.*;

public class 막대기자르기 {
	static int[] D, A;
	
	public static void main(String[] args) throws Exception {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1; ts<=T; ts++){
			int N = Integer.parseInt(br.readLine());
			A = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1;i<=N;i++) 
				A[i] = Integer.parseInt(st.nextToken());
			
			D = new int[N+1];
			for (int i=1;i<=N;i++){
				for (int j=1;j<=i;j++){ 
					D[i] = Math.max(D[i], D[i-j]+A[j]);
				}
			}
			System.out.println("#" + ts + " " + D[N]);
		}
		br.close();
	}
}
