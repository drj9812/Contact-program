package edu.java.contact.model;

// MVC(Model-View-Controller) 아키텍쳐에서 Model에 해당하는 클래스.
// 특별한 기능은 없는, 순수하게 데이터만 설계하는 클래스.
// VO(Value Object) : 값(자료)를 표현하는 객체(모델과 거의 비슷한 개념으로 사용됨)
// DTO(Data Transfer Object) : 데이터를 전달(메서드 아규먼트, 리턴 값)할 때 사용되는 객체
// 보통 모델 클래스가 VO로 이용되기도 하고 DTO로 이용되기도 함 비슷하긴 하지만 분명 다른 개념

public class Contact {
	//field
	private int cid;
	private String name;
	private String phone;
	private String email;
	
	//constructor
	
	public Contact() {}

	public Contact(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	public int getCid() {
		return cid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
//		return "Contact(cid=" + this.cid + ", name=" + this.name + ", phone=" + this.phone + ", email=" + this.email +")";
		return String.format("Contact(cid=%d, name=%s, phone=%s, email=%s", this.cid, this.name, this.phone, this.email);
	}
	
}