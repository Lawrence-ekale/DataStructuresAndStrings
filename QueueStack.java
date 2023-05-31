import java.util.*;
/**
 * I am implementing a queue using two stacks
 * */
public class QueueStack {
	Stack<Integer> enqueueStack;
	Stack<Integer> dequeueStack;

	public QueueStack() {
		enqueueStack = new Stack<>();
		dequeueStack = new Stack<>();
	}

	public void enqueue(int element) {
		enqueueStack.push(element);
	}

	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException("The queue is empty");

		if(dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}

		return dequeueStack.pop();
	}

	public Boolean isEmpty() {
		return enqueueStack.isEmpty() && dequeueStack.isEmpty();
	}

	public static void main(String[] args) {
		QueueStack queue = new QueueStack();
        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements and verify the order
        System.out.println(queue.dequeue()); // Output: 10
        System.out.println(queue.dequeue()); // Output: 20

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue the remaining elements and verify the order
        System.out.println(queue.dequeue()); // Output: 30
        System.out.println(queue.dequeue()); // Output: 40
        System.out.println(queue.dequeue()); // Output: 50

        // Try to dequeue from an empty queue
        try {
            System.out.println(queue.dequeue()); // Throws IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Queue is empty");
        }

        // Enqueue elements again
        queue.enqueue(60);
        queue.enqueue(70);

        // Dequeue elements and verify the order
        System.out.println(queue.dequeue()); // Output: 60
        System.out.println(queue.dequeue()); // Output: 70
	}
}