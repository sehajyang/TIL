/*
 * 181015
 * 백준 2750
 * 퀵정렬
 * 소스보고 다시 이해하기
 * */

package daily.java;
import java.util.Arrays;

public class main2750Quick {
	public static void main(String[] args) {
		main2750Quick qsort = new main2750Quick();
		int[] arr = {5,5,1,4,3,2};
		qsort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void sort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = wall(arr, start, end);
			quicksort(arr, start, pivot - 1);
			quicksort(arr, pivot + 1, end);
		}
	}

	private int wall(int[] arr, int start, int end) {
		int pivot = end;
		int wall = start;
		int left = start;
		
		while (left < pivot) {
			if (arr[left] < arr[pivot]) {
				swap(arr, wall, left);
				wall = wall + 1;
			}
			left = left + 1;
		}
		swap(arr, wall, pivot);
		pivot = wall;
		return pivot;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

//출처 : https://github.com/minsuk-heo/java_coding_interview/blob/master/src/Sorts/MyQuickSort.java