package com.ablered;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * 초성검색 테스트 클래스
 * 
 * @author leehanchul
 *
 */
public class InitialSoundTest {
	
	// 검색 대상 배열을 프로그램과 동일하게 초기화
	public static final String [][] PRODUCT_ITEM_ARRAY =  {
		{"24771911","KFC 치킨불고기 콤보","2,600","27"},
		{"24756487","소다/카시오 패션스포츠시계","49,800","2"},
		{"24750911","[목동] 육감숯불구이","21,600","4"},
		{"24718904","[정자] 박종일 프로헤어",	"29,000","1"},
		{"24703223","[구로디지털] LA식당","30,000","29"},
		{"24702630","고려홍삼명가 명기홍삼정",	"65,300","1"},
		{"24692301","쿠쿠 압력밥속","21,000","2"},
		{"24671273","나이키 BEST 런닝화 22종","45,000","20"},
		{"24670532","투세븐 자체제작 F/W신상슈즈","34,900","2"},
		{"24669991","가을맞이 모던큐트 로퍼/플랫","17,900","9"},
		{"24669702","트루릴리젼 프리미엄 스니커즈","37,500","1"},
		{"24667948","나이키 남녀 팬츠 모음전","49,000","1"},
		{"24664912","축구/농구/배구 공모음전","14,000","6"},
		{"24661322","쿨제이 가을신상 트랜디셔츠","19,800","2"},
		{"24660422","도드람포크 돼지갈비","5,400","1"},
		{"24659696","[후쿠오카]자유여행 3일 189000","189,000","1"},
		{"24659141","HK CLA다이어트","29,700","1"},
		{"24654726","[청담] 민한복","350,000","15"},
		{"24654255","[동대문] 애니피부","15,000","4"},
		{"24651025","영진 표고버섯 슬라이스 1kg","18,500","2"}
	};
	InitialSound initSound;
	
	/**
	 * 테스트 전 초기화
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		initSound = new InitialSound(PRODUCT_ITEM_ARRAY);
	}
	
	/**
	 *  초성검색 테스트
	 */
	@Test
	public void testSearchData() {
		// 테스트할 초성 배열
		String [] inputData = {
				"ㅇㄹ", "ㅇㄹㅂ", "ㅇㄹㅂㅅ", "ㄹㅂ", "ㄹㅂㅅ", "ㅂㅅ", "KFC", "LA", 
				"ㅎㅅㅈ", "ㄱㄹ", "ㄷㄷ", "???", "!@#", 
				"asdjfkal;sdjf;laskdjfalksdjf", "1231241243123123123", "      "};
		int size = inputData.length;
		for(int i = 0; i < size; i++) {
			
			// 입력값 출력
			System.out.println(String.format("\n입력값 : %s", inputData[i]));
			assertNotNull(String.format("\n입력값 : %s", inputData[i]),  inputData[i]);
			
			Map<Integer, String> map = initSound.searchData(inputData[i]);
			
			// 출력결과
			System.out.println(String.format("\n{금액=제품명} : %s", map));
			assertNotNull(String.format("\n{금액=제품명} : %s", map),  map);
		}
	}
	
	/**
	 *  초성검색 테스트
	 */
	@Test
	public void testSearchData2() {
		
	}
	
}
