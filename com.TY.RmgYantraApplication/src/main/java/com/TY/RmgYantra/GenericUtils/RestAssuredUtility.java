package com.TY.RmgYantra.GenericUtils;

import io.restassured.response.Response;

/**
 * This class contains restassured specific methods
 * @author Chaitra
 *
 */
public class RestAssuredUtility {
	
	/**
	 * resturns json data wrt json path
	 * @param response
	 * @param jsonxpath
	 * @return
	 */
	public String jsonPathConsant(Response response, String jsonxpath)
	{
		String jsondata = response.jsonPath().get(jsonxpath);
		return jsondata;
	}

}
