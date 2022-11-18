package FindPw_17219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int site = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		
		Map<String, String> address = new HashMap<>(site);
		
		for(int i=0; i<site; i++) {
			st = new StringTokenizer(br.readLine());
			address.put(st.nextToken(),st.nextToken());
		}
		
		for(int i=0; i<find; i++) {
			String str = br.readLine();
			bw.write(address.get(str)+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}