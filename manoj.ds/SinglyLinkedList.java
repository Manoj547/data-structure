package manoj.ds;

public class SinglyLinkedList<E> 
{
  //---------------- nested Node class ----------------
  private static class Node<E> 
  {
    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n) 
    {
      element = e;
      next = n;
    }

    public E getElement() 
    { 
      return element; 
    }

    public Node<E> getNext() {
		return next;
	}

    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  
  
  
  private Node<E> head = null;

  private Node<E> tail = null;

  private int size = 0;

  public SinglyLinkedList() {
	  
  }

  // access methods
  
  public int size() {
	  return size;
	}

  public boolean isEmpty() { return size == 0; }

  public E first() {
    if (isEmpty()) return null;
    return head.getElement();
  }

  public E last() {
    if (isEmpty()) return null;
    return tail.getElement();
  }

  
  
  
  
  public void addFirst(E e) {
    head = new Node<>(e, head);
    if (size == 0)
      tail = head;
    size++;
  }
  
  public void addInBetween(E e , int index) {
	  if(index==1)
		  addFirst(e);
	  else if(index==size+1)
		  addLast(e);
	  else {
		  Node<E> temp = head;
		  int i=1;
		  while(i<index-1) {
			  temp = temp.getNext();
			  i++;
		  }
		  Node<E> new_node = new Node<>(e , temp.getNext());
		  temp.setNext(new_node);
		  size++;
	  }
  }

  public void addLast(E e) {
    Node<E> newest = new Node<>(e, null);
    if (isEmpty())
      head = newest;
    else
      tail.setNext(newest);
    tail = newest;
    size++;
  }

  
  
  
  
  public E removeFirst() {
    if (isEmpty())
		return null;
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0)
      tail = null;
    return answer;
  }
  
  public E removeLast() {
	  if(isEmpty())
		  return null;
	  else if(head.getNext()== null)
	  {
		  E val = head.getElement();
		  head=tail=null;
		  size=0;
		  return val;
	  }
	  else {
		  Node<E> temp = head;
		  while(temp.getNext()!=tail){
			  temp=temp.getNext();
		  }
		  E val = tail.getElement();
		  temp.setNext(null);
		  tail=temp;
		  size--;
		  return val;
	  }
  }
  
  public E removeValueAt(int index) {
	  if(index==1) {
		  return removeFirst();
	  }
	  else if(index==size) {
		  return removeLast();
	  }
	  else {
		  Node<E> curr = head;
		  Node<E> prev = null;
		  int i=1;
		  while(i<index) {
			  prev = curr;
			  curr = curr.getNext();
			  i++;
		  }
		//  prev = curr.getNext();		// incorrect way
		prev.setNext(curr.getNext());
		  size--;
		  return curr.getElement();
	  }
  }

  
  
  
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
   
   // -----------  Implementation of SinglyLinkedList  --------------
   
/*    public static void main(String args[])
  {
	   SinglyLinkedList<Integer> a=new SinglyLinkedList<Integer>();
	   a.addFirst(4);
	   a.addLast(8);
	   a.addInBetween(6,2);
	   a.addFirst(1);
	   a.addLast(14);
	   System.out.println(a.toString());
	   a.addInBetween(11,5);
	   System.out.println(a.toString());
	   a.removeFirst();
	   a.removeLast();
	   System.out.println(a.toString());
	   a.removeValueAt(3);
	   System.out.println(a.toString());
	   System.out.println(a.size());
   } */
} //----------- end of SinglyLinkedList class -----------