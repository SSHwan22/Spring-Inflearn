package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	public void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefuleService1 = ac.getBean(StatefulService.class);
		StatefulService statefuleService2 = ac.getBean(StatefulService.class);
		
		// ThreadA : A사용자 10000원 주문
//		statefuleService1.order("userA", 10000);
		int userAPrice = statefuleService1.order("userA", 10000);
		
		// ThreadB : B사용자 20000원 주문
//		statefuleService2.order("userB", 20000);
		int userBPrice = statefuleService2.order("userB", 20000);
		
		// ThreadA : 사용자A 주문 금액 조회
//		int price = statefuleService1.getPrice();
		System.out.println("priceA = "+ userAPrice);
		System.out.println("priceB = "+ userBPrice);
		
//		Assertions.assertThat(statefuleService1.getPrice()).isEqualTo(20000);
		
	}
	
	// 테스트용도의 bean 생성 
	static class TestConfig{
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
