package com.TY.RmgYantra.GenericUtils;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Chaitra
 *
 */
public class JavaUtility {
	
	/**
	 * generate random number
	 * @return
	 */
	public int randomNumber()
	{
		Random random = new Random(); 
		int ran=random.nextInt(1000);
		return ran;
	}

}
