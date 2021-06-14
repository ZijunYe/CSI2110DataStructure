class PreOrder{
	//recursion 
	public static void  preOrder(BinaryTree<String> bTree, Position <String> v){
		//TODO Change implementation to make this method non-recursive
		
		visit(v);
		if (bTree.hasLeft(v))
			preOrder(bTree, bTree.left(v));
		
		if (bTree.hasRight(v))
			preOrder(bTree, bTree.right(v))

	}
	//non-recursion 
	public static void  preOrder(BinaryTree<String> bTree, Position <String> v){
		//TODO Change implementation to make this method non-recursive
		ArrayStack stack = new ArrayStack(); 
		stack.push(v);
		while(!stack.isEmpty()) {
			v = (Position<String>)stack.pop(); 
			visit(v);
			
			if(bTree.hasRight(v)) {
				stack.push(bTree.right(v));
			}
			
			if(bTree.hasLeft(v)) {
				stack.push(bTree.left(v));
			}
		}
	}

}