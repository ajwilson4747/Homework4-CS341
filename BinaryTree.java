
public class BinaryTree {

	// ATTRIBUTES OF THE DICTIONARY
	wordNode root;

	// CONSTRUCTOR
	public BinaryTree() {
		root=null;
	}
	// ADD NODE

	public void addwordNode(String sample) {
		wordNode temp = new wordNode(sample);

		// IF THE LIST IS EMPTY
		if (root == null) {
			root =temp;
		}
		// IF THE LIST IS NOT EMPTY
		else {
			insertAtLocation(root, temp); // this method helps figure out the direction of travel so that the word may
											// be added appropriately
		}
	}

	public wordNode delete(wordNode root, int value) {
		value = 0;
		wordNode x = root, p = null;

		// while the tree is not empty and the first parent isn't empty
		while (x != null) {
			// check to see if parent node is greater than value comparer
			if (value == x.word.compareToIgnoreCase(p.word)) {
				break;
			}

			// set prev node to parent's origin
			// check to see if first node is less than second
			// if so, move towards the left subtree
			p = x;
			x = value < x.word.compareToIgnoreCase(p.word)? x.left : x.right; 	
		}

		// if tree is empty
		if (x == null) {
			throw new IllegalArgumentException();
		}

		// has two children
		if(x.left !=null && x.right !=null) {
			wordNode y = x.left;
			p = x;
		while (y.right != null) {
			p = y;
			y = y.right;
		}
			x.word = y.word;
			x = y;
		}
		

			//this is the leaf and 1 child node handler 
			// if the parent has only one node
			// appropriately redirect the nodes from the parent node to next node
				if (p == null) {
					return x.left != null ? x.left : x.right;
				}
				wordNode temp = x.left != null ? x.left : x.right;

				if (x == p.right) {
					p.right = temp;
				} else {
					p.left = temp;
				}
				return root;
			}



	public void insertAtLocation(wordNode pointer, wordNode wordToadd) {
		// Begin the search by visiting each word node
		// move left greater than
		// move right if less than

		// a negative integer means that wordToadd is less than pointer
		// zero means the same
		// positive means it is greater than pointer
		while (true) {
			// travel to the left
			if (wordToadd.word.compareToIgnoreCase(pointer.word) < 0) {
				//assert pointer.left ==null  : "node is being added to right";
				if (pointer.left != null) {
					pointer = pointer.left;
				} else {
					pointer.left = wordToadd;
					break;
				}
			}
			// travel to the middle
			else if (wordToadd.word.compareToIgnoreCase(pointer.word) == 0) {
				break;
			}
			// travel to the right
			else {
				if (pointer.right != null) {
					//assert pointer.right==null : "node is being added to the left";
					pointer = pointer.right;
				} else {
					pointer.right = wordToadd;
					break;
				}
			}
		}
	}

	public void inOrderTraversal() {
		inOrderRecursive(root);
	}

	private void inOrderRecursive(wordNode pointer) {

		if (pointer != null) {
			inOrderRecursive(pointer.left);
			System.out.println(pointer.word);
			inOrderRecursive(pointer.right);
		}
	}
	
	//Here is the checkWord method 
		//this should go through and find a node the user is looking for 
	public boolean checkForWord(wordNode node, String key) {
		if (node ==null) {
			return false; 
		}
		
		boolean isFound = false; 
		while (node != null) {
			if(key.compareToIgnoreCase(node.word) <0) {
				node = node.left;
			}
			else if(key.compareToIgnoreCase(node.word) >0) {
				node = node.right;
			}
			else {
				isFound = true; 
				break;
			}
		}
		return isFound;
	}
}
