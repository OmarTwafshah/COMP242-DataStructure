package application;

public class NodeQueue {
	public BST_Node root;
	public NodeQueue next;

	public NodeQueue() {

	}

	public NodeQueue(BST_Node root) {
		this.root = root;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Name Baby is : " + root.getName() + " , And Gender Baby is : " + root.getGender()
				+ "And Total Frequancy is : " + root.TotalFrequency();
	}

}
