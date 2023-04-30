package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class AplicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 출력하기")
	public void finApplicationBean() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("이름없이 타입으로만 조회")
	public void findBeanType() {
		MemberService memberService = ac.getBean(MemberService.class);
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 출력하기")
	public void findBeanType2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회X")
	public void findBeanByNameX() {
		ac.getBean("xxxxx", MemberService.class);
		MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
		System.out.println("memberService : " + xxxxx);
		System.out.println("memberService.getClass() = " + xxxxx.getClass());
		
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxxxx", MemberService.class));
	}
}
