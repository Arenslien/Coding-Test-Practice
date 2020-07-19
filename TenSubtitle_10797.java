package koreanInfoOlympiad;

import java.io.IOException;
import java.util.Scanner;

public class TenSubtitle_10797 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int dayNum = sc.nextInt();
		sc.nextLine();
		String[] inputNums = sc.nextLine().split(" ");
		int cnt = 0;
		for(int i=0; i<5; i++) {
			if(Integer.parseInt(inputNums[i]) == dayNum) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
