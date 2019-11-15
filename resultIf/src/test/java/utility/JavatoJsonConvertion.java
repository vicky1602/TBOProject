package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  Resources.*;

public class JavatoJsonConvertion extends base {

	public static String JasonToJavaConvertor(Object object)

	{
	ObjectMapper mapper = new ObjectMapper();
	String JsonResult = null;
	try {
		JsonResult = mapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return JsonResult;
	}
}
