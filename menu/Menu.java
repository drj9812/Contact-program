package edu.java.contact.menu;

public enum Menu {
 END, SAVE, LIST, INDEX, EDIT, DELETE, UNKNOWN;
	//Menu 타입의 public static final 변수들임

	public static Menu enumIndexReturn(int n) {
		Menu[] menu = values(); // Menu.values(); 같은 클래스 안에서는 클래스이름 생략가능
		if (0 <= n && n < menu.length) {
			//-> values() : 모든 enum 클래스가 가지고 있는 static 메서드.
			//-> values의 리턴 값: enum에서 정의한 열거형 상수들의 배열.
			//-> { END, SAVE, LIST, INDEX, EDIT, DELETE, UNKNOWN }
			return menu[n];
		} else {
			return menu[menu.length - 1]; //unknown
		}
	}
}
