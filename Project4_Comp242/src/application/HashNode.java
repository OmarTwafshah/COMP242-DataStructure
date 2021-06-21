package application;

public class HashNode {
	private String name;
	private String gender;
	private String value;
	private int year;
	private int frequencies;
	HeapNode f;
	Heap h = new Heap();
	// private String value;
	private int status; // insert: 1, delete: 2, empty: 0

	HashNode(String name, String gender, int year, int frequencies, int status) {

		this.name = name;
		this.gender = gender;
		this.value = name + gender;
		this.status = status;
		this.year = year;
		this.frequencies = frequencies;
		if (frequencies != 0 && year != 0) {
			f = new HeapNode(year, frequencies);
			h.insert(f);
		}
	}

	HashNode(String name, String gender, int status) {

		this.name = name;
		this.gender = gender;
		this.value = name + gender;
		this.status = status;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getFrequencies() {
		return frequencies;
	}

	public void setFrequencies(int frequencies) {
		this.frequencies = frequencies;
	}

	public String getValue() {
		return value;
	}

	public int getStatus() {
		return status;
	}

	public void setDeleteStatus() {
		status = 2;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String name = getName();
		return "The Name is = " + name + " , and Gender is = " + getGender() + h.toString();
	}

}
