package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
//		MemberService memberService = new MemberServiceImpl();
//		AppConfig appconfig = new AppConfig();
//		MemberService memberService = appconfig.memberService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// 저장소에 회원정보 저장
		memberService.join(member);
		
		// 저장소에 저장된 회원정보 찾고 Member객체에 담기
		Member findMember = memberService.findMember(1L);
		
		System.out.println("찾으신 회원(findMember) : " + findMember.getName());
		System.out.println("그냥 member : "+member.getName());
		
	}
}
 