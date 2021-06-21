package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BST {
	public static BST_Node Maxtemp = null;

	public static int max = 0;

	public static int sum = 0;

	public BST_Node insert(BST_Node node, String name, String gender, int frequencie, int year) {

		if (node == null) {
			return node = new BST_Node(name, gender, frequencie, year);
		}

		if (name.compareTo(node.getName()) < 0)
			node.left = insert(node.left, name, gender, frequencie, year);
		else if (name.compareTo(node.getName()) > 0)
			node.right = insert(node.right, name, gender, frequencie, year);
		else if (name.compareTo(node.getName()) == 0) {
			if (gender.compareTo(node.getGender()) == 0) {
				node.Addfrequencie_and_Year(frequencie, year);
				return node;
			} else if (gender.compareTo(node.getGender()) < 0) {
				node.left = insert(node.left, name, gender, frequencie, year);
			} else if (gender.compareTo(node.getGender()) > 0) {
				node.right = insert(node.right, name, gender, frequencie, year);
			}
		}
		updateHeight(node);
		int balance = getBalance(node);
		if (balance > 1) {
			if (height(node.right.right) > height(node.right.left)) {
				node = leftRotate(node);
			} else {
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		} else if (balance < -1) {
			if (height(node.left.left) > height(node.left.right))
				node = rightRotate(node);
			else {
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		}
		return node;

	}

	public BST_Node leftRotate(BST_Node x) {
		BST_Node y = x.right;
		BST_Node T2 = y.left;
		y.left = x;
		x.right = T2;
		updateHeight(x);
		updateHeight(y);
		return y;
	}

	public BST_Node rightRotate(BST_Node y) {
		BST_Node x = y.left;
		BST_Node T2 = x.right;
		x.right = y;
		y.left = T2;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	public BST_Node SearchName(BST_Node root, String name, String gender) {
		if (root == null)
			return null;
		if (name.compareTo(root.getName()) < 0)
			return (SearchName(root.left, name, gender));
		else if (name.compareTo(root.getName()) > 0)
			return (SearchName(root.right, name, gender));
		else if (name.compareTo(root.getName()) == 0) {
			if (gender.compareTo(root.getGender()) == 0) {
				return root;
			} else if (gender.compareTo(root.getGender()) < 0) {
				return SearchName(root.left, name, gender);
			} else if (gender.compareTo(root.getGender()) > 0) {
				return SearchName(root.right, name, gender);
			}
		}
		return null;

	}

	public double AverageFrequenciesName(BST_Node root, String name, String gender) {
		int sum = 0;
		int counter = 0;
		BST_Node find = SearchName(root, name, gender);
		if (find == null) {
			return 0;
		}
		LLNode curr = find.frequencie_and_Year;
		while (curr != null) {
			sum += curr.getFrequencie();
			curr = curr.next;
			counter++;
		}
		return sum / counter;
	}

	public BST_Node max_frequency(BST_Node root) {
		if (root != null) {
			int sum = 0;
			LLNode curr = root.frequencie_and_Year;
			while (curr != null) {
				sum += curr.getFrequencie();
				curr = curr.next;
			}
			if (sum > max) {
				max = sum;
				Maxtemp = root;
			}
			max_frequency(root.left);
			max_frequency(root.right);
		}

		return Maxtemp;

	}

	public int Total_babies(BST_Node root, int year) {
		if (root != null) {
			LLNode curr = root.frequencie_and_Year;
			while (curr != null) {
				if (curr.getYear() == year) {
					sum += curr.getFrequencie();
				}
				curr = curr.next;
			}
			Total_babies(root.left, year);
			Total_babies(root.right, year);
		}
		return sum;
	}

	public void Export_AVL(BST_Node root) throws IOException {
		Queue queue = new Queue();
		if (root == null) {
			return;
		}
		FileWriter newOut = new FileWriter(new File("output.xt"));
		queue.enQueue(root);
		String re = "";
		while (!queue.isEmpty()) {
			BST_Node temp = queue.deQueue().root;
			re += "The Baby Name : " + temp.getName() + " , And The Gender Is : " + temp.getGender()
					+ " , And The Total Frquancy Is : " + temp.TotalFrequency() + "\n";
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}

			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}

		newOut.write(re);
		newOut.close();

	}

	public void updateHeight(BST_Node n) {
		n.height = 1 + max(height(n.left), height(n.right));
	}

	public int height(BST_Node N) {
		if (N == null)
			return 0;
		return N.height;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public int getBalance(BST_Node n) {
		return (n == null) ? 0 : height(n.right) - height(n.left);
	}
}
