import java.util.Date;

public class FileInfo {

	String name;
	String type;
	int size;
	Date modifiedDate;

	public FileInfo(String name, String type, int size, Date modifiedDate) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	@Override
	public String toString() {

		return "Name: " + this.name + "\n" + "Type: " + this.type + "\n" + "Size: " + this.size + "\n" + "ModifiedDate: " + this.modifiedDate;
	}

}
