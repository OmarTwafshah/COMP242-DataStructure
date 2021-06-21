package application;

public class Heap implements Cloneable {
	private HeapNode[] HeapTable = new HeapNode[20];
	private int size;

	private static final int ROOT = 1;

	public Heap() { // int MaxSize
		this.size = 0;
	}

	public void insert(HeapNode f) {
		HeapTable[++size] = f;
		swim();
	}

	private void swim() {
		int curr = size;
		while (curr > 1 && less(curr / 2, curr)) {
			swap(curr, curr / 2);
			curr = curr / 2;
		}
	}

	private void swap(int curr, int parent) {
		HeapNode temp;
		temp = HeapTable[curr];
		HeapTable[curr] = HeapTable[parent];
		HeapTable[parent] = temp;
	}

	private boolean less(int i, int j) {
		
		return ((Comparable) HeapTable[i].getFrequencies()).compareTo(HeapTable[j].getFrequencies()) < 0;
	}

	public HeapNode remove() {
		HeapNode removedElement = HeapTable[ROOT];
		HeapTable[ROOT] = HeapTable[size];
		sink(ROOT, size--);
		HeapTable[size + 1] = null;
		return removedElement;
	}

	public String sortHeapByRemoveNode() {

		String data = "";
		try {
			Heap maxHeap = (Heap) this.clone();
			int n = maxHeap.size;
			while (n >= 1) {
				data += "\n" + (maxHeap.remove().toString());
				n--;
			}

			maxHeap = null;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	private void sink(int pos, int lastPos) {
		if (pos * 2 <= lastPos && (pos * 2) + 1 <= lastPos) // is not Leaf
			if (less(pos, pos * 2) || less(pos, (pos * 2) + 1)) {
				if (less(pos * 2, (pos * 2) + 1)) {
					swap(pos, (pos * 2) + 1);
					sink((pos * 2) + 1, lastPos);
				} else {
					swap(pos, pos * 2);
					sink(pos * 2, lastPos);
				}
			}
	}

	public boolean replace(int year, int freq) {
		for (int i = 1; i < HeapTable.length; i++) {
			if (HeapTable[i] != null && HeapTable[i].getYear() == year) {
				HeapTable[i].setFrequencies(freq);
				swim2(i);
				sink2(i);
				System.out.println("done");
				return true;
			}
		}
		System.out.println("no");
		return false;
	}

	private void swim2(int i) {
		int curr = i;
		while (curr > 1 && less(curr / 2, curr)) {
			swap(curr, curr / 2);
			curr = curr / 2;
		}
	}

	private void sink2(int pos) {
		// left pos*2 =j
		// right pos*2+1 =j+1
		if (HeapTable[(pos * 2)] != null || HeapTable[(pos * 2) + 1] != null) { // is not Leaf
			if (HeapTable[(pos * 2)] != null && HeapTable[(pos * 2) + 1] != null) {
				if (less(pos, pos * 2) || less(pos, (pos * 2) + 1)) {
					if (less(pos * 2, (pos * 2) + 1)) {
						swap(pos, (pos * 2) + 1);
						sink2((pos * 2) + 1);
					} else {
						swap(pos, pos * 2);
						sink2(pos * 2);
					}
				}
			} else if (HeapTable[(pos * 2) + 1] == null) {
				if (less(pos, pos * 2)) {
					swap(pos, pos * 2);
					sink2(pos * 2);
				}
			} else {
				if (less(pos, (pos * 2) + 1)) {
					swap(pos, (pos * 2) + 1);
					sink2((pos * 2) + 1);
				}
			}
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + HeapTable[i] + "----> LEFT CHILD : " + HeapTable[2 * i] + " RIGHT CHILD :"
					+ HeapTable[2 * i + 1] + "\n");

		}
	}

	public String printData() {
		String contant = "";
		for (int i = 1; i <= size; i++) {
			contant += "[ " + HeapTable[i].getYear() + "," + HeapTable[i].getFrequencies() + " ] \n";
		}
		return contant;
	}

	public void printSort() {
		for (int i = 1; i <= size; i++) {
			System.out.print(HeapTable[i] + "---->");
		}
	}

	public int firstFrequancy() {
		if (HeapTable[1] != null) {
			return HeapTable[1].getFrequencies();
		} else
			return 0;
	}

	public boolean founded(HeapNode f) {
		for (int i = 1; i < HeapTable.length; i++) {
			if (HeapTable[i] != null && HeapTable[i].getYear() == f.getYear()) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Heap heap = (Heap) super.clone();

		heap.HeapTable = heap.HeapTable.clone();
		return heap;
	}

	@Override
	public String toString() {
		HeapNode[] curr = HeapTable;
		String string = "";
		for (int i = 1; i < curr.length; i++) {
			if (curr[i] != null) {
				string += "\n" + curr[i].toString();
			}
		}
		return string;
	}

}
