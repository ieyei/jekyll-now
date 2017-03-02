## Input
``` java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 한 줄에 정수 하나가 주어지는 경우
int N = Integer.parseInt(br.readLine());

// 한 줄에 정수 N개가 공백으로 분리되어 주어지는 경우
int[] A = new int[N];
StringTokenizer st = new StringTokenizer(br.readLine()); 
for (int i = 0; i < N; i ++) {
    A[i] = Integer.parseInt(st.nextToken());
}
br.close();
```
## Output
``` java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

bw.write("#" + ts + " " + ans);
bw.newLine();
bw.flush();

bw.close();
```
