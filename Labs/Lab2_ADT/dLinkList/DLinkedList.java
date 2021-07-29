/*  CSI2114 Lab 2 - DLinkedList.java
 *  
 *  Class doubly linked list   
 *  
 *  by Jeff Souza
 *
 */

class DLinkedList {

    ListNode firstNode;
    ListNode lastNode;

    // Appends a node to the end of the list
    void AppendNode(ListNode nNode) {
        InsertNode(nNode,lastNode);
    }

    // Inserts a node into the list after pAfter
    void InsertNode(ListNode nNode, ListNode pAfter) {
        nNode.previous = pAfter;
        nNode.next = pAfter.next;

        if(pAfter.next != null){ //not the first one nor last one 
            pAfter.next.previous = nNode;
        }else{ // the first or last
            lastNode = nNode;
        }
       
        pAfter.next = nNode;

    }

    // Removes the specified node from the list
    void RemoveNode(ListNode nNode) {
        // previous 
        if(nNode.previous == null){ //first 
            firstNode = nNode.next;
        }else{ // not the first one 
            nNode.previous.next = nNode.next;
        }
        //after
        if(nNode.next == null){ // last
            lastNode = nNode.previous;
        }else{ // not the last 
            nNode.next.previous = nNode.previous;
        }
    }

    // print the content of the list
    void print() {
        ListNode nNode = null;
        System.out.print("Current list: ");
        for (nNode = firstNode; nNode != null; nNode = nNode.next) {
            System.out.print(nNode.data +  " ");
        }
        System.out.println("");
    } 
  
}