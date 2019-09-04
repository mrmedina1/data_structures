package data_structures;

public class Stack
{
	private int stack[];
	private int size = 0;
	private int top = 0;
	
	public Stack(int size){
		if (size < 0)
			System.out.println("Size cannot be negative. Stack has not been instantiated.");
		else{
			stack = new int[size];
			this.size = size;
		}
	}

	public void push(int integer){
		if ( isFull() )
			System.out.println("Stack is full.  Cannot perform push operation.");
		else
			stack[top++] = integer;
	}

	public void pop(){
		if ( isEmpty() ){
			System.out.println("Stack is empty. Cannot perform pop operation.");
			return;
		}
		System.out.println("Pop op: " + stack[--top]);
	}

	public void peek(){
		if ( isEmpty() ){
			System.out.println("Stack is empty. Cannot perform peek operation.");
			return;
		}
		System.out.println("Peek op: " + stack[top-1]);
	}

	public boolean isFull(){
		return (size == top);
	}

	public boolean isEmpty(){
		return (top == 0);
	}
}