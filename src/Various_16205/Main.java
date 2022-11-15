package Various_16205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 변수명을 정하는 표기법은 여러 가지가 있다.
	 * 	카멜 표기법 (Camel Case): 각 단어의 첫 글자를 대문자로 적는다. 단, 가장 첫 글자는 소문자를 사용한다.
	 * 	스네이크 표기법 (Snake Case): 소문자만 사용하고, 각 단어의 사이에 언더바(_)를 넣어서 적는다.
	 *  파스칼 표기법 (Pascal Case): 카멜 표기법과 같지만, 가장 첫 글자도 대문자를 사용한다.
	 *  
	 * 한 표기법을 사용한 변수명이 주어졌을 때, 이를 다른 표기법으로 변환하는 프로그램을 작성하시오.
	 * 
	 * 첫째 줄에 사용한 표기법의 번호와 변수명이 주어진다. 
	 * 번호가 1인 경우는 카멜 표기법, 2인 경우는 스네이크 표기법, 3인 경우는 파스칼 표기법이다.
	 * 입력으로 주어지는 변수명의 길이는 100을 넘지 않는다.
	 * 카멜 표기법, 파스칼 표기법을 사용한 변수명은 알파벳 소문자와 대문자로만 이루어져 있고, 
	 * 스네이크 표기법을 사용한 변수명은 알파벳 소문자와 언더바(_)로만 이루어져 있다. 
	 * 또, 스네이크 표기법을 사용한 변수명의 첫 글자와 마지막 글자는 언더바가 아니고, 언더바가 연속해서 두 개 이상 사용하는 경우는 없다.
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		String[] sArr = str.split("");

		switch(n) {
			case 1:
				bw.write(str);
				bw.newLine();
				String str0 = "";
				for(int i=0; i<str.length(); i++) {
					if(Character.isUpperCase(str.charAt(i))) str0 += "_";
					str0 += sArr[i];
				}
				bw.write(str0.toLowerCase());
				bw.newLine();
				
				bw.write(str.replaceFirst(sArr[0], sArr[0].toUpperCase()));
				break;
			
			case 2:
				String str2 = "";
				str2 += sArr[0];
				for(int i=1; i<sArr.length; i++) {
					if(sArr[i-1].equals("_")) str2 += sArr[i].toUpperCase();
					else if(!sArr[i].equals("_")) str2 += sArr[i];
				}
				bw.write(str2);
				bw.newLine();
				
				bw.write(str);
				bw.newLine();
				
				bw.write(str2.replaceFirst(sArr[0], sArr[0].toUpperCase()));
				break;
			
			default:
				String str1 = str;
				bw.write(str1.replaceFirst(sArr[0], sArr[0].toLowerCase()));
				bw.newLine();
				
				str1 = sArr[0];
				for(int i=1; i<str.length(); i++) {
					if(Character.isUpperCase(str.charAt(i))) str1 += "_"; 
					str1 += sArr[i];
				}
				bw.write(str1.toLowerCase());
				bw.newLine();
				
				bw.write(str);
				
				break;
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
