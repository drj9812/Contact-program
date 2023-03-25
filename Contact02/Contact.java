package edu.java.contact02;

//연락처 정보를 저장하는 클래스

public class Contact {
	//field
	private int cid; //지금(version 0.1)에선 사용하지는 않지만 나중을 위해 만들어 놓은 변수(연락처 고유 번호(동명이인을 구별하기 위함)
	private String name; // 이름 저장
	private String phone; // 전화번호
	private String email; // 이메일
	//다른 클래스에선 보지 못하도록 하기 위해
	
	//물어볼 거: 개별적인 필드는 다른 클래스에서 접근하지 못하지만 생성자를 public으로 설정함으로써 접근 가능한 건가?
	
	//constructor
	public Contact() {}
	
	public Contact(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
 	//method
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
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
	
//	method
	public void printInfo() {
		System.out.printf("Contact(cid=%d, name=%s, phone=%s, email=%s)%n",
				this.cid, this.name, this.phone, this.email);
	}
	//위 printInfo메서드를 아래처럼 toString()메서드를 override해서 대체함
	@Override
	public String toString() {
		return "Contact(cid=" + this.cid + ", name=" + this.name + ", phone=" + this.phone + ", email=" + this.email + ")";
		
	}
}