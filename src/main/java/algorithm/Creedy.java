
package algorithm;

import java.util.*;

public class Creedy {

	/**
	 * ����
	 */
	public static void main(String[] args) {
		// 1.�����һ������
		List<Pair<Integer>> inputList = new ArrayList<Pair<Integer>>();
		Random rand = new Random();
		for (int n = 0; n < 20; ++n) {
			Integer left = rand.nextInt(100);
			Integer right = left + rand.nextInt(100) + 1;
			Pair<Integer> pair = new Pair<Integer>(left, right);
			inputList.add(pair);
		}
		// �������б?����ʱ������Ҳ���Ǹ��right�ֶν�������
		sortByRight(inputList);
		printPairList(inputList);
		// ִ���㷨
		List<Pair<Integer>> outputList = algorithm(inputList);
		System.out.println();
		printPairList(outputList);
	}

	/**
	 * ̰���㷨
	 * 
	 * @param inputList
	 * @return ʹ�����������񷽰�
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
	 * �Դ����List<Pair<T>>�����������ʹPair���right��С��������
	 * 
	 * @param inputList
	 */
	private static <T extends Comparable<T>> void sortByRight(
			List<Pair<T>> inputList) {
		CompareByRight<T> comparator = new CompareByRight<T>();
		Collections.sort(inputList, comparator);
	}

	/**
	 * ��ӡһ��List<Pair<T>>����
	 * 
	 * @param inputList
	 */
	private static <T extends Comparable<T>> void printPairList(
			List<Pair<T>> inputList) {
		for (Pair<T> pair : inputList) {
			System.out.println(pair.toString());
		}
	}
}

/**
 * ���Pair.right�Ƚ�����Pair������Conlections.sort()������
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
 * ���һ����������е�װ����ģ����д�ˡ�left��ʾ��ʼʱ�䣬right��ʾ����ʱ�䡣
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