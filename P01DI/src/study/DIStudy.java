package study;

import java.util.Date;

class Member{
	String name;
	String nickname;
	public Member() {}
	//private Member() {}
}

public class DIStudy {
	public static void main(String[] args) {
		//날짜를 구하기 위해서는 Date 클래스에 의존
		Date date = new Date();
		System.out.println(date);
		getDate(date);
	}
	public static void getDate(Date d) {
		Date date=d;
		System.out.println(date);
	}
	public static void memberUse1() {
		//강한 결합: 직접 생성
		Member m1 = new Member();
	}
	public static void memberUse2(Member m) {
		//약한 결합: 생성된 것을 주입받음.-DI(Dependency Injection)
		Member m2=m;
	}
}
