package hello.coreJava.member;

public class MemberServiceImpl implements MemberService{

	//필드
	private final MemberRepository memberRepository;
	
	//생서자
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//메서드
	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
