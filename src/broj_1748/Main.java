package broj_1748;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	/*
	 * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
	 * 	1234567891011121314151617181920212223...
	 * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
	 * 
	 * 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
	 * 첫째 줄에 새로운 수의 자릿수를 출력한다.
	 */
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = 1;
		int d = 10;
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			if(i%d == 0) {
				m++;
				d = d*10;
			}
			result += m;
		}
		
		System.out.println(result);
		sc.close();
	}

}
