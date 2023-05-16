package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// 기존에 작성한 예제들에 있는 @Configuration이 붙은 클래스는 제외. 
public class AutoAppConfig {

//	@Bean(name="memoryMemberRepository")
//	MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//	}
}
