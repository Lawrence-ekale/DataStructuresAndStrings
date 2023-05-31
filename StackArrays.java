import java.util.*;

public class StackArrays {
	private int[] internal;
	private int top;

	public StackArrays(int size) {
		this.internal = new int[size];
		this.top = -1;
	}

	public void push(int numb) {
		this.internal[++top] = numb;
	}

	public int pop() {
		if(isEmpty())
			throw new IllegalStateException("The stack is empty");
		return internal[top--];
	}

	public int peek() {
		if(isEmpty())
			throw new IllegalStateException("The stack is empty");
		return internal[top];
	}

	public Boolean isEmpty() {
		return this.top == -1;
	}
	public static void main(String[] args) {
		StackArrays sta = new StackArrays(5);
		sta.push(4);
		sta.push(8);
		sta.push(9);
		sta.push(10);
		sta.push(15);

		System.out.println("Here should be 15 =>"+sta.pop());
		System.out.println("Here should be 10 =>"+sta.peek());
		System.out.println("Here should be 10=>"+sta.pop());
		System.out.println("Here should be 9 =>"+sta.peek());
		System.out.println("Here should be 9 =>"+sta.pop());
		System.out.println("Here should be 8 =>"+sta.peek());
		System.out.println("Here should be 8 =>"+sta.pop());
		System.out.println("Here should be 4 =>"+sta.peek());
		System.out.println("Here should be 4 =>"+sta.pop());
		System.out.println("Here should be error() =>"+sta.peek());
	}
}