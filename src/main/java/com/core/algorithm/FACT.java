package com.core.algorithm;

import java.util.Scanner;

/** 实现阶乘 */
public class FACT {

	public static void main(String[] args) {
		int m;
		int data[] = new int[3268];
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();// 输入m的 求m!
		m = BigFact(m, data);
		System.out.print(data[m--]);
		while (m > 0)
			System.out.printf("%05d", data[m--]);
		System.out.println();
		scanner.close();
	}

	static int BigFact(int m, int data[]) {
		int i, j, k, index = 1;// index为位数
		int N = 100000;
		data[1] = 1;// 1!=1
		for (i = 1; i <= m; i++) {
			for (j = 1; j <= index; j++)// 模拟乘法
				data[j] *= i;
				System.out.println("i="+i+" j="+j+"  data[j]="+data[j]);
			for (k = 1; k < index; k++)// 进位
				if (data[k] >= N) {
					data[k + 1] += data[k] / N;
					data[k] %= N;
				}
			while (data[index] >= N)// 最高位进位
			{
				data[index + 1] = data[index] / N;
				data[index++] %= N;
			}
		}
		return index;
	}

}
