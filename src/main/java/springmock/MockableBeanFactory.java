package springmock;

import java.util.Map;

import org.mockito.Mockito;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.google.common.collect.ImmutableMap;

public class MockableBeanFactory extends DefaultListableBeanFactory {
	public MockableBeanFactory(DefaultListableBeanFactory parent) {
		super(parent);
	}

	@Override
	protected Map<String, Object> findAutowireCandidates(String beanName, Class<?> requiredType,
			DependencyDescriptor descriptor) {
		Map<String, Object> map = super.findAutowireCandidates(beanName, requiredType, descriptor);
		
		if (map.isEmpty()) {
			return ImmutableMap.of(beanName, Mockito.mock(requiredType));
		}
		
		return map;
	}

	
}
