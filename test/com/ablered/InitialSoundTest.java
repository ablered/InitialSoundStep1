package com.ablered;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * �ʼ��˻� �׽�Ʈ Ŭ����
 * 
 * @author leehanchul
 *
 */
public class InitialSoundTest {
	
	// �˻� ��� �迭�� ���α׷��� �����ϰ� �ʱ�ȭ
	public static final String [][] PRODUCT_ITEM_ARRAY =  {
		{"24771911","KFC ġŲ�Ұ��� �޺�","2,600","27"},
		{"24756487","�Ҵ�/ī�ÿ� �мǽ������ð�","49,800","2"},
		{"24750911","[��] �������ұ���","21,600","4"},
		{"24718904","[����] ������ �������",	"29,000","1"},
		{"24703223","[���ε�����] LA�Ĵ�","30,000","29"},
		{"24702630","����ȫ����� ����ȫ����",	"65,300","1"},
		{"24692301","���� �з¹��","21,000","2"},
		{"24671273","����Ű BEST ����ȭ 22��","45,000","20"},
		{"24670532","������ ��ü���� F/W�Ż���","34,900","2"},
		{"24669991","�������� ���ťƮ ����/�÷�","17,900","9"},
		{"24669702","Ʈ�縱���� �����̾� ����Ŀ��","37,500","1"},
		{"24667948","����Ű ���� ���� ������","49,000","1"},
		{"24664912","�౸/��/�豸 ��������","14,000","6"},
		{"24661322","������ �����Ż� Ʈ�������","19,800","2"},
		{"24660422","�������ũ ��������","5,400","1"},
		{"24659696","[������ī]�������� 3�� 189000","189,000","1"},
		{"24659141","HK CLA���̾�Ʈ","29,700","1"},
		{"24654726","[û��] ���Ѻ�","350,000","15"},
		{"24654255","[���빮] �ִ��Ǻ�","15,000","4"},
		{"24651025","���� ǥ������ �����̽� 1kg","18,500","2"}
	};
	InitialSound initSound;
	
	/**
	 * �׽�Ʈ �� �ʱ�ȭ
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		initSound = new InitialSound(PRODUCT_ITEM_ARRAY);
	}
	
	/**
	 *  �ʼ��˻� �׽�Ʈ
	 */
	@Test
	public void testSearchData() {
		// �׽�Ʈ�� �ʼ� �迭
		String [] inputData = {
				"����", "������", "��������", "����", "������", "����", "KFC", "LA", 
				"������", "����", "����", "???", "!@#", 
				"asdjfkal;sdjf;laskdjfalksdjf", "1231241243123123123", "      "};
		int size = inputData.length;
		for(int i = 0; i < size; i++) {
			
			// �Է°� ���
			System.out.println(String.format("\n�Է°� : %s", inputData[i]));
			assertNotNull(String.format("\n�Է°� : %s", inputData[i]),  inputData[i]);
			
			Map<Integer, String> map = initSound.searchData(inputData[i]);
			
			// ��°��
			System.out.println(String.format("\n{�ݾ�=��ǰ��} : %s", map));
			assertNotNull(String.format("\n{�ݾ�=��ǰ��} : %s", map),  map);
		}
	}
	
	/**
	 *  �ʼ��˻� �׽�Ʈ
	 */
	@Test
	public void testSearchData2() {
		
	}
	
}