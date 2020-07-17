package koreanInfoOlympiad;

import java.io.IOException;
import java.util.Scanner;

public class SevenDwarf_2309 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int[] answer = new int[7];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		

		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i==j) break;
				if(sum - (height[i] + height[j]) == 100) {
					
				}
			}
		}
		
		//bubble sort
		for(int i=0; i<6; i++) {
			for(int j=0; j<6-i; j++) {
				if(height[j] > height[j+1]) {
					int cnt = height[j];
					height[j] = height[j+1];
					height[j+1] = cnt;
				}
			}
		}
		for(int i=0; i<7; i++) {
			System.out.println(height[i]);
		}
		sc.close();
	}
}
