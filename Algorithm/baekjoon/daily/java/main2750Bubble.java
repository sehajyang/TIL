/*
 * 181017
 * 백준 2750
 * 버블정렬
 * */

package daily.java;

public class main2750Bubble {
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr, arr.length - 1);
		// 배열을 받아서 재귀함수 호출
	}

	private static void bubbleSort(int[] arr, int last) {
		if (last > 0) {
			// 마지막 인덱스(last)가 0보다 클때까지 재귀함수 호출
			for (int i = 1; i < last; i++) {
				if (arr[i - 1] > arr[i]) {
					swap(arr, i - 1, i);
					// 앞 숫자가 나보다 크면 swap
				}
			}
			bubbleSort(arr, last - 1);
		}
	}

	private static void swap(int[] arr, int source, int target) {
		// 스왑 해주는 함수
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}

	private static void printArray(int[] arr) {
		// 결과 출력
		for (int data : arr) {
			System.out.printf(data + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 4, 2, 1 };
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}

// 출처 : https://www.youtube.com/watch?v=YbsQiiubO74