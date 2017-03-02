# Dynamic Programming

## 폐지줍기
* D[i][j] = 시작 지점에서 i행 j열로 올 때, 지나온 격자 칸에 적힌 수 합의 최대값  
	- D[i][j] = max(D[i-1][j], D[i][j-1]) + A[i][j]  
* 초기값: D[1][1] = A[1][1]  
* 최종답: D[N][N]  
``` java
D = new int[N+1][N+1];
for(int i=1; i<=N; i++){
  for(int j=1; j<=N; j++){
	  if(i==1 && j==1) D[i][j] = A[i][j];
	  if(i > 1)
		  D[i][j] = Math.max(D[i][j], D[i-1][j] + A[i][j]);
	  if(j > 1)
		  D[i][j] = Math.max(D[i][j], D[i][j-1] + A[i][j]);
  }
}
```
[폐지줍기.java](/java/폐지줍기.java)

## 막대기 자르기
* D[i] = 길이가 i인 막대기를 자를 때 조각들의 값어치 합의 최대값
	- D[i] = max(D[i-j] + P[j]) for 1 ≤ j ≤ i
* 초기값 D[0] = 0
* 최종답: D[N}
``` java
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
```
[막대기 자르기.java](/java/막대기자르기.java)
