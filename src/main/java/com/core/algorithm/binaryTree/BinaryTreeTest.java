
package com.core.algorithm.binaryTree;


/**
 * @ClassName BinaryTreeTest
 * @author 	 max	 
 * @time      4:48:34 PM
 * @date      Mar 19, 2013 
 */
public class BinaryTreeTest {
	
	public static void main(String[] args){
		int[] array = {12,76,35,22,16,48,90,46,9,40};
		BinaryTree root = new BinaryTree(array[0]);
		for(int i=1;i<array.length;i++){
			root.insert(root, array[i]);
		}
		System.out.println("\n先序遍历");
		preOrder(root);
		System.out.println("\n中序遍历");
		inOrder(root);
		System.out.println("\n后序遍历");
		postOrder(root);
	}

	public static void preOrder(BinaryTree root){//先序遍历
		if(root!=null){
			System.out.print(root.data+"-");
			preOrder(root.leftTree);
			preOrder(root.rightTree);
		}
	}

	public static void inOrder(BinaryTree root){//中序遍历
		if(root!=null){
			inOrder(root.leftTree);
			System.out.print(root.data+"--");
			inOrder(root.rightTree);
		}
	}

	public static void postOrder(BinaryTree root){//后序遍历
		if(root!=null){
			postOrder(root.leftTree);
			postOrder(root.rightTree);
			System.out.print(root.data+"---");
		}
		
	}
	
}