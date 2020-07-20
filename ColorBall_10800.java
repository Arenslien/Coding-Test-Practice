package koreanInfoOlympiad;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class ColorBall_10800 {
	public static void main(String[] args) throws IOException {
		//initial setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ballNum = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[ballNum]; // 순서대로 ball 입력해서 넣는 배열
		Ball[] result = new Ball[ballNum]; // 출력할 배열
		int[] ballSizes = new int[ballNum + 1]; //index가 Color, Color별로 size총 집합
		int allBallSize = 0; // 모든 ball의 size 합
		
		//input
		for(int i=0; i<ballNum; i++) {
			String[] line = br.readLine().split(" ");
			int color = Integer.parseInt(line[0]);
			int size = Integer.parseInt(line[1]);
			balls[i] = new Ball(color, size);
			result[i] = balls[i];
		}
		
		//logic
		//1. merge sort
		mergeSort(balls);
		
		//2. 전체 공들의 크기 증가, 각각의 공들의 크기 증가
		for(int i=0; i<balls.length; i++) {
			balls[i].setLowerSize(allBallSize - ballSizes[balls[i].getColor()]);
			ballSizes[balls[i].getColor()] += balls[i].getSize();
			allBallSize += balls[i].getSize();
		}
		
		//result
		for(int i=0; i<balls.length; i++) {
			System.out.println(balls[i].getColor() + " " + balls[i].getSize());
		}
		
		for(int i=0; i<balls.length; i++) {
			System.out.println(result[i].getLowerSize());
		}
		
		
	}
	
	public static void mergeSort(Ball[] arr) {
		Ball[] tmp = new Ball[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}
	
	private static void mergeSort(Ball[] arr, Ball[] tmp, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	
	private static void merge(Ball[] arr, Ball[] tmp, int start, int mid, int end) {
		for(int i = start; i<= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (tmp[part1].getSize() <= tmp[part2].getSize()) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i=0; i<=mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
}

class Ball {
	private int color;
	private int size;
	private int lowerSize;
	
	public Ball(int color, int size) {
		this.color = color;
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	public int getLowerSize() {
		return lowerSize;
	}

	public void setLowerSize(int lowerSize) {
		this.lowerSize = lowerSize;
	}
	
}
