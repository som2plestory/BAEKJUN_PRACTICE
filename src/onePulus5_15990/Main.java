package onePulus5_15990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	/*
	 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. (1+3)(1+2+1)(3+1)
	 * 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
	 * 
	 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	 * 
	 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
	 * 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.
	 * 
	 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
	 * 
	 */

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			max = Math.max(n, max);
			list.add(n);
		}
		
		long[][] subCnt = new long[max+1][4];
		long[] count = new long[max+1];
		
		//초기값
		subCnt[1][1] = 1L;
		subCnt[2][2] = 1L;
		subCnt[3][1] = 1L;
		subCnt[3][2] = 1L;
		subCnt[3][3] = 1L;
		
		count[1] = 1L;
		count[2] = 1L;
		count[3] = 3L;
		
		//나머지귀납
		for(int i=4; i<max+1; i++) {
			subCnt[i][1] = (subCnt[i-1][2] + subCnt[i-1][3])%1000000009L;
			subCnt[i][2] = (subCnt[i-2][1] + subCnt[i-2][3])%1000000009L;
			subCnt[i][3] = (subCnt[i-3][1] + subCnt[i-3][2])%1000000009L;
			
			count[i] = (subCnt[i][1] + subCnt[i][2] + subCnt[i][3])%1000000009L;
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(count[list.get(i)]);
		}
		
		br.close();
	}
}
