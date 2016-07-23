package springmock;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.Bar;
import app.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Foo.class, initializers = MockableInitializer.class)
public class ApplicationContextTest {
	@Autowired(required=false)
	Foo foo;

	@Autowired(required = false)
	Bar bar;

	@Test
	public void findFoo() {
		Assertions.assertThat(foo).isNotNull();
	}

	@Test
	public void findBar() {
		Assertions.assertThat(bar).isNotNull();
	}

}
