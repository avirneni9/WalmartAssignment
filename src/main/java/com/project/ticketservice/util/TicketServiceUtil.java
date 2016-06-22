package com.project.ticketservice.util;

import java.util.Optional;

/**
 * @author Avirneni.Sai
 * 
 */
public class TicketServiceUtil {

	/**
	 * This method is to convert int to Optional parameter
	 * @param value
	 * @return Optional variable
	 */
	public static Optional<Integer> optionalConverter(int value){
		Optional<Integer> optionalValue=Optional.of(new Integer(value));
		return optionalValue;
	}
	/**
	 * This method validates email id
	 * @param eMail
	 * @return true or false
	 */
	public static boolean emailIdValidation(String eMail){
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(eMail.matches(EMAIL_REGEX)){
			return true;
		}
		return false;
	}
}
