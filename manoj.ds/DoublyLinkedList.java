package manoj.ds;

public class DoublyLinkedList<E> 
{
  private static class Node<E> {
	
    private E element;
    private Node<E> prev;
    private Node<E> next;
	
    public Node(E e, Node<E> p, Node<E> n) {
		element = e;
		prev = p;
		next = n;
    }

    public E getElement() {
		return element;
	}
		
    public Node<E> getPrev() {
		return prev;
	}

    public Node<E> getNext() {
		return next;
	}

    public void setPrev(Node<E> p) {
		prev = p;
	}

    public void setNext(Node<E> n) {
		next = n;
	}
  }
  //----------- end of nested Node class -----------

  private Node<E> header;                    // header

  private Node<E> trailer;                   // trailer

  private int size = 0;                      // number of elements in the list

  /** Constructs a new empty list. */
  public DoublyLinkedList() {
	header = null;
	trailer = null;
  }

  // public accessor methods
  public int size() {
	return size;
  }

  public boolean isEmpty() {
	return size==0;
  }

  public E first() {
	if(header==null)
		return null;
	return header.element;
  }

  public E last() {
	if(header==null)
		return null;
	return trailer.getElement();
  }

  
  
  
  // public update methods
  public void addFirst(E e) {
	if(header==null)
	{
		Node<E> newest = new Node<>(e , null ,null);
		header=trailer=newest;
	}
	else
	{
		Node<E> newest = new Node<>(e , null , header);
		header.setPrev(newest);
		header = newest;
	}
	size++;
  }

  public void addLast(E e) {
	if(header==null)
	{
		Node<E> newest = new Node<>(e , null ,null);
		header=trailer=newest;
	}
	else
	{
		Node<E> newest = new Node<>(e , trailer , null);
		trailer.setNext(newest);
		trailer=newest;
	}
	size++;
  }
  
   private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
	Node<E> newest = new Node<>(e , predecessor , successor);
	predecessor.setNext(newest);
	successor.setNext(newest);
	size++;
  }
  
  public void addInBetween(E e , int index) {
	  if(index==1)
		  addFirst(e);
	  else if(index==size+1)
		  addLast(e);
	  else {
		  Node<E> curr = header;
		  int i=1;
		  while(i<index) {
			  curr = curr.getNext();
			  i++;
		  }
		  addBetween(e , curr.getPrev() , curr);
	  }
  }

  public E removeFirst() {
	if(header == null)
		return null;
	else if(size==1) {
		E first_element = header.getElement();
		header=null;
		size=0;
		return first_element;
	}
	E first_element = header.getElement();
	header = header.getNext();
	header.setPrev(null);
	size--;
	return first_element;
  }

  public E removeLast() {
	if(header == null)
		return null;
  else if(size==1) {
	  return removeFirst();
  }
  else {
	 E last_element = trailer.getElement();
	 trailer = trailer.getPrev();
	 trailer.setNext(null);
	 size--;
	 return last_element;
    }
  }
  

  public E removeValueAt(int index) {
	  if(index==1)
		  return removeFirst();
	  else if(index==size)
		  return removeLast();
	  else {
		  Node<E> temp = header;
		  int i=1;
		  while(i<index) {
			  temp=temp.getNext();
			  i++;
		  }
		  return remove(temp);
	  }
  }
  
  private E remove(Node<E> node) {
	Node<E> temp = header;
	while(temp!=null)
	{
		if(temp.getElement() == node.getElement())
		{
			E value = node.getElement();
			Node<E> pre = temp.getPrev();
			Node<E> nex = temp.getNext();
			
			pre.setNext(nex);
		//	pre.setPrev(pre);
			size--;
			return value;
		}
		temp=temp.getNext();
	}
	return null;
  }

  
  
  public String toString() 
  {
	StringBuilder sb = new StringBuilder("(");
	Node<E> walk = header;
	while(walk!= null) {
		sb.append(walk.getElement());
		if(walk!=trailer)
			sb.append(" , ");
		walk=walk.getNext();
	}
	sb.append(")");
	return sb.toString();
  }
  
  
   // -----------  Implementation of DoublyLinkedList  --------------
   
/*    public static void main(String args[])
  {
	   DoublyLinkedList<Integer> a=new DoublyLinkedList<Integer>();
	   a.addFirst(4);
	   a.addLast(8);
	   a.addInBetween(6,2);
	   a.addFirst(1);
	   a.addLast(14);
	   System.out.println(a.toString());
	   a.removeLast();
	   System.out.println(a.toString());
	   a.addInBetween(11,5);
		a.removeValueAt(3);
	   System.out.println(a.toString());
	   a.removeFirst();
	   System.out.println(a.toString());
	   a.removeFirst();
	   System.out.println(a.toString());
	   System.out.println(a.size());
   } */
} //  ----------- end of DoublyLinkedList class -----------