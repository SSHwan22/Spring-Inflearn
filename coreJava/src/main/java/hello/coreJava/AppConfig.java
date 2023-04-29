package hello.coreJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.coreJava.discount.DiscountPolicy;
import hello.coreJava.discount.FixDiscountPolicy;
import hello.coreJava.discount.RateDiscountPolicy;
import hello.coreJava.member.MemberRepository;
import hello.coreJava.member.MemberService;
import hello.coreJava.member.MemberServiceImpl;
import hello.coreJava.member.MemoryMemberRepository;
import hello.coreJava.order.OrderService;
import hello.coreJava.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
