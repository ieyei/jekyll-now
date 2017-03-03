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

## Matrix Chain Multiplication
* D[i][j] = 행렬의 곱셈 𝐴_𝑖 𝐴_(𝑖+1)…𝐴_(𝑗−1) 𝐴_𝑗을 계산하는데 필요한 최소 연산 횟수
* 초기값: D[i][i] = 0 for 1 ≤ i ≤ N
* 최종답: D[1][N]
* i 보다 같거나 크고 j 보다 작은 k에 대해 (𝐴_𝑖 𝐴_(𝑖+1)…𝐴_𝑘)(𝐴_(𝑘+1) 𝐴_(𝑘+2)…𝐴_𝑗) 가 마지막 곱셈인 경우
	- 필요한 최소 연산 횟수는 D[i][k] + D[k+1][j] + (a[i] * a[k+1] * a[j+1])
	- a[i] * a[k+1] * a[j+1] : 두 행렬의 곱을 계산하는데 필요한 연산 횟수
* D[i][j] = min(D[i][j], D[i][k]+D[k+1][j] + a[i]*a[k+1]*a[j+1]) for i ≤ k < j
* Hint : D[i][j]를 계산할 때 D[i][k]와 D[k+1][j] 값이 먼저 계산되어있어야 한다 => Memoization
``` java
cache = new int[N + 1][N + 1];
calculated = new boolean[N + 1][N + 1];

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
System.out.println("#" + ts + " " + dy(1, N));
```
[MCM.java](/java/MCM.java)

## Assembly Line Scheduling
* D[i][j] = 물건이 i번 생산라인의 j번째 공정에 있을 때, 오는데 걸리는 최소 시간
* 초기값:
D[1][1] = E[1] + S[1][1], 
D[2][1] = E[2] + S[2][1]
* 최종답: min(D[1][N] + X[1], D[2][N] + X[2])
* D[i][j] = min(D[i][j-1], D[3-i][j-1] + t[3-i][j-1]) + S[i][j]
* Hint : D[i][j]를 계산할 때 D[i][j-1]과 D[3-i][j-1] 값이 먼저 계산되어있어야 한다
``` java
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
```
[ALS.java](/java/ALS.java)

## Fibonacci
* 초기값: F[0] = 0, F[1] = 1
* 최종답: F[N]
* F[n] = F[n-1] + F[n-2] (for n >= 2)  (0 ≤ N ≤ 10^12)
[Fast Fibonacci algorithms] (https://www.nayuki.io/page/fast-fibonacci-algorithms)
``` java
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
```
[Fibonacci.java](/java/Fibonacci.java)
