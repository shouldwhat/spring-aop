# spring-aop

-. Logging 이라는 작업을 Aspect로 선정하고, Spring AOP를 적용.

-. 용어설명

1. aspect : 횡적이며 공통적으로 수행해야할 작업.

2. pointcut : aspect를 적용할 지점. (@Before, @After, @AfterReturning, @AfterThrowing)

3. advice : pointcut에서 수행할 작업.

4. weaving : 처리할 aspect에 대해 pointcut 지점에서 가로채는 행위.  