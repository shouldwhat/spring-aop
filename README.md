# spring-aop

-. Logging 이라는 작업을 Aspect로 선정하고, Spring AOP를 적용.


-. 용어설명

    1. aspect : 횡적이며 공통적으로 수행해야할 작업.

    2. pointcut : aspect를 적용할 지점. (@Before, @After, @AfterReturning, @AfterThrowing)

    3. advice : pointcut에서 수행할 작업.

    4. weaving : 처리할 aspect에 대해 pointcut 지점에서 가로채는 행위.  


-. pointcut(weaving 지점) 표현식

    1. 지점(접근한정자 패키지경로.메소드명(입력인자))

    2. execution(* local.spring.aop..*.*(..))

    3. execution(public local.spring.aop..*.*(..))

    4. execution(private local.spring.aop..*.set*(..))

    5. execution(private local.spring.aop..*.get*(..))

    6. execution(private local.spring.aop.*Controller.*(..))

    7. ...
