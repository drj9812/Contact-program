package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	// 상수(constant)
	private static final int MAX_LENGTH = 5; // 물어보기 2 얘는 왜 static??
	// private를 사용한 이유 : 클래스 안에서만 사용하기 위해, main에서만 쓰기 위해
	// 연락처 배열의 최대 길이(원소 개수)
	// static 으로 선언 안 해도 상관없음
	// 그치만 보통 상수를 선언할 때 static을 붙힘(관습 : convention)
	// 여러 클래스에서 사용되는 값을 경우 private 대신 public을 사용

	// field
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열.
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가(배열이 꽉 찼음을 확인하기 위함)
	private Scanner scanner = new Scanner(System.in); // 입력도구 //여러 메서드에서 같이 사용하기 위해 field로 선언함
	// 메서드 안에서 생성하면 생기는 일 물어보기
	// 지역 변수로 선언하면 메모리 측면에서 손해고
	// 계속 scanner를 닫아줘야하

	public static void main(String[] args) { // main이 static이다 보니 객체생성없이 바로 시작할 거고 생성자 호출 전에는 필드들이 메모리에 생겨나기 전이니까 미리
												// 만들어놓는 것
		System.out.println("***** 연락처 프로그램 v0.1 *****");
		ContactMain01 app = new ContactMain01();
		// ->static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성

		boolean run = true;
		while (run) {
			// 메인 메뉴 보여주기
			// 메인 메뉴에서 선택된 값
			int menu = app.showMainMenu();
			switch (menu) {
			case 0:
				run = false; // 프로그램 종료
				break;
			case 1: // 새 연락처 저장
				app.insertNewContact();
				break;
			case 2: // 연락처 전체 목록 보여주기
				app.showContactListByIndex();
				break;
			case 3: // 배열의 인덱스로 검색하기
				app.searchContactByIndex();
				break;
			case 4: // 연락처의 이름/전화번호/email 정보 수정
				app.editContactByIndex();
				break;
			case 5: // 배열의 인덱스로 연락처 삭제하기
				app.deleteContactByIndex();
				break;
			default:
				System.out.println("메인 메뉴 번호를 확인하세요.");
				break;

			}

		}
		System.out.println("***** 프로그램 종료 *****");
	}

	public int showMainMenu() { // static 아닌 이유 : static 너무 많이 남발하면 안 좋음
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("[0] 종료 [1] 새 연락처 등록 [2] 전체 목록 보기 [3] 검색 [4] 수정 [5] 삭제");
		System.out.println("-------------------------------------------------------------------------");
		System.out.print("선택> ");

		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환
		int result = Integer.parseInt(scanner.nextLine());
//		int result = scanner.nextInt();

		return result;
	}

	public void insertNewContact() {
		System.out.println();
		System.out.println("--- 새 연락처 저장 ---");
		
		if (count == MAX_LENGTH) { //배열에 저장된 연락처 개수가 배열 길이와 같다
			System.out.println("메모리가 부족해서 저장할 수 없음.");
			return;//메서드 종료
		} 
		System.out.print("이름 입력> ");
		String name = scanner.nextLine(); // 공백을 포함해서 엔터가 입력될 때까지 모든 문자열을 읽음.
		System.out.print("전화번호 입력> ");
		String phone = scanner.nextLine();
		System.out.println("email 입력> ");
		String email = scanner.nextLine();
		
		// 입력받은 정보들로 Contact 타입의 객체를 생성
		Contact c = new Contact(0, name, phone, email);
		
		// 생성된 Contact 타입의 객체를 배열에 저장
		contacts[count] = c;

		// 배열에 저장된 원소(연락처) 개수를 1 증가.
		count++;

		System.out.println("새 연락처 저장 성공");
	}

	public void showContactListByIndex() {
		for (int i = 0; i < count; i++) {
			System.out.println();
			System.out.println("--- 연락처 목록 ---");
			contacts[i].printInfo();
		}
	}

	public void searchContactByIndex() {
		System.out.println();
		System.out.println("--- 인덱스 검색 ---");
		System.out.print("검색할 인덱스 입력> ");
		int index = Integer.parseInt(scanner.nextLine());
		
//		if (index >= 0 && index < 5) {
//			if (contacts[index] != null) {
//				contacts[index].printInfo();
//			} else {
//				System.out.println("연락처가 없습니다.");
//			}
//		} else {
//			System.out.println("0~4사이의 값을 입력하세요");
//		}
		
		if (index >= 0 && index < count) {
			contacts[index].printInfo();
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없음");
		}

	}

	public void editContactByIndex() {
		System.out.println("--- 연락처 수정 ---");
		System.out.print("수정할 연락처 인덱스 입력> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다");
			return; //메서드 종료
		}
		
		System.out.print("수정 전 :");
		contacts[index - 1].printInfo();// 수정 전의 연락처 정보 출력
		if (contacts[index - 1] != null) {
			System.out.println("무엇을 수정하시겠습니까?");
			System.out.println("1.이름");
			System.out.println("2.전화번호");
			System.out.println("3.email");
			System.out.println("번호를 입력해주십시오");
			int index1 = Integer.parseInt(scanner.nextLine());
			if (index1 == 1) {
				System.out.println("새로운 이름을 입력하세요");
				String name = scanner.nextLine();
				contacts[index1].setName(name);
				contacts[index1].printInfo();
				System.out.println("수정이 완료되었습니다");
			} else if (index1 == 2) {
				System.out.println("새로운 번호를 입력하세요");
				String phone = scanner.nextLine();
				contacts[index1].setPhone(phone);
				contacts[index1].printInfo();
				System.out.println("수정이 완료되었습니다");
			} else if (index1 == 3) {
				System.out.println("새로운 email을 입력하세요");
				String email = scanner.nextLine();
				contacts[index1].setPhone(email);
				contacts[index1].printInfo();
				System.out.println("수정이 완료되었습니다");
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		}
//		contacts[index - 1] = new Contact(0, name, phone, email); 도 가능
	}

	public void deleteContactByIndex() {
		System.out.println("--- 연락처 삭제 ---");
		System.out.print("삭제할 연락처 인덱스 입력> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다");
			return; //메서드 종료
		} //코드 복붙이 싫다면 반대로 조건문을 만들어줘도 됨
		
		if (index >= 0 && index < MAX_LENGTH) {
			for (int i = index; i < count - 1; i++) {
				contacts[i] = contacts[i + 1];
			}
			contacts[count - 1] = null;
			count--;
			System.out.println("삭제 성공");
		} else {
			System.out.println("잘못된 번호입니다.");
		}

	}
}