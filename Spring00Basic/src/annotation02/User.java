package annotation02;

public class User {
	
	// name의 최대길이는 10이고, 필수로 입력해야 한다.
	@Validation(maxLength=10, required=true)
	private String name;
	
	// age 최소값은 19이고 최대값을 100이며, 필수로 입력해야 한다.
	@Validation(min=19, max=100, required=true)
	private int age;
	
	// address는 필수로 입력해야한다.
	@Validation(required=true)
	private String address;

	// 모든 생성자(필드초기화)
	public User(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	
	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
}
