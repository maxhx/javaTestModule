
package com.core.algorithm.binaryTree;
/**
 * @author maihx	 
 */
public class BinaryTree {
	
	int data;
	BinaryTree leftTree;
	BinaryTree rightTree;
	
	public BinaryTree(int data){
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	
	public void insert(BinaryTree root,int data){
		if(data>root.data){
			if(root.rightTree==null){
				root.rightTree = new BinaryTree(data);
			}else{
				this.insert(root.rightTree, data);
			}
		}else{
			if(root.leftTree==null){
				root.leftTree = new BinaryTree(data);
			}else{
				this.insert(root.leftTree, data);
			}
		}
	}

}