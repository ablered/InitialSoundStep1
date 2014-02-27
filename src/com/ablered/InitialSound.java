package com.ablered;

import java.util.Map;
import java.util.TreeMap;

import com.ablered.utils.StringUtils;


/**
 * 초성검색 처리 클래스
 * 
 * @author leehanchul
 *
 */
public class InitialSound {
	private static final char[] INITIAL_SOUND_CHARS = 
		{'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ',
		'ㄹ','ㅁ','ㅂ','ㅃ','ㅅ',
		'ㅆ','ㅇ','ㅈ','ㅉ','ㅊ',
		'ㅋ','ㅌ','ㅍ','ㅎ'};
	private String dataArray [][];
	
	/**
	 * default 생성자
	 */
	public InitialSound() {
		dataArray = new String[0][0];
	}
	/**
	 * 데이터를 입력받는 생성자.
	 * 
	 * @param dataArray
	 * 				검색 대상 데이터 배열
	 */
	public InitialSound(String [][] dataArray) {
		this.dataArray = dataArray;
	}
	
	/**
	 * 초성 여부 체크
	 * 
	 * @param character
	 * 		비교할 문자
	 * 
	 * @return
	 * 		초성 여부
	 */
	public boolean isInitialSound(char character) {
		for(char c : INITIAL_SOUND_CHARS){ 
            if(c == character){ 
                return true; 
            } 
        } 
        return false; 
	}
	
	/**
	 * 상품에 대한 초성 매칭 여부 체크
	 * 
	 * @param keyword
	 * 		검색 키워드
	 * 
	 * @param value
	 * 		검색할 대상 상품
	 * 
	 * @return
	 * 		존재여부
	 */
	public boolean isInitialSoundMatching(String keyword, String value) {

		// 입력값이 존재하지 않으면 false
		if("".equals(StringUtils.nvl(keyword)) || "".equals(StringUtils.nvl(value))) {
			return false;
		}
		int diffIndex = 0; 
        int diffLength = value.length() - keyword.length(); 
        int kewordLength = keyword.length();
        
        // 검색어가 검색대상값보다 더 길거나, 
        // 초성 검색어가 두 개 이상 연속 되면 검색이 되어야 한다.
        if(diffLength < 0 || keyword.length() < 2){
            return false;
        }
         
        for(int i = 0;i <= diffLength; i++){ 
        	diffIndex = 0; 
            while(diffIndex < kewordLength){
            	char searchChar = keyword.charAt(diffIndex);	// 검색키워드의 캐릭터
            	char targetChar = value.charAt(i+diffIndex);	// 검색 대상 캐릭터
            	
            	Unicode unicode = new Unicode();            	
            	// 검색어가 유니코드인지 체크
                if(unicode.isUnicode(searchChar)){
                    return false;
                }
                 
                // 검색어가 초성이이고 비교대상이 한글이면 (초성끼리 비교)
                if(isInitialSound(searchChar) && unicode.isHangul(targetChar)){ 
                	int index = unicode.getInitialSoundIndex(targetChar);
                	
                    // 각각의 초성이 같은지 비교 
                    if(INITIAL_SOUND_CHARS[index] == searchChar){ 
                    	diffIndex++; 
                    }else{ 
                        break;
                    }
                // 한글이 아닐 경우(초성이 아닐경우) 비교
                } else {
                    if(targetChar == searchChar){
                    	diffIndex++; 
                    }else{
                        break;
                    }
                } 
            } 
            // 검색어의 길이만큼 모두 일치하면 true 
            if(diffIndex == kewordLength){
                return true;
            }
        }
        // 루프가 끝날때까지 일치하지 않으면 false
        return false; 
	}
	
	/**
	 * 초성 data를 기준으로 상품 검색 및 정렬
	 * 
	 * @param data
	 * 		초성data
	 * 
	 * @return
	 * 		정렬된 검색 결과
	 */
	public Map<Integer, String> searchData(String data) {
		try {
			Map<Integer, String> keyMap = new TreeMap<Integer, String>();
			// 총 상품의 건수만큼 for 문을 수행 
			int size = dataArray.length;
			for(int i = 0; i < size; i++){
				// 매칭되는 상품이 존재하면 map에 저장
				if(isInitialSoundMatching(data, dataArray[i][1])) {
					int money = Integer.parseInt(StringUtils.delComma(dataArray[i][2]));
					int saleCnt = Integer.parseInt(StringUtils.delComma(dataArray[i][3]));
					// 판매매출이 가장 많은 순 정렬 -> (판매가격 * 판매개수) 값을 구해 키로 설정
					Integer key = money * saleCnt;
					keyMap.put(key, dataArray[i][1]);
				}
			}
			return keyMap;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
