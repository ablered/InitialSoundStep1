package com.ablered.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * �ܼ��Է� ��ƿ
 * 
 * @author leehanchul
 *
 */
public class ReadLineUtils {
	/**
	 * BufferedReader�� �̿��� Scan ��ƿ
	 * 
	 * @return �Է¹��� ���ڿ� ��ȯ
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
