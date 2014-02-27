package com.ablered;

import java.util.Map;
import java.util.TreeMap;

import com.ablered.utils.StringUtils;


/**
 * �ʼ��˻� ó�� Ŭ����
 * 
 * @author leehanchul
 *
 */
public class InitialSound {
	private static final char[] INITIAL_SOUND_CHARS = 
		{'��','��','��','��','��',
		'��','��','��','��','��',
		'��','��','��','��','��',
		'��','��','��','��'};
	private String dataArray [][];
	
	/**
	 * default ������
	 */
	public InitialSound() {
		dataArray = new String[0][0];
	}
	/**
	 * �����͸� �Է¹޴� ������.
	 * 
	 * @param dataArray
	 * 				�˻� ��� ������ �迭
	 */
	public InitialSound(String [][] dataArray) {
		this.dataArray = dataArray;
	}
	
	/**
	 * �ʼ� ���� üũ
	 * 
	 * @param character
	 * 		���� ����
	 * 
	 * @return
	 * 		�ʼ� ����
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
	 * ��ǰ�� ���� �ʼ� ��Ī ���� üũ
	 * 
	 * @param keyword
	 * 		�˻� Ű����
	 * 
	 * @param value
	 * 		�˻��� ��� ��ǰ
	 * 
	 * @return
	 * 		���翩��
	 */
	public boolean isInitialSoundMatching(String keyword, String value) {

		// �Է°��� �������� ������ false
		if("".equals(StringUtils.nvl(keyword)) || "".equals(StringUtils.nvl(value))) {
			return false;
		}
		int diffIndex = 0; 
        int diffLength = value.length() - keyword.length(); 
        int kewordLength = keyword.length();
        
        // �˻�� �˻���󰪺��� �� ��ų�, 
        // �ʼ� �˻�� �� �� �̻� ���� �Ǹ� �˻��� �Ǿ�� �Ѵ�.
        if(diffLength < 0 || keyword.length() < 2){
            return false;
        }
         
        for(int i = 0;i <= diffLength; i++){ 
        	diffIndex = 0; 
            while(diffIndex < kewordLength){
            	char searchChar = keyword.charAt(diffIndex);	// �˻�Ű������ ĳ����
            	char targetChar = value.charAt(i+diffIndex);	// �˻� ��� ĳ����
            	
            	Unicode unicode = new Unicode();            	
            	// �˻�� �����ڵ����� üũ
                if(unicode.isUnicode(searchChar)){
                    return false;
                }
                 
                // �˻�� �ʼ����̰� �񱳴���� �ѱ��̸� (�ʼ����� ��)
                if(isInitialSound(searchChar) && unicode.isHangul(targetChar)){ 
                	int index = unicode.getInitialSoundIndex(targetChar);
                	
                    // ������ �ʼ��� ������ �� 
                    if(INITIAL_SOUND_CHARS[index] == searchChar){ 
                    	diffIndex++; 
                    }else{ 
                        break;
                    }
                // �ѱ��� �ƴ� ���(�ʼ��� �ƴҰ��) ��
                } else {
                    if(targetChar == searchChar){
                    	diffIndex++; 
                    }else{
                        break;
                    }
                } 
            } 
            // �˻����� ���̸�ŭ ��� ��ġ�ϸ� true 
            if(diffIndex == kewordLength){
                return true;
            }
        }
        // ������ ���������� ��ġ���� ������ false
        return false; 
	}
	
	/**
	 * �ʼ� data�� �������� ��ǰ �˻� �� ����
	 * 
	 * @param data
	 * 		�ʼ�data
	 * 
	 * @return
	 * 		���ĵ� �˻� ���
	 */
	public Map<Integer, String> searchData(String data) {
		try {
			Map<Integer, String> keyMap = new TreeMap<Integer, String>();
			// �� ��ǰ�� �Ǽ���ŭ for ���� ���� 
			int size = dataArray.length;
			for(int i = 0; i < size; i++){
				// ��Ī�Ǵ� ��ǰ�� �����ϸ� map�� ����
				if(isInitialSoundMatching(data, dataArray[i][1])) {
					int money = Integer.parseInt(StringUtils.delComma(dataArray[i][2]));
					int saleCnt = Integer.parseInt(StringUtils.delComma(dataArray[i][3]));
					// �ǸŸ����� ���� ���� �� ���� -> (�ǸŰ��� * �ǸŰ���) ���� ���� Ű�� ����
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
