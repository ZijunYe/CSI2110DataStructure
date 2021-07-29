/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * LinkedBinarySearchTree for tree traversal lab
 * @author Lachlan Plant
 * @param <E>
 */
public class LinkedBinarySearchTree<E extends Comparable> implements Iterable<E>{
    
    private class Node<E>{
        E elem;
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        public Node(E e,Node<E> p, Node<E> l, Node<E> r){
            elem = e;
            parent= p;
            left = l;
            right = r;
        }
    }
    
    private Node<E> root;
    private int size;
    
    /**
     *
     */
    public LinkedBinarySearchTree(){
        root = null;
        size = 0;
    }
    
    /**
     * Adds elem into BST
     * @param elem
     * @return
     */
    public boolean add(E elem){
        if(root == null){
            root = new Node<>(elem, null, null, null);
            size ++;
            return true;
        }
        else{
            root = insert(elem, root, null);
            return true;
        }
    }
    
    /**
     * Recursive BST insertion
     * @param elem
     * @param curr
     * @param from
     * @return
     */
    private Node<E> insert(E elem, Node<E> curr, Node<E> from){
        if(curr == null){
            curr = new Node<>(elem, from, null, null);
            size ++;
            return curr;
        }
        if( elem.compareTo(curr.elem)<0){
            curr.left = insert(elem, curr.left, curr);
        }
        if( elem.compareTo(curr.elem)>0){
            curr.right = insert(elem, curr.right, curr);
        }
        return curr;
    }
    

    
    /*****************************************************************
     *
     * Recursive Printing Functions
     *
     *
     *****************************************************************/
    
    /**
     * Caller method for preorder recursive printing
     */
    public void printPreorderRecursive(){
        System.out.print("Recursive Preorder Printing: ");
        preorderRecursive(root);
    }
    
    /**
     * preorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void preorderRecursive(Node<E> curr){
        //Implement Here


        //preOrder Root Left Rright 

        if(curr == null){
            return; 
        }


        System.out.print(curr.elem +",");
        preorderRecursive(curr.left); 
        preorderRecursive(curr.right); 
    }
    
    /**
     * Caller method for inorder recursive printing
     */
    public void printInorderRecursive(){
        System.out.print("Recursive Inorder Printing: ");
        inorderRecursive(root);
    }
    
    /**
     * inorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void inorderRecursive(Node<E> curr){
        //Implement Here

        //inOrder: Left Root Right 
        if(curr == null){
            return; 
        }

        inorderRecursive(curr.left);
        System.out.print(curr.elem +","); 
        inorderRecursive(curr.right); 
    }
    
    
    /**
     * Caller method for postorder recursive printing
     */
    public void printPostorderRecursive(){
        System.out.print("Recursive Postorder Printing: ");
        postorderRecursive(root);
    }
    
    /**
     * postorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void postorderRecursive(Node<E> curr){
        //Implement Here      

        //PostOrder: Left Right Root  

        if(curr == null){
            return;
        }

        postorderRecursive(curr.left);
        postorderRecursive(curr.right);
        System.out.print(curr.elem +","); 
    }

    
    
     /*****************************************************************
     *
     * Iterator Functions
     *
     *
     *****************************************************************/
    
    
    public Iterator iterator(){
        return new InorderIterator();
    }
    
    public Iterator inorderIterator(){
        return new InorderIterator();
    }
    
    public Iterator preorderIterator(){
        return new PreorderIterator();
    }
    

    
     /*****************************************************************
     *
     * Iterators 
     *
     *
     *****************************************************************/ 
    
    
    
    
    /**
     * Tree Iterator using preorder traversal for ordering
     */
    private class PreorderIterator implements Iterator<E>{
        Node<E> next;
        
        public PreorderIterator(){
            //Implement Here
            next = root;

        }
        
        public boolean hasNext(){
            return next != null;
        }
        
        public E next(){
            E result = next.elem;
            if(next.left != null){
                next =  next.left;
                return result;
            }else if(next.right != null){
                next = next.right;
                return result; 
            }else{
                // if the next do not have left child nor right child 
                // then it prove the curr is external child 
                //there is three situation 
                // #1 it is left child --> then we need go to it parent and return right child to be next 
                // #2 it is right child --> go back to parent, and grandparent, to traversal right side 
                // #3 it is only element in the tree --> return null 

                Node<E> parent = next.parent;
                Node<E> child = next; 

                // parent.right == child means --> the subtree is already done traversal 
                // parent.right == null means --> curr child is the left and it doesn't have right child, then also done traversal 
                while(parent!=null && (parent.right == child ||parent.right == null)){
                    child = parent; 
                    parent = parent.parent;
                }

                if(parent == null){//prove this is the only one element in the tree 
                    next = null; 
                    return result; 
                }else{
                    next =  parent.right; //is the external left child in the tree
                    return result; 
                }
           

            }
          
        }
        
        public void remove(){
            // not implemented
        }
    }
    
    /**
     * Tree Iterator using inorder traversal for ordering
     */
    private class InorderIterator implements Iterator<E>{
        
        Node<E> next;
        
        public InorderIterator(){
            //Implement Here
            //since inOrder traversal go from the left most 
            //then we need start at left most 
            next = root;
            while(next.left !=null){
                next = next.left;
            }

        }
        
        public boolean hasNext(){
            return next != null;
            //Implement Here
        }
        
        public E next(){
            //we start with left most 

            E result = next.elem; 
            if(next.right != null){ // we reached left most, and we need to see if this elem have right child or not
                next = next.right;
                while(next.left != null){ // right child need to check if it have left child also
                    next = next.left; 
                }
                return result; 
            }
            // if next doesn't have right child, then it is the external, we need to visit it parent 
            // check if the parent have right child or not 

            //face situation

            // #1 if next.parent == null --> it is only elem in the tree 
            // #2 if curr is left child -> then next we visit is parent 
            // #3 if curr is right child --> then next we need go back to parent and go to grandparent 

            else{
                while(true){
                    if(next.parent == null){ 
                        next = null;
                        return result;
                    }
                    if(next.parent.left == next){
                        next = next.parent;
                        return result; 
                    }

                    next = next.parent;
                }
            }
        }
        
        public void remove(){
            // not implemented
        }
    }
}
