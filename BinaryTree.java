import java.util.*;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.value = val;
	}
}
public class BinaryTree {

	public int findLongestPath(TreeNode root) {
		if(root == null)
			return 0;

		int leftPath = findLongestPath(root.left);
		int rightPath = findLongestPath(root.right);

		return Math.max(leftPath,rightPath)+1;
	}

	//height/depth of a tree
	public int depthHeight(TreeNode root) {
		if(root == null)
			return 0;
		int leftHeight = depthHeight(root.left);
		int rightHeight = depthHeight(root.right);

		return Math.max(leftPath,rightPath) + 1;
	}

	//inorderTraverssal
	public void inorderTraversal(TreeNode root) {
		if(root == null)
			return;
		inorderTraversal(root.left);
		System.out.println(root.value);
		inorderTraversal(root.right);
	}

	//preorder Traversal
	public void preorderTraversal(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.value);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	//postorder Traversal
	public void postorderTraversal(TreeNode root) {
		if(root == null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.value);
	}
}