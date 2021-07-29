// ==========================================================================
// $Id: addTemplate.cpp,v 1.1 2005/11/02 23:13:32 jlang Exp $
// CSI2110 Lab code Node List skeleton class
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: addTemplate.cpp,v $
//
// ==========================================================================
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class NodeList<E> {
  // The linked list which is to be adapted
  protected LinkedList<E> linkedList = new LinkedList<E>();

  // Directly available
  public int size() {
    return linkedList.size();
  }

  // Directly available
  public boolean isEmpty() {
     return linkedList.isEmpty();
  }

  // fix me!
  public boolean isFirst(E element) {
    //if the linkedlist is empty then it is false
    // compare element with LinkedList 
    boolean result;
    if(isEmpty()){
      return false;
    }else{
      result = (element == linkedList.getFirst());
    }
    return result;
  }

  // fix me!
  public boolean isLast(E element) {
    boolean result;
    if(isEmpty()){
      return false;
    }else{
      result = (element == linkedList.getLast());
    }

    return result;
  }

  // Directly available
  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }


  // Directly available
  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  //helper function 
  public int getExactIndex(E element){
    for(int i = 0; i< size(); i++){
      if(element == linkedList.get(i)){
        return i;
      }
    }
    return -1;
  }


  // fix me!
 E prev(E element)
  throws NoSuchElementException {
    int index = getExactIndex(element); // indexOf can only return the first occurence 
    if(index <= 0){                     // the list may contains multiple same value
      throw new NoSuchElementException(); 
    }

    return linkedList.get(index-1);
  }
  

  // fix me!
  E next(E element)
    throws NoSuchElementException {
    int index = getExactIndex(element);
    if(index == -1 || index == linkedList.size() - 1) {
      throw new NoSuchElementException();
    }
    return linkedList.get(index+1);
    
  }

  // fix me!
  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
    int index1 = getExactIndex(element1);
    int index2 = getExactIndex(element2);

    if(index1 == -1 || index2 == -1)
          throw new NoSuchElementException();

    E temp = element2;
    linkedList.set(index2 , element1);
    linkedList.set(index1, temp);
  }
  

  // fix me!
  public void set(E currElement, E repElement)
    throws NoSuchElementException {
    int index = getExactIndex(currElement);
    if(index == -1){
      throw new NoSuchElementException();
    }
    linkedList.set(index, repElement);
  }


  // Directly available
  public void addFirst(E element) {
    linkedList.addFirst(element);
    return;
  }

  // Directly available
  public void addLast(E element) {
    linkedList.addLast(element);
    return;
  }

  // fix me!
  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
    int index = getExactIndex(currElement);
    if(index == -1)
        throw new NoSuchElementException();

   linkedList.add(index, addElement);

  }

  // fix me!
  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
    int index = getExactIndex(currElement);
    if(index == -1)
        throw new NoSuchElementException();

   linkedList.add(index+1, addElement);
    
  }
  
  // fix me!
  public E remove(E element) 
    throws NoSuchElementException {
     int index = getExactIndex(element);
    if(index == -1)
        throw new NoSuchElementException();
    linkedList.remove(index);
    return element;
  }
}
