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
