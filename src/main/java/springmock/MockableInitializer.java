package springmock;

import java.lang.reflect.Field;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ReflectionUtils;

public class MockableInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		MockableBeanFactory bf = new MockableBeanFactory((DefaultListableBeanFactory) applicationContext.getBeanFactory());
		
		Field field = ReflectionUtils.findField(applicationContext.getClass(), "beanFactory");
		field.setAccessible(true);
		try {
			field.set(applicationContext, bf);
		} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
	}
	
}
