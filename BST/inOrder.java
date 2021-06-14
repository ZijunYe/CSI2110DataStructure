class inOrder{
	//recursion method (binary)
	public static void  inOrder1(BinaryTree<String> bTree, Position <String> v){

		if (bTree.hasLeft(v))
			inOrder(bTree, bTree.left(v));
		visit(v);
		if (bTree.hasRight(v))
			inOrder(bTree, bTree.right(v));
	}


	//recursion method(no binary)
	public void inOrder2(TreeNode root){
		if(root!=null){
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}


	//non-recursion method (with binary traits )
	public static void  inOrder(BinaryTree<String> bTree, Position <String> v){
		//TODO Change implementation to make this method non-recursive
		ArrayStack stack = new ArrayStack(); 
		Position<String> curr = v; 
		stack.push(curr);
		while(!stack.isEmpty()) {
			while(bTree.isInternal(curr)) {
					curr = bTree.left(curr); 
					stack.push(curr); 
			}
			
			while(!stack.isEmpty()) {
				curr = (Position<String>)stack.pop(); 
				visit(curr); 
				 
				if(bTree.isInternal(curr)) {
					curr = bTree.right(curr);
					stack.push(curr);
				}
				while(bTree.isInternal(curr)) {
					curr = bTree.left(curr); 
					stack.push(curr);
				}
			}
		}

	//non-recursion method(without binary traits) --> stack 
	public void inOrder3(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode currentNode = root; 


		while(!s.empty() || currentNode != null){
			if(currentNode != null){
				s.push(currentNode); 
			}
			else{
				TreeNode n =s.pop();
				System.out.println(n.data);
				currentNode = n.right;
			}
		}
	}
}