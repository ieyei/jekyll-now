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
