
public class wordNode {
	
	public String word; 
	public wordNode left; 
	public wordNode right; 
	
	public wordNode(String w) {
		this.word=w;
		left = null; 
		right= null; 
	}

	public wordNode getLeft() {
		return left;
	}

	public void setLeft(wordNode left) {
		this.left = left;
	}

	public wordNode getRight() {
		return right;
	}

	public void setRight(wordNode right) {
		this.right = right;
	}
}
