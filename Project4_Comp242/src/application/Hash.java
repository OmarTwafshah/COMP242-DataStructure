package application;

public class Hash {
	private int tableSize = 128;
	HashNode[] table;
	private int currentSize = 0;

	public Hash(int size) {
		table = new HashNode[size];
		for (int i = 0; i < size; i++)
			table[i] = null;
		tableSize = size;
		currentSize = 0; // بتفيدني في الري هاش
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public int getTableSize() {
		return tableSize;
	}

	public boolean contains(String name, String gender) {
		if (this.find(name, gender) == null) {
			return false;
		} else {
			return true;
		}

	}

	public String get(String key) {
		int i = 1;
		int location = getHash(key.toLowerCase());
		while ((table[location] != null) && (table[location].getStatus() != 0) && (table[location].getStatus() != 2)) {
			if (table[location].getValue() == key)
				return table[location].getValue();
			location = (location + i * i) % tableSize;

			i++;
		}
		return null;

	}

	public void insert(String name, String gender, int year, int frequencies) {
		String value = name + gender;
		if (currentSize >= (tableSize * 0.6)) // اول اشي بفحص اذا وصلت لنص حجم التايبل اللي عندي او لا علشان يعمل ري هاش
			rehash();
		int hash = getHash(value.toLowerCase()), i = 1, flage = 0;
		while ((table[hash] != null) && (table[hash].getStatus() != 0) && (table[hash].getStatus() != 2)) {

			if (!value.equalsIgnoreCase(table[hash].getValue())) {
				hash = (hash + i * i) % tableSize; // Quadratic
				i++;
			} else {
				flage = 1;
				break;
			}
		}
		if (flage == 0) {
			currentSize++;
			table[hash] = new HashNode(name, gender, year, frequencies, 1);
		} else {
			HeapNode f1 = new HeapNode(year, frequencies);
			table[hash].h.insert(f1);
		}

	}

	public void insert(String name, String gender) {
		String value = name + gender;
		if (currentSize >= (tableSize * 0.6)) // اول اشي بفحص اذا وصلت لنص حجم التايبل اللي عندي او لا علشان يعمل ري هاش
			rehash();
		int hash = getHash(value.toLowerCase()), i = 1, flage = 0;
		while ((table[hash] != null) && (table[hash].getStatus() != 0) && (table[hash].getStatus() != 2)) {

			if (!value.equalsIgnoreCase(table[hash].getValue())) {
				hash = (hash + i * i) % tableSize;
				i++;
			} else {
				flage = 1;
				break;
			}
		}
		if (flage == 0) {
			currentSize++;
			table[hash] = new HashNode(name, gender, 1);
		}

	}

	public int getHash(String s) {
		int hashVal = 0, i = 0;
		while (i != s.length())
			hashVal = (hashVal << 5) + s.charAt(i++);
		hashVal = hashVal % tableSize;
		if (hashVal < 0)
			hashVal = hashVal + tableSize;
		return (hashVal);
	}

	private void rehash() {
		Hash newList;
		newList = new Hash(nextPrime(2 * table.length));

		for (int i = 0; i < table.length; i++)
			if ((table[i] != null) && (table[i].getStatus() == 1))
				newList.insert(table[i].getName(), table[i].getGender(), table[i].getYear(), table[i].getFrequencies());

		table = newList.table;

		tableSize = newList.tableSize;
	}

	private int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		while (isPrime(n) == false) {
			n += 2;
		}
		return n;
	}

	private boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n / 2; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	public String find(String name, String gender) {
		String key = name + gender;
		int hash = getHash(key.toLowerCase()), i = 1;
		while ((table[hash] != null) && (table[hash].getStatus() != 0) && (table[hash].getStatus() != 2)
				&& !key.equalsIgnoreCase(table[hash].getValue())) {
			hash = (hash + i * i) % tableSize;
			i++;
		}
		if ((table[hash] == null) || (table[hash].getStatus() == 0) || (table[hash].getStatus() == 2))
			return null;
		else
			return "Name : " + table[hash].getName() + " , Gender : " + table[hash].getGender()
					+ table[hash].h.sortHeapByRemoveNode();
	}

	public boolean remove(String name, String gender) {
		String key = name + gender;
		if (!contains(name, gender))
			return false;

		int hash = getHash(key.toLowerCase()), i = 1;
		while ((table[hash] != null) && (table[hash].getStatus() != 0) && (table[hash].getStatus() != 2)
				&& !key.equalsIgnoreCase(table[hash].getValue())) {
			hash = (hash + i * i) % tableSize;
			i++;
		}
		currentSize--;

		table[hash].setDeleteStatus();
		return true;

	}

	public String maxName() {
		int max = 0;
		for (int i = 0; i <= currentSize; i++) {
			if (table[i] != null) {
				max = i;
				break;
			}
		}
		String name = null;
		if (table[max] != null) {
			for (int i = 0; i < tableSize; i++) {
				if (table[i] != null && table[max].h.firstFrequancy() < table[i].h.firstFrequancy()) {
					max = i;
				}
			}
			name = "name: " + table[max].getName() + ", Gender: " + table[max].getGender() + ", max frequancy: "
					+ table[max].h.firstFrequancy();

		}
		return name;
	}

	public int currentIndex(String name, String gender) {
		String key = name + gender;
		for (int i = 0; i < table.length; i++) {

			if (table[i] != null && table[i].getValue().compareTo(key) == 0) {
				return i;
			}

		}
		return -1;
	}

}
