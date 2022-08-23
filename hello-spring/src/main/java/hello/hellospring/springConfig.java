package hello.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class springConfig {
	
//	private DataSource datasource;
//	
//	@Autowired
//	public springConfig(DataSource datasource) {
//		this.datasource = datasource;
//	}
	
//	private EntityManager em;
//	
//	@Autowired
//	public springConfig(EntityManager em) {
//	this.em = em;
//}
	
	private final MemberRepository memberRepository;
	
	
	@Autowired //생성자가 1개일 경우에는 @Autowired 에노테이션을 생략가능하다.
	public springConfig(MemberRepository memberRepository) {
	super();
	this.memberRepository = memberRepository;
}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	@Bean
//	public MemberRepository memberRepository() {
////		return new MemoryMemberRepository();
////		return new JdbcMemberRepository(datasource);
////		return new JdbcTemplateMemberRepository(datasource);
//		return new JpaMemberRepository(em);
//	}
	
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
	
}
