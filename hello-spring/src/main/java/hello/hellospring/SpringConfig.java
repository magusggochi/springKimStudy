package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

//	private DataSource dataSource;
//	
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

//	private EntityManager em;
//
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
// timetraceaop 에서 @component 를 안썼다면 여기에 @bean 등록해야함	
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}

//	@Bean
//	public MemberRepository memberRepository() {
////		return new MemoryMemberRepository();  // 메모리 객체 
////		return new JdbcMemberRepository(dataSource);  //순수 jdbc
//		
////		return new JdbcTemplateMemberRepository(dataSource);   //jdbcTemplate
////		return new JpaMemberRepository(em); //jpa
//		
//	}

}
