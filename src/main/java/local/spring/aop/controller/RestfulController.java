package local.spring.aop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RestfulController
{
	private Map<String, Object> myMap = new HashMap<String, Object>();
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public Map<String, Object> getMap(HttpServletRequest request)
	{
		return myMap;
	}
	
	@RequestMapping(value = "/map/{key}", method = RequestMethod.POST)
	public void put(HttpServletRequest request, @PathVariable Map<String, Object> pathParam, @RequestBody Map<String, Object> requestParam)
	{
		myMap.put((String) pathParam.get("key"), requestParam.get("value"));
	}
}
