# springmock
Automatic mocking in spring text contexts

## What problem does it solve
At certain time, you might want to conduct an unit-test in using Spring Context. In many cases only a few beans are involved but the dependency of inject requires a whole chain of dependencies to be loaded.

This framework will create mocks for unresolved dependencies in a very naive way to satisify the dependencies of unreleated beans in order to proceed with the test instead of defining dozens of unrelated mocks/beans that are not actually used in the test.

## What problem does it not solve

Since the bean creation is very naive, it is not intended that automatically created beans should be accessed or be part of any test case since it not respecting the dependency of injection API by other means

## Usage
When defining the use case, set the initializers to ```MockableInitializer```

```java

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(..., initializers = MockableInitializer.class)


```
