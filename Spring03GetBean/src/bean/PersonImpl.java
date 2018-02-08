package bean;

public class PersonImpl implements Person{

	private String greeting = "안녕하세요?";
	private String name = "현빈";
	private int age = 36;
	
	public PersonImpl() {
		System.out.println("기본 생성자 호출");
	}
	
	public PersonImpl(String greeting) {
		this.greeting = greeting;
	}
	
	public PersonImpl(int age) {
		this.age = age;
	}
	
	public PersonImpl(String greeting, String name, int age) {
		this.greeting = greeting;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void sayHello() {
		System.out.println(this.name + "(" + age + ")" +": " + this.greeting);
	}
	
	
}
