package hello.hellospring.service;


import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

public class MemberService {

	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/* ȸ������ */
	public Long join(Member member) {
		//���� �̸��� �ִ� �ߺ� ȸ�� X
		
		 memberRepository.findByName(member.getName())
												.ifPresent(a->{
													throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
												});
		
		memberRepository.save(member);
		return member.getId();
		
	}
	
	/* ��üȸ�� ��ȸ */
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}