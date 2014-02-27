package com.ablered;


/**
 * �����ڵ� ��� ����
 * 
 * @author leehanchul
 *
 */
public class Unicode {
	
	private static final char CHARS_BEGIN = 12593;	// �ʼ� �����ڵ� ���� ��
	private static final char CHARS_LAST = 12622;	// �ʼ� �����ڵ� ������ ��
	private static final char HANGUL_BEGIN = 44032;	// �ѱ� �����ڵ� ���� ��
	private static final char HANGUL_LAST = 55203;	// �ѱ� �����ڵ� ������ ��
	private static final char NUMBER_BEGIN = 48;	// ���� �����ڵ� ���� ��
	private static final char NUMBER_LAST = 57;	// ���� �����ڵ� ������ ��
	private static final char LOWER_BEGIN = 65;	// ����(�ҹ���) �����ڵ� ���� �� 
	private static final char LOWER_LAST = 90;	// ����(�ҹ���) �����ڵ� ������ ��
	private static final char UPPER_BEGIN = 97;	// ����(�빮��) �����ڵ� ���� ��
	private static final char UPPER_LAST = 122;	// ����(�빮��) �����ڵ� ������ ��
	private static final char HANGUL_BASE_UNIT = 588; // ���� ���� ������ ���ڼ�
	
	/**
	 * �����ڵ� ���� üũ
	 * 
	 * @param character
	 * 		���� ����
	 * 
	 * @return
	 * 		�����ڵ� ����
	 */
	public boolean isUnicode(char character) {
		char [] startChar = {CHARS_BEGIN, HANGUL_BEGIN, NUMBER_BEGIN, LOWER_BEGIN, UPPER_BEGIN};
		char [] endChar = {CHARS_LAST, HANGUL_LAST, NUMBER_LAST, LOWER_LAST, UPPER_LAST};
		
		// �ʼ�, ���� ��ҹ���, ����, �ѱ� �����ڵ� ���� üũ
		for(int i = 0; i < startChar.length; i++) {
			if(!isUnicodeRange(character, startChar[i], endChar[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �����ڵ� ���� üũ
	 * 
	 * @param character
	 * 		���� ��� ����
	 * @param beginChar
	 * 		�� ���� ����
	 * @param lastChar
	 * 		�� ���� ����
	 * 
	 * @return
	 * 		���� ����
	 */
	public boolean isUnicodeRange(char character, char beginChar, char lastChar) {
		return  character >= beginChar && character <= lastChar;
	}
	
	/**
	 * �ѱ� ���� üũ
	 * 
	 * @param character
	 * 		���� ����
	 * 
	 * @return
	 * 		�ѱ� ����
	 */
	public boolean isHangul(char character) {
		return isUnicodeRange(character, HANGUL_BEGIN, HANGUL_LAST); 
	}
	
	/**
	 * ����(�ѱ�)�� �ʼ� index�� ��ȯ
	 * 
	 * @param character
	 * 		���� ����
	 * 
	 * @return
	 * 		�ѱ� ����
	 */
	public int getInitialSoundIndex(char character) {
		int firstIndex = (character - HANGUL_BEGIN); 
        return firstIndex / HANGUL_BASE_UNIT;        
	}
}

