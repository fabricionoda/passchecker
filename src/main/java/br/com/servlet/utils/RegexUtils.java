package br.com.servlet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	public static final int occurrences(String value, String regexPattern){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(value);        
        int count = 0;
        while (matcher.find()) {
          count+=matcher.group(0).length();
        }
        return count;
	}
	
	public static final boolean match(String value, String regexPattern){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(value);  
		return matcher.matches();
	}
	
	public static final int consecutiveMatches(String value,String regex){
		//Copia algorítmo de pwdmeter.js http://www.passwordmeter.com/
		int count = 0;
		for (int index = 0; index < value.length(); index++) {
			if (isMatch(value, index,regex)){
				boolean end = false;
				for (int cursor = index + 1; cursor < value.length(); cursor++) {
					if (!isMatch(value, cursor,regex)){
						index = cursor;
						break;
					}
					count += 1;
					end = (cursor >= value.length() - 1);
				}
				if (end)
					break;
			}
		}
		return count;
	}
	
	public static final int sequenceMatches(String value,Sequence sequence){
		//Copia algorítmo de pwdmeter.js http://www.passwordmeter.com/
		int contador = 0;
		String sequenceLower = sequence.toString().toLowerCase();
		for (int s=0; s < sequenceLower.length()-3; s++) {
			String sFwd = sequenceLower.substring(s, s+3);
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (value.toLowerCase().indexOf(sFwd) != -1 || value.toLowerCase().indexOf(sRev) != -1) { contador++;}
		}
		return contador;		
	}
	
	private static boolean isMatch(String pass, int index,String regex) {
		return Character.toString(pass.charAt(index)).matches(regex);
	}
}
