package application;

public class Queue {
	public NodeQueue front, rear;

	public void enQueue(BST_Node root) {
		NodeQueue newNode = new NodeQueue(root);
		if (rear == null) {
			rear = front = newNode;
			rear.next = front;
			return;
		}
		rear.next = newNode;
		rear = rear.next;
		rear.next = front;
	}

	public NodeQueue deQueue() {
		NodeQueue temp = null;
		if (front == null) {
			System.out.println("The List Empty");
			return temp;
		} else {
			temp = front;
			if (front == rear) {
				front = rear = null;
			} else {
				front = front.next;
				rear.next = front;
			}
			temp.next = null;
		}
		return temp;
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}
}
