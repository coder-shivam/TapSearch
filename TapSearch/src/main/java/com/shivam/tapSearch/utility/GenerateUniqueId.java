package com.shivam.tapSearch.utility;

import java.util.UUID;

public class GenerateUniqueId {

	public static int generateUniqueId() {
		
		UUID id = UUID.randomUUID();
		String str = "" + id;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		return Integer.parseInt(str);
	
	}
}
