package hello.coreOOP.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.coreOOP.member.Grade;
import hello.coreOOP.member.Member;
import hello.coreOOP.member.MemberService;
import hello.coreOOP.member.MemberServiceImpl;

public class OrderSerivceTest {

	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new  OrderServiceImpl();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
