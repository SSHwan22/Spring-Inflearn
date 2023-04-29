package hello.coreOOP;

import hello.coreOOP.member.Grade;
import hello.coreOOP.member.Member;
import hello.coreOOP.member.MemberService;
import hello.coreOOP.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// 저장소에 회원정보 저장
		memberService.join(member);
		
		// 저장소에 저장된 회원정보 찾고 Member객체에 담기
		Member findMember = memberService.findMember(1L);
		
		System.out.println("찾으신 회원(findMember) : " + findMember.getName());
		System.out.println("그냥 member : "+member.getName());
		
	}
}
 