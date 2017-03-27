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
## 부동소수점 (float와 double 연산의 부정확성)
``` java
double d1 = 3;
double d2 = 0.01;
System.out.println(d1 + d2);    // prints 3.8099999999999996 

double d3 = 2.4;
double d4 = 0.8;
System.out.println(d3 / d4);    // prints 2.9999999999999996 

import java.math.BigDecimal;
......
BigDecimal d1 = new BigDecimal("2.4");
BigDecimal d2 = new BigDecimal("0.8");
System.out.println(d1.divide(d2));      // prints 3
```
[float와 double 연산의 부정확성](http://gwpark.tistory.com/1729)

## Disjoint Set(서로소)
서로소 집합의 연산으로 Union-Find가 있으며, Union-Find를 빠르게 구현하기 위해 경로 압축을 한다
* Union Find
* Path Compression
``` java
par = new int[N+1];
for (int i=1;i<=N;i++) par[i] = i; 	
	
static int find(int n) {
	if (par[n] == n) return n;
	return par[n] = find(par[n]);
}
 
static void union(int a, int b) {
	int p = find(a), q = find(b);
	if (p == q) return;
	par[q] = p;
}
```
## 최단거리 알고리즘
* Bellman-Ford (시작점이 정해져있고, 음수간선 가능)
* Dijkstra (시작점이 정해져있고, 음수간선 불가능)
* Floyd-Warshall (시작점이 정해져있지 않아도 됨)
* BFS (시작점이 정해져있고, 간선 가중치가 모두 1)
