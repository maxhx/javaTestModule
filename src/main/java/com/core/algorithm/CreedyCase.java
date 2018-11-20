
package com.core.algorithm;

import java.util.*;

/** 
* @ClassName: CreedyCase 
* @Description: 贪婪算法Demo
* @author maihx
* 创建时间 2017年4月23日 上午11:14:39 
*  
*/
public class CreedyCase {
	//测试任务
	public static void main(String[] args) {
		//随机构造一批任务
		List<Pair<Integer>> inputList = new ArrayList<Pair<Integer>>();
		Random rand = new Random();
		for (int n = 0; n < 20; ++n) {
			Integer left = rand.nextInt(100);
			Integer right = left + rand.nextInt(100) + 1;
			Pair<Integer> pair = new Pair<Integer>(left, right);
			inputList.add(pair);
		}
		//将任务列表按结束时间排序（也就是根据right字段进行排序）
		sortByRight(inputList);
		printPairList(inputList);
		// 执行算法
		List<Pair<Integer>> outputList = algorithm(inputList);
		System.out.println();
		printPairList(outputList);
	}

	/** 
	* @Title: algorithm 
	* @Description: 贪婪算法
	* @param inputList
	* @return List<Pair<T>> 使数量最多的任务方案
	* @throws
	* @author Administrator 创建时间:2017年4月23日 上午11:31:22 
	*/
	public static <T extends Comparable<T>> List<Pair<T>> algorithm(
			List<Pair<T>> inputList) {
		if (null == inputList || inputList.size() == 0 || inputList.size() == 1) {
			return inputList;
		}
		sortByRight(inputList);
		List<Pair<T>> outputList = new ArrayList<Pair<T>>();
		int last = 0;
		outputList.add(inputList.get(last));
		int intputSize = inputList.size();
		for (int m = 1; m < intputSize; ++m) {
			Pair<T> nextPair = inputList.get(m);
			T nextLeft = nextPair.getLeft();
			Pair<T> lastOutPair = inputList.get(last);
			T lastRight = lastOutPair.getRight();
			int flag = nextLeft.compareTo(lastRight);
			if (flag >= 0) {
				outputList.add(nextPair);
				last = m;
			}
		}

		return outputList;
	}

	/** 
	* @Title: sortByRight 
	* @Description: 对传入的List<Pair<T>>对象进行排序，使Pair根据right从小到大排序。
	* @param inputList void
	* @throws
	* @author Administrator 创建时间:2017年4月23日 上午11:23:16 
	*/
	private static <T extends Comparable<T>> void sortByRight(
			List<Pair<T>> inputList) {
		CompareByRight<T> comparator = new CompareByRight<T>();
		Collections.sort(inputList, comparator);
	}

	/** 
	* @Title: printPairList 
	* @Description: 打印一个List<Pair<T>>对象。
	* @param inputList void
	* @throws
	* @author Administrator 创建时间:2017年4月23日 上午11:23:04 
	*/
	private static <T extends Comparable<T>> void printPairList(
			List<Pair<T>> inputList) {
		for (Pair<T> pair : inputList) {
			System.out.println(pair.toString());
		}
	}
}


/** 
* @ClassName: CompareByRight 
* @Description: 根据Pair.right比较两个Pair。用于Conlections.sort()方法。 
* @author Administrator
* 创建时间 2017年4月23日 上午11:22:34 
* 
* @param <T> 
*/
class CompareByRight<T extends Comparable<T>> implements Comparator<Pair<T>> {
	public int compare(Pair<T> o1, Pair<T> o2) {
		T r1 = o1.getRight();
		T r2 = o2.getRight();
		int flag = r1.compareTo(r2);
		return flag;
	}
}

/** 
* @ClassName: Pair 
* @Description: 代表一个任务对象。有点装逼用模板来写了。left表示开始时间，right表示结束时间。
* @author Administrator
* 创建时间 2017年4月23日 上午11:22:54 
* 
* @param <T> 
*/
class Pair<T extends Comparable<T>> {
	private T left;
	private T right;

	public Pair(T left, T right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "[left=" + left.toString() + ',' + "right=" + right.toString()
				+ ']';
	}

	public T getLeft() {
		return left;
	}

	public void setLeft(T left) {
		this.left = left;
	}

	public T getRight() {
		return right;
	}

	public void setRight(T right) {
		this.right = right;
	}
}