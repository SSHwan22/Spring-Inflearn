package hello.coreJava.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.coreJava.AppConfig;
import hello.coreJava.member.Grade;
import hello.coreJava.member.Member;
import hello.coreJava.member.MemberService;

public class OrderSerivceTest {

//	MemberService memberService = new MemberServiceImpl();
//	OrderService orderService = new  OrderServiceImpl();
	
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
