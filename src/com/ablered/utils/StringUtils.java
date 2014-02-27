package com.ablered.utils;

/**
 * ���ڿ� ��ȿ�� üũ ��ƿ
 * 
 * @author leehanchul
 *
 */
public class StringUtils {
	
	/**
	 * null üũ ��ȿ�� ��ƿ
	 * 
	 * @param str
	 * 		������ ���ڿ�
	 * 
	 * @return
	 * 		������ ���ڿ�
	 */
	public static String nvl(String str) {
		if(str != null) {
			return str;
		} else {
			return "";
		}
	}
	
	/**
	 * �Էµ� �����Ͱ� �������� üũ
	 * 
	 * @param str
	 * 		������ ���ڿ�
	 * 
	 * @return
	 * 		���� ����
	 */
	public static boolean onlyNum(String str) {
		try {
			int n = Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
			return false;
		} catch (Exception e) {
			System.out.println("�˼� ���� ���� �߻�.");
			return false;
		}
	}
	
	/**
	 * �ĸ� ���� ���
	 * 
	 * @param str
	 * 				������ ��� ���ڿ�
	 * @return
	 * 		���ŵ� ���ڿ� ��ȯ
	 */
	public static String delComma(String str) {
		return nvl(str).replaceAll(",", "");
	}
	
}
