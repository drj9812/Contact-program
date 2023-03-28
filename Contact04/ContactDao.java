package edu.java.contact04;

import java.util.List;

import edu.java.contact.model.Contact;

//MVC(Model-View-Controller) : 아키텍쳐에서 Controller 역할을 수행할 인터페이스(구현할 클래스가 있어야함)
//DAO(Data Access Object) : 데이터를 사용해서 비즈니스 로직(기능)을 수행하는 객체 (저장, 수정, 검색, 삭제 등등)
//비슷한 성격을 가지고 있는 클래스들을 폴더로 구분해서 그 폴더들의 밑에다가 각각의 파일들을 저장하는 게 패키지


public interface ContactDao {
	
	/**
	 * 새 연락처 저장 기능. 연락처 객체를 배열에 저장.
	 * @param c 리스트에 저장할 연락처 객체.
	 * @return 리스트에 성공하면 1을 리턴, 실패하면 0을 리턴
	 */
	void create(Contact c); //인터페이스라 public abstract 생략 가능함
	//int create(String name, String phone, String email)도 가능함(아규먼트를 한개 가질 것인가 여러개 가질 것인가의 차이)
	/**
	 * 연락처 전체 목록 보기 기능. 저장된 연락처 개수 크기의 연락처 리스트를 리턴.
	 * @return 연락처 리스트를 리턴해줄 수 있으면 Main은 화면에다가 그거를 print하면 됨<- 이걸 생각하면서 설계
	 */
	List<Contact> read(); //List<Contact> read();
	
	/**
	 * 인덱스 검색. 전달받은 인덱스 위치에 있는 연락처 객체를 리턴.
	 * @param index 검색할 인덱스. 0 이상의 정수.
	 * @return 해당 인덱스의 연락처(Contact 타입) 객체이거나 또는 null(해당하는 인덱스가 null인 경우(아규먼트에 음수가 들어오거나 배열의 크기를 뛰어넘는 경우))
	 * 
	 */
	Contact read(int index); // read() 인터페이스 오버로딩
	
	/**
	 * 인덱스 수정 기능
	 * @param index 수정할 연락처의 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수
	 * @param contact(type) 수정할 연락처 정보의 객체.
	 * @return 수정 성공하면 1을 리턴하고 실패하면 0을 리턴
	 */
	int update(int index, Contact contact);
	
	/**
	 * 연락처 삭제 기능
	 * @param index 삭제할 연락처의 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수.
	 * @return 삭제 성공하면 1, 실패하면 0.
	 */
	int delete(int index);
	
}