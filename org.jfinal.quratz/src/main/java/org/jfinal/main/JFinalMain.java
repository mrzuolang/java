package org.jfinal.main;

import com.jfinal.core.JFinal;

public class JFinalMain {
	public static void main(String[]args){ 
		JFinal.start("webapp",8000, "/",5);
	}
}
