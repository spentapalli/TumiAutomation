package com.tumi.utilities;

public class OSFinder {

	private static String os = System.getProperty("os.name").toLowerCase();
	
	public static boolean isWindows() {
		
		return (os.indexOf("win") >= 0);
	}
	
	public static boolean isMac() {
		
		return (os.indexOf("mac") >= 0);
	}
	
	public static boolean isUnix() {
		
		return (os.indexOf("nix") >=0 || os.indexOf("nux") >=0 || os.indexOf("aix") >=0);
	}
	
}
