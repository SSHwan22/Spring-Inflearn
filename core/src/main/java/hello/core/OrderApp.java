package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
		// 멤버 아이디 생성
		Long memberId = 1L;
		
		// Member 객체 생성
		Member member = new Member(memberId, "memberA", Grade.VIP);
		
		// 회원 가입
		memberService.join(member);
		
		// Order 객체 생성
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		
		System.out.println("order = " + order);
		System.out.println("order = " + order.calculatePrice());
	}
}
