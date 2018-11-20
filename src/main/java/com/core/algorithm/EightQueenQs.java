
package com.core.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lenovo
 * 八皇后算法
 */
public class EightQueenQs {

	int size;
	int resultCount;

	private void compute(int size) {
		this.size = size;
		this.resultCount = 0;

		int queens[] = new int[size];
		System.out.println(Arrays.toString(queens));
		List list = this.init(queens);
		System.out.println(list.size());
		for(int k=0;k<list.size();k++){
			if(test((int[]) list.get(k))){
				System.out.println(Arrays.toString((long[]) list.get(k)));
			}
		}

	}
	
	/**
	 * ��ʼ���������
	 * @param queens
	 * @return
	 */
	private List init(int[] queens){
		List list = new ArrayList();
		return list;
	}

	private boolean test(int[] queens) {
		int i, j;
		boolean flag = true;
		for (i = 0; i < queens.length; i++) {
			for (j = i + 1; j < 8; j++) {
				if (j - 1 > 0 && j + 1 < 8) {
					if (queens[i] == queens[j]) {
						flag = false;
					}
					if (queens[i] == queens[j - 1]) {
						flag = false;
					}
					if (queens[i] == queens[j + 1]) {
						flag = false;
					}
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		new EightQueenQs().compute(8);
		// int[] x = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		// System.out.println(new EightQueenQs().test(x));
	}

}