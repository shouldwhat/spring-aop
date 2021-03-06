package local.spring.aop.aspect;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect
{
	private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* local.spring.aop..*.*(..)) && args(request,..)")
	public void hookBefore(JoinPoint joinPoint, HttpServletRequest request)
	{
		LOG.info("---------------------------------------- aspect hook [BEFORE] !!!");
		
		/* [Step.1] approach input arguments of method */
		Object[] args = joinPoint.getArgs();
		
		/* [Step.2-1] first arg : HttpServletRequest */
		if( (args.length > 0) && (args[0] instanceof HttpServletRequest) )
		{
			HttpServletRequest req = (HttpServletRequest) args[0];
			
			LOG.info("---------------------------------------- [REQUEST] URI = {}", req.getRequestURI());
		}
		/* [Step.2-2] second arg : @PathVariables */
		if( (args.length > 1) && (args[1] instanceof Map) )
		{
			Map<String, Object> pathParam = (Map<String, Object>) args[1];
			
			LOG.info("---------------------------------------- [REQUEST] Path Param = {}", pathParam);			
		}
		/* [Step.2-3] third : @RequestBody */
		if( (args.length > 2) && (args[2] instanceof Map) )
		{
			Map<String, Object> requestBody = (Map<String, Object>) args[2];
			
			LOG.info("---------------------------------------- [REQUEST] Body Param = {}", requestBody);			
		}
	}
	
	@After("execution(* local.spring.aop..*.*(..))")
	public void hookAfter(JoinPoint joinPoint)
	{
		LOG.info("---------------------------------------- aspect hook [AFTER] !!!");
	}
	
	@AfterReturning(pointcut = "execution(* local.spring.aop..*.*(..))", returning = "result")
	public void hookAfterReturning(JoinPoint joinPoint, Object result)
	{
		LOG.info("---------------------------------------- aspect hook [AFTER RETURNING] !!!");
		
		/* approach output parameters of method */
		LOG.info("---------------------------------------- result = {}", result);
	}
	
	@AfterThrowing(pointcut = "execution(* local.spring.aop..*.*(..))", throwing = "exception")
	public void hookException(JoinPoint joinPoint, Exception exception)
	{
		LOG.info("---------------------------------------- aspect hook [AFTER EXCEPTION] !!!");
		
		/* approach be throwed Exception */
		LOG.info("---------------------------------------- expcetion msg = {}", exception.getMessage());;
	}
}
