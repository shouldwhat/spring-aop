package local.spring.aop.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController
{
	private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class);
	
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public void executeException(HttpServletRequest request) throws Exception
	{
		LOG.info("--------------------------------------- [START] ExceptionController->executeException()");
		
		if(true)
		{
			throw new Exception("excute force exception");
		}
	}
}
