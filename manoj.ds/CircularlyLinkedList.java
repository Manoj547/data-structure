package manoj.ds;

public class CircularlyLinkedList<E> 
{
  private static class Node<E> {

    private E element;

    private Node<E> next;

    public Node(E e, Node<E> n) {
		element = e;
		next = n;
    }

    public E getElement() {
		return element;
	}
	
    public Node<E> getNext() {
		return next;
	}

    public void setNext(Node<E> n) {
		next = n;
	}
  } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList

  private Node<E> tail = null;                  // we store tail (but not head)

  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList() { }             // constructs an initially empty list

  // access methods

  public int size() {
	return size;
  }

  public boolean isEmpty() {
	return size==0;
  }

  public E first() {
	if(tail==null)
		return null;
	return tail.getNext().getElement();
  }

  public E last() {
	if(tail==null)
		return null;
	return tail.getElement();
   }

  // update methods

  public void rotate() {
	if(tail != null)
		if(tail.getNext() != tail) {
			tail=tail.getNext();
	}
  }

  public void addFirst(E e) {
	if(tail==null) {
		Node<E> temp = new Node<>(e , null);
		temp.setNext(temp);
		tail=temp;
	}
	else {
		Node<E> temp = new Node<>(e , tail.getNext());
		tail.setNext(temp);
	}
	size++;
   }

  public void addLast(E e) {
	if(tail==null) {
		Node<E> temp = new Node<>(e , null);
		temp.setNext(temp);
		tail=temp;
	}
	else {
		Node<E> temp = new Node<>(e , tail.getNext());
		tail.setNext(temp);
		tail=temp;
	}
	size++;
   }
   
   public void addInBetween(E e , int index) {
	   if(index == 1)
		   addFirst(e);
	   else if(index == size+1)
		   addLast(e);
	   else {
		   Node<E> temp = tail.getNext();
		   int i=1;
		   while( i<index-1) {
			   temp=temp.getNext();
			   i++;
		   }
		   Node<E> new_node = new Node<> (e , temp.getNext());
		   temp.setNext(new_node);
		   size++;
	   }
   }

  public E removeFirst() {
	if(tail==null)
		return null;
	if(tail.getNext() == tail) {
		E val = tail.getElement();
		tail=null;
		size--;
		return val;
	}
	else {
		Node<E> temp = tail.getNext();
		E val = temp.getElement();
		tail.setNext(temp.getNext());
		size--;
		return val;
	}
   }

  public E removeLast() {
	if(tail==null)
		return null;
	else if(tail.getNext() == tail) {
		E val = tail.getElement();
		tail=null;
		size=0;
		return val;
	}
	else {
		Node<E> temp = tail.getNext();
		E val = tail.getElement();
		while(temp.getNext()!=tail)
			temp=temp.getNext();
		temp.setNext(tail.getNext());
		tail=temp;
		size--;
		return val;
	}
}

    public E removeValueAt(int index) {
	   if(index==1)
		   return removeFirst();
	   else if(index == size)
		   return removeLast();
	   else {
		   Node<E> temp = tail.getNext();
		   Node<E> prev = tail;
		   int i=1;
		   while(i<index) {
			   prev = temp;
			   temp=temp.getNext();
			   i++;
		   }
		   prev.setNext(temp.getNext());
		   size--;
		   return temp.getElement();
	   }
   }
  public String toString() {
	StringBuilder sb = new StringBuilder("(");
	if(tail!=null) {
		Node<E> temp = tail.getNext();
		while(temp!=tail)
		{
			sb.append(temp.getElement());
			sb.append(" , ");
			temp=temp.getNext();
		}
		sb.append(temp.getElement());
	}
	sb.append(")");
	return sb.toString();
   }
   
   
   // -----------  Implementation of CircularlyLinkedList  --------------
   
/*    public static void main(String args[])
  {
	   CircularlyLinkedList<Integer> a=new CircularlyLinkedList<Integer>();
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
	   a.rotate();
	   System.out.println(a.toString());
	   a.removeValueAt(3);
	   System.out.println(a.toString());
	   System.out.println(a.size());
   } */
} //  ----------- end of CircularlyLinkedList class -----------
