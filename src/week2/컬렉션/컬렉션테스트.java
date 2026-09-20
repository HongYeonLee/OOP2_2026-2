package week2.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 컬렉션테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//숫자 여러개를 리스트로 만들어 관리할 때
		ArrayList<Integer> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>(); //업캐스팅
		
		list1.add(100); //정수만
		list2.add("abcd"); //문자열만
		//list1.add(100.0); 실수는 안됨
		
		String [] str = {"aa", "bb", "cc", "dd"}; // 문자열 배열
		Integer [] ar = {1, 2, 3, 4 ,5}; //정수 배열
		
		ArrayList<String> list3 = (ArrayList<String>) Arrays.asList(str); //arrays가 문자열 배열을 list로 변환하고 그걸 다시 arrayList로 변환
		ArrayList<Integer> list4 = (ArrayList<Integer>) Arrays.asList(ar);
		
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		
		
		
;	}

}
