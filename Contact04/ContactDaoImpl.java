package edu.java.contact04;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

//MVC(Model - View - Controller) 아키텍쳐에서 인터페이스로 설계한 컨트롤러(Dao)를 구현하는 클래스
//singleton 디자인 패턴을 적용.
//version2에선 메인에서 하던 기능들을 이젠 전부 이 클래스에서 해결할 거임

public class ContactDaoImpl implements ContactDao {
//ContactDaoImpl 객체를 여러개 생성하게 되면 각각의 객체들마다 연락처 배열을 가지게 됨(저장, 읽기가 다를 수 있으므로 singleton 패턴을 적용하는 것)

	// singleton step 1
	private static ContactDaoImpl instance = null;

	// singleton step 2
	// constructor
	private ContactDaoImpl() {
	} // 생성자를 private으로 설정하면 자신의 클래스에서만 생성됨. 외부에선 x

	// singleton step 3
	public static ContactDaoImpl getInstance() { // getInstance()를 몇번 호출하던 최초로 생성된 객체의 주소값만 저장됨
		if (instance == null) {// 객체 생성 전이라면
			instance = new ContactDaoImpl();
		}
		return instance;

	}
	// 위 3단계가 충족되면 singleton 패턴이 완성됨

	// fields
//	private static final int MAX_LENGTH = 5; // 배열의 길이(크기), 다른 클래스에선 보여지지 않기 위해 private으로 선언
	// -> 인터페이스 ContactDao에서 선언해도 되지만 그러면 public 으로 다른 클래스에서 보여지기 때문에 private으로 선언할
	// 수 있는 class 에서 선언
//	private Contact[] contacts = new Contact[MAX_LENGTH];
//	private int count = 0; // 배열에 현재까지 저장된 연락처 객체의 개수.
	// ->배열에 연락처를 저장할 때 +1, 배열에서 연락처를 삭제할 때 -1

	private ArrayList<Contact> contacts = new ArrayList<>(); // = 생성자 호출; 
	// methods
	/**
	 * 연락처 배열에 새로운 연락처 객체를 저장할 수 있는 공간이 남아있는지를 리턴.
	 * 
	 * @return 배열에 빈 공간이 있으면 true, 그렇지 않으면 false.
	 */
	// 배열에 더 저장할 공간이 있는지 없는지 알려주는 메서드
//	public boolean isMemoryAvailable() {
//		return count < MAX_LENGTH;
//	}

//	ContactDaoImpl 클래스의 멤버들이 private로 선언되어있기 때문에 배열의 크기가 몇인지 현재 인덱스 몇까지
	// 저장되어있는지 외부에선 알 수 없기 때문에 public method를 생성해서 접근하는 것

	/**
	 * 어떤 index가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인지를 리턴
	 * 
	 * @param index 유효한 인덱스인지 검사할 인덱스.
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false를 리턴
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}

	// CRUD(Create, Read, Update, Delete) 기능 메서드들 :
	@Override
	public void create(Contact c) {
		// 이미 이 메서드에 왔다는 건 메모리에 공간이 남아있다는 뜻이지만 한번 더 검사
		// 자기가 자기 메서드 부르는 건 언제든지 가능함
//		if (isMemoryAvailable()) { // 배열에 빈 공간이 있으면
//			contacts[count] = c;
//			count++;
//
//			return 1;
//		} else {
//			return 0;
//		}
		contacts.add(c); //항상 true를 return 함
	}

	@Override
	public List<Contact> read() { //상위 클래스의 메서드를 오버라이드 할 때 수식어는 달라져도 됨 대신 더 넓어지는 방향으로
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;			
		}
	}

	@Override
	public int update(int index, Contact contact) {
//		if (isValidIndex(index)) {
////			contacts[index].setName(contact.getName());
////			contacts[index].setPhone(contact.getPhone());
////			contacts[index].setEmail(contact.getEmail());
//			contacts[index] = contact; //위 세줄을 한 줄로
//			return 1;
//		} else {
//			return 0;
//		}
		
		if (!isValidIndex(index))
			return 0;
		contacts.set(index, contact); // 리턴값으로 교체된 요소들을 반환함
		return 1;
	}

	@Override
	public int delete(int index) {
		if (!isValidIndex(index)) 
			return 0;
		
//		for (int i = index; i < count - 1; i++) {
//			contacts[i] = contacts[i + 1];
//					
//		}
//		contacts[count - 1] = null;
//		count--;
//		
//		return 1;
//		contacts[index] = null;
//		count--;
//		return 1;
		
		contacts.remove(index);
		return 1;
	}

}