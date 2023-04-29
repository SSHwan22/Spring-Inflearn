package hello.coreOOP;

import hello.coreOOP.member.Grade;
import hello.coreOOP.member.Member;
import hello.coreOOP.member.MemberService;
import hello.coreOOP.member.MemberServiceImpl;
import hello.coreOOP.order.Order;
import hello.coreOOP.order.OrderService;
import hello.coreOOP.order.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		
		// 멤버 아이디 생성
		Long memberId = 1L;
		
		// Member 객체 생성
		Member member = new Member(memberId, "memberA", Grade.VIP);
		
		// 회원 가입
		memberService.join(member);
		
		// Order 객체 생성
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		System.out.println("order = " + order);
		System.out.println("order = " + order.calculatePrice());
	}
}
