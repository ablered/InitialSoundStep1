package com.ablered;


/**
 * 유니코드 상수 정의
 * 
 * @author leehanchul
 *
 */
public class Unicode {
	
	private static final char CHARS_BEGIN = 12593;	// 초성 유니코드 시작 값
	private static final char CHARS_LAST = 12622;	// 초성 유니코드 마지막 값
	private static final char HANGUL_BEGIN = 44032;	// 한글 유니코드 시작 값
	private static final char HANGUL_LAST = 55203;	// 한글 유니코드 마지막 값
	private static final char NUMBER_BEGIN = 48;	// 숫자 유니코드 시작 값
	private static final char NUMBER_LAST = 57;	// 숫자 유니코드 마지막 값
	private static final char LOWER_BEGIN = 65;	// 영문(소문자) 유니코드 시작 값 
	private static final char LOWER_LAST = 90;	// 영문(소문자) 유니코드 마지막 값
	private static final char UPPER_BEGIN = 97;	// 영문(대문자) 유니코드 시작 값
	private static final char UPPER_LAST = 122;	// 영문(대문자) 유니코드 마지막 값
	private static final char HANGUL_BASE_UNIT = 588; // 자음 마다 가지는 글자수
	
	/**
	 * 유니코드 여부 체크
	 * 
	 * @param character
	 * 		비교할 문자
	 * 
	 * @return
	 * 		유니코드 여부
	 */
	public boolean isUnicode(char character) {
		char [] startChar = {CHARS_BEGIN, HANGUL_BEGIN, NUMBER_BEGIN, LOWER_BEGIN, UPPER_BEGIN};
		char [] endChar = {CHARS_LAST, HANGUL_LAST, NUMBER_LAST, LOWER_LAST, UPPER_LAST};
		
		// 초성, 영문 대소문자, 숫자, 한글 유니코드 범위 체크
		for(int i = 0; i < startChar.length; i++) {
			if(!isUnicodeRange(character, startChar[i], endChar[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 유니코드 범위 체크
	 * 
	 * @param character
	 * 		비교할 대상 문자
	 * @param beginChar
	 * 		비교 시작 문자
	 * @param lastChar
	 * 		비교 종료 문자
	 * 
	 * @return
	 * 		범위 여부
	 */
	public boolean isUnicodeRange(char character, char beginChar, char lastChar) {
		return  character >= beginChar && character <= lastChar;
	}
	
	/**
	 * 한글 여부 체크
	 * 
	 * @param character
	 * 		비교할 문자
	 * 
	 * @return
	 * 		한글 여부
	 */
	public boolean isHangul(char character) {
		return isUnicodeRange(character, HANGUL_BEGIN, HANGUL_LAST); 
	}
	
	/**
	 * 문자(한글)의 초성 index를 반환
	 * 
	 * @param character
	 * 		비교할 문자
	 * 
	 * @return
	 * 		한글 여부
	 */
	public int getInitialSoundIndex(char character) {
		int firstIndex = (character - HANGUL_BEGIN); 
        return firstIndex / HANGUL_BASE_UNIT;        
	}
}

