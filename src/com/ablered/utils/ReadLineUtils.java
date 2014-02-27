package com.ablered.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 콘솔입력 유틸
 * 
 * @author leehanchul
 *
 */
public class ReadLineUtils {
	/**
	 * BufferedReader를 이용한 Scan 유틸
	 * 
	 * @return 입력받은 문자열 반환
	 */
	public static String scan() {
		String resultStr = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			resultStr = StringUtils.nvl(br.readLine());
			return resultStr;
		} catch (IOException e) {
			e.printStackTrace();
			return resultStr;
		}
	}
}
