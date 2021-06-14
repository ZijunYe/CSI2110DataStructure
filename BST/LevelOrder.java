class LevelOrder{
	public static void  levelOrder(BinaryTree<String> bTree, Position <String> v){
		// TODO Complete implementation of method
		ArrayListQueue<Position<String>> q = new ArrayListQueue<Position<String>>(10); 
		// we knew each level the max value 
		q.enqueue(v);// add root into the queue 
		
		while(!q.isEmpty()) {
			Position<String> t = q.dequeue();
			visit(t); 
			
			if(bTree.hasLeft(t)) {
				q.enqueue(bTree.left(t));
				
			}
			
			if(bTree.hasRight(t)) {
				q.enqueue(bTree.right(t));
			}
			
		}
		
		
	}
}