package local.spring.aop.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class JsonMapperConfiguration
{
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter()
	{
		MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
		
		return jacksonMessageConverter;
	}
}
