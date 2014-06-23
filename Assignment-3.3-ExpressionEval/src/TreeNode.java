
public class TreeNode {
	private Object value;
	private TreeNode left = null;
	private TreeNode right = null;
	
	public TreeNode(Object initValue){
		value = initValue;
	}
	public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight){
		this(initValue);
		left = initLeft;
		right = initRight;
	}
	public Object getValue(){
		return value;
	}
	public TreeNode getLeft(){
		return left;
	}
	public TreeNode getRight(){
		return right;
	}
	public void setValue(Object newValue){
		value = newValue;
	}
	public void setLeft(TreeNode newLeft){
		left = newLeft;
	}
	public void setRight(TreeNode newRight){
		right = newRight;
	}
}
