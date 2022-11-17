package HowManyIslands_4963;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	/*
	 * 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
	 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 
	 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
	 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
	 * 
	 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 
	 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
	 * w와 h는 50보다 작거나 같은 양의 정수이다.
	 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
	 * 입력의 마지막 줄에는 0이 두 개 주어진다.
	 */
	static int[] x= {-1,1,0,0,1,1,-1,-1};
	static int[] y= {0,0,1,-1,1,-1,1,-1};
	static boolean[][] check;
	static int[][] map;
	static int w;
	static int h;
	
	static void dfs(int i, int j) {
		for(int k=0; k<8; k++) {
			int row = i+y[k];
			int col = j+x[k];
			
			if(col>=0 && row>=0 && col<w && row<h && map[row][col]==1 && check[row][col]==false) {
				check[row][col]=true;
				dfs(row, col);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;
			
			int n=0;
			map = new int[h][w];
			check = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && check[i][j]==false) {
						check[i][j]=true;
						dfs(i,j);
						n++;
					}
				}
			}
			
			System.out.println(n);
		}
		
		
		sc.close();
	}

}
