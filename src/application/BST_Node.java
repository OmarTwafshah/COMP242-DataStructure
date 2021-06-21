package application;

public class BST_Node {
	private String name;
	private String gender;
	public int frequencie;
	public int year;
	public int height = 1;
	public BST_Node left, right;
	public LLNode frequencie_and_Year = null;

	public BST_Node() {

	}

	public BST_Node(String name, String gender, int frequencie, int year) {
		this.name = name;
		this.gender = gender;
		frequencie_and_Year = new LLNode(year, frequencie);
		this.left = null;
		this.right = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void Addfrequencie_and_Year(int frequencie, int year) {
		LLNode curr = frequencie_and_Year;
		LLNode newNode = new LLNode(year, frequencie);
		if (curr.next == null) {
			newNode.next = curr;
			curr = newNode;

		}
		while (curr.next != null) {
			curr = curr.next;
		}

		newNode.next = curr.next;
		curr.next = newNode;

	}

	public int TotalFrequency() {
		int SumFrq = 0;
		LLNode curr = frequencie_and_Year;
		while (curr != null) {
			SumFrq += curr.getFrequencie();
			curr = curr.next;
		}
		return SumFrq;
	}

	@Override
	public String toString() {
		LLNode temp = frequencie_and_Year;
		String string = " name = " + name + " , gender = " + gender;
		while (temp != null) {
			string += temp.toString();
			temp = temp.next;
		}
		return string;
	}
}
