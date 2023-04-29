package hello.coreOOP.discount;

import hello.coreOOP.member.Grade;
import hello.coreOOP.member.Member;

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
