package hello.coreJava.order;

import hello.coreJava.discount.DiscountPolicy;
import hello.coreJava.discount.FixDiscountPolicy;
import hello.coreJava.member.Member;
import hello.coreJava.member.MemberRepository;
import hello.coreJava.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
