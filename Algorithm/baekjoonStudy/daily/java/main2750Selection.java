/*
 * 181018
 * 백준 2750
 * 선택정렬
 * */

package daily.java;

public class main2750Selection {
	private static void selectionSort(int[] arr) {
		selectionSort(arr, 0); // 재귀함수 호출

	}

	private static void selectionSort(int[] arr, int start) {
		if (start < arr.length - 1) {
			// start가 배열 마지막보다 작은 동안 재귀함수 호출
			int min_index = start;
			for (int i = start; i < arr.length; i++) {
				if (arr[i] < arr[min_index]) {
					min_index = i;
				}
				swap(arr, start, min_index);
				selectionSort(arr, start+1); //start의 그 다음부터 찾음 (앞에껀 다 정렬 됨)
			}
		}
	}

	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data+",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {2,4,5,1,7,8,0};
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
	}

}
