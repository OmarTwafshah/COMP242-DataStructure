package application;

import java.io.IOException;

public class Tree {

	BST_Node root;

	BST bst = new BST();

	public void insert(String name, String gender, int frequencie, int year) {
		root = bst.insert(root, name, gender, frequencie, year);
	}

	public BST_Node SearchName(String Name, String gender) {
		return bst.SearchName(root, Name, gender);
	}

	public double AverageFrequenciesName(String Name, String Gender) {
		return bst.AverageFrequenciesName(root, Name, Gender);
	}

	public BST_Node max_frequency() {
		return bst.max_frequency(root);
	}

	public int Total_babies(int year) {
		return bst.Total_babies(root, year);
	}

	public void Export_AVL() throws IOException {
		bst.Export_AVL(root);
	}

}
