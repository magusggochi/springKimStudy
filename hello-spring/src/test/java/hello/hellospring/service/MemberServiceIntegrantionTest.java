package hello.hellospring.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
class MemberServiceIntegrantionTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository repository;
	
	@Test
	void 회원가입테스트() {
		//given
		Member member = new Member();
		member.setName("spring");
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void 테스트2() {
		//GIVEN
		Member member = new Member();
		member.setName("magu");
		
		Member member2 = new Member();
		member2.setName("magu");
		//WHEN
		memberService.join(member);
		try {
			memberService.join(member2);
			fail();
		}catch (IllegalStateException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("안됩니다요");
		}
		//THEN
	}

}
