package hello.coreJava.discount;

import hello.coreJava.member.Grade;
import hello.coreJava.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

	private int discoutnFixAmount = 1000; //1000원 할인
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discoutnFixAmount;
		}else {
			return 0;
		}
	}

}
