
package algorithm;

/**
 *
 * SortCollection
 * @author maihaixian
 * @time Jul 30, 2012 9:10:20 AM
 * @version
 */
public class SortCollection {

	public static void main(String[] args) {
	}

	private static int[] BubbleSort(int[] array) {//冒泡排序
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

	private static int[] insertSort(int[] array) {// 插入排序
		int temp;
		for (int i = 1; i < array.length; i++) {
			int j = 0;
			while (j <= i && array[j++] < array[i]);// �Ҳ����
			temp = array[i];
			for (int k = i; k >= j; k--) {// ��λ
				array[i] = array[i - 1];
			}
			array[j] = temp;// ����
		}
		return array;
	}

	private static int[] selectSort(int[] array) {// 选择排序
        int min;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min])
					min = j;
			}
			if (min != i) {// ��Сֵ����*λ�ͽ���
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

	private static int partition(int[] array, int low, int high) {// 部分排序
		int temp = array[low];// ȡ��һλ��Ϊ���,С������,��������
		while (low < high) {// �ٽ�Ϊ=
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

	private static int[] quickSort(int[] array,int low,int high){//快速排序
		int loc;//[low*-->][#][#][#][loc][#][#][#][#][<--*high]
		if(low<high){
			loc = partition(array,low,high);//�õ����λ��
			quickSort(array,low,loc-1);//��ߵ���
			quickSort(array,loc+1,high);//�ұߵ���
		}
		return array;
	}
}