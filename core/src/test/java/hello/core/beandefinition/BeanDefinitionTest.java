package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class BeanDefinitionTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	// ApplcationContext는 여기서는 사용하지 못한다. ApplicationContext에는 getBeanDefinition() 메서드를 가지고 있지 않아서다.
	
	@Test
	@DisplayName("빈 설정 메타정보 확인")
	public void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinition = " + beanDefinitionName + " | beanDefinition = " + beanDefinition);
			}
		}
	}
	
}
