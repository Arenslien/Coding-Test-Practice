package koreanInfoOlympiad;

import java.io.IOException;
import java.util.Scanner;

public class VerticalReading_10798 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[][] inputChars = new String[5][15];
		
		//input
		for(int i=0; i<5; i++) {
			String[] line = sc.nextLine().split("");
			for(int j=0; j<line.length; j++) {
				inputChars[i][j] = line[j];
			}
		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(inputChars[j][i] != null) {
					System.out.print(inputChars[j][i]);
				}
			}
		}
		sc.close();
	}

}
