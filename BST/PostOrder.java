class PostOrder{
	//recursion 
	public void postOrder(Node node){
		if(node == null){
			return; 
		}

		postOrder(node.left);
		postOrder(node.right); 

		System.out.println(node.data); 
	}


	//non-recursion 
	public void postOrder2(Node root){
		Stack<TreeNode> nodes = new Stack<>(); 
		nodes.push(root); 

		while(!nodes.isEmpty()){
			TreeNode current = nodes.peek(); 

			if(current.isLeaf()){
				TreeNode node = nodes.pop(); 
				System.out.print(node.data); 
			}else{
				if(current.right != null){
					nodes.push(current.right);
					current.right = null; 
				}


				if(current.left != null ){
					nodes.push(current.left); 
					current.left= null;
				}
			}
		}
	}


}