package com.ablered.utils;

/**
 * 문자열 유효성 체크 유틸
 * 
 * @author leehanchul
 *
 */
public class StringUtils {
	
	/**
	 * null 체크 유효성 유틸
	 * 
	 * @param str
	 * 		검증할 문자열
	 * 
	 * @return
	 * 		검증된 문자열
	 */
	public static String nvl(String str) {
		if(str != null) {
			return str;
		} else {
			return "";
		}
	}
	
	/**
	 * 입력된 데이터가 숫자인지 체크
	 * 
	 * @param str
	 * 		검증할 문자열
	 * 
	 * @return
	 * 		숫자 여부
	 */
	public static boolean onlyNum(String str) {
		try {
			int n = Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			return false;
		} catch (Exception e) {
			System.out.println("알수 없는 오류 발생.");
			return false;
		}
	}
	
	/**
	 * 컴마 제거 기능
	 * 
	 * @param str
	 * 				제거할 대상 문자열
	 * @return
	 * 		제거된 문자열 반환
	 */
	public static String delComma(String str) {
		return nvl(str).replaceAll(",", "");
	}
	
}
