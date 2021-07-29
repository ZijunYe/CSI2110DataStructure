/**
 * A simple node class for a singly-linked list.  Each node has a
 * reference to a stored element and a next node.
 * This class is based on the <code>DNode</code> class by Roberto Tamassia.
 *
 * @author Jochen Lang
 */

public class DNode {
  private Object element;
  private DNode prev;
  private DNode next;

  DNode() { this(null, null,null); }
    DNode(Object e, DNode prev, DNode next ) {
    element = e;
    this.prev = prev;
    this.next = next;
  }
  public void setElement(Object newElem) { element = newElem; }
  public void setNext(DNode newNext) { next = newNext; }
  public void setPrev(DNode newPrev){prev = newPrev;}
  public Object getElement() { return element; }
  public DNode getNext() { return next; }
  public DNode getPrev(){return prev;}
}