package bean;

public class PersonService {
	
	// 2-1 필드 만들기

	private Person person;
	
	public PersonService(Person person) {
		this.person = person;
	}

	// 필요한 이유 = autowire의 byName을 이용하기 위해)
	public void setperson(Person person) {
		this.person = person;
	}

	// 2-2 person 객체의 getName 호출하여 그 값을 출력하는 메소드 만들기
	public void getName() {
		System.out.println(person.getName());
	}


	
}
