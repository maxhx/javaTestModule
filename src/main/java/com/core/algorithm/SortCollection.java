
package com.core.algorithm;

/**
 * 排序算法集合
 * @author maihx
 */
public class SortCollection {

	public static void main(String[] args) {
	}

	/**
	 * 冒泡排序
	 * @param array
	 * @return 
	 */
	private static int[] BubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	private static int[] insertSort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			int j = 0;
			while (j <= i && array[j++] < array[i]);
			temp = array[i];
			for (int k = i; k >= j; k--) {
				array[i] = array[i - 1];
			}
			array[j] = temp;
		}
		return array;
	}

	/**
	 * 选择排序
	 * @param array
	 * @return
	 */
	private static int[] selectSort(int[] array) {
        int min;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min])
					min = j;
			}
			if (min != i) {//
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

	/**
	 * 部分排序
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] array, int low, int high) {
		int temp = array[low];//
		while (low < high) {//
			while (low < high && array[high] >= temp)
				high--;
			array[low] = array[high];
			while (low < high && array[low] <= temp)
				low++;
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}

	/**
	 * 快速排序
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private static int[] quickSort(int[] array,int low,int high){
		int loc;
		if(low<high){
			loc = partition(array,low,high);
			quickSort(array,low,loc-1);
			quickSort(array,loc+1,high);
		}
		return array;
	}
}