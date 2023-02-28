package advance;

import java.util.EmptyStackException;

public class Main {
	
	static class ArrayStack { 
		//This is an array implementation of Stack
		//It means that using an array then recreate the concept of Stack
		//I will use a Linked List to recreate Stack later
		protected Object[] arr;
		int top, max;
		
		public ArrayStack(int max) {
			this.max = max;
			arr = new Object[max];
			top = -1;
		}
		
		public ArrayStack() {
			this(50);
		}
		
		public boolean isEmpty() {
			return top == -1;
		}
		
		public boolean isFull() {
			return top == max - 1; 
			//since top is an index in an array. 
			//Top starting number is 0 like any other array index
		}
		
		public void clear() {
			top = -1;
		}
		
		public boolean grow() { // +50% in size
			int max1 = max + max/2;
			Object[] arr1 = new Object[max1];
			if (arr1 == null) {
				return false;
			}
			//Clone the array to the new array
			for (int i = 0; i < top; i++) {
				arr1[i] = arr[i];
			}
			arr = arr1;
			max = max1;
			return true;
		}
		
		public void push(Object obj) {
			if (isFull() && !grow()) return;
				top++;
				arr[top] = obj;
		}
		
		public Object pop() throws EmptyStackException {
			if (isEmpty()) throw new EmptyStackException();
			Object obj = arr[top];
			top--;
			return obj;
		}
		
		public Object top() throws EmptyStackException {
			if (isEmpty()) throw new EmptyStackException();
			return arr[top];
		}
		
	}

	static class Node {
		Object data;
		Node next;
		
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public Object getData() {
			return data;
		}
	}
	
	static class SinglyLinkedList {
		Node head;
		int size;
		
		public SinglyLinkedList() {
			head = null;
			size = 0;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public void addHead(Object obj) {
			Node temp = new Node(obj);
			if (isEmpty()) {
				head = temp;
			} else {
				temp.next = head;
				head = temp;
			}
			size++;
		}
		
		public boolean delHead() {
			if (isEmpty()) {
				return false;
			} else {	
				head = head.next;
			}
			size--;
			return true;
		}
		
		public int getSize() {
			return this.size;
		}
		
		public Node getHead() {
			return this.head;
		}
		
		public void printAll() {
			Node temp = head;
			while (temp != null) {
				System.out.println(((Integer)temp.getData()).intValue());
				
				temp = temp.next;
			}
		}
	}
	
	static class ListStack {
		SinglyLinkedList stack;
		
		public ListStack() {
			stack = new SinglyLinkedList();
		}
		
		public boolean empty() {
			return stack.isEmpty();
		}
		
		public Object peek() throws EmptyStackException {
			if (empty()) throw new EmptyStackException();
			
			return stack.getHead().getData();
		}
		
		public void push(Object obj) {
			stack.addHead(obj);
		}
		
		public Object pop() throws EmptyStackException {
			Object temp = stack.getHead().getData();
			if (stack.delHead() == false) throw new EmptyStackException();
			return temp;
		}
		
		public int search() {
			return stack.getSize();
		}
		
		public void printAll() {
			stack.printAll();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayStack stack = new ArrayStack();
//		stack.push(new Integer(0));
//		stack.push(new Integer(1));
//		stack.push(new Integer(2));
//		
//		while (true) {
//			try {
//				System.out.println(stack.pop());
//			} catch (Exception e) {
//				// TODO: handle exception
//				break;
//			}
//		}
//		
		ListStack stack1 = new ListStack();
		stack1.push(new Integer(3));
		stack1.push(new Integer(4));
		stack1.push(new Integer(5));
		
		stack1.printAll();
		
//		System.out.println(stack1.empty());
//		System.out.println(((Integer)stack1.peek()).intValue());
//		System.out.println(stack1.search());
//		while (true) {
//			try {
//				System.out.println(((Integer)stack1.pop()).intValue());
//			} catch (Exception e) {
//				// TODO: handle exception
//				break;
//			}
//		}
//		System.out.println(stack1.empty());
	}

}
