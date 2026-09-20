package week2.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionPrinterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashSet 컬렉션 선언, 집합 구조, 중복x, 순서 없음
		Set<String> LanguagesSet = new HashSet<>(Arrays.asList("Java", "Java", "Java", "C", "C++", "Python")); //HashSet은 중복 저장x
		
		//Map 컬렉션 선언, 키-값 구조, 키 중복x, 순서 없음
		//Map.of(): 자동으로 매개변수들을 키 : 값 조합으로 인식해서 Map으로 만들어줌	
		Map<String, Integer> menuMap = Map.of("라면", 2000, "아아", 1000, "아이스크림", 1000); 
		
		//ArrayList 컬렉션 선언, 키 중복o, 순서 있음
		//Arrays.asList()는 매개변수로 받은 값을 리스트로 변환해줌
		ArrayList<Double> scores = new ArrayList<>(Arrays.asList(85.5, 90.0, 78.5, null));
		
		//사용자 정의 클래스 타입도 받는 컬렉션
		Set<동물> 동물set = new HashSet<>(Arrays.asList(new 동물("고양이"), new 동물("강아지"), new 동물("거북이")));
		
		PrettyPrinter printer = new CollectionPrinter_forEach();
		printer.show(LanguagesSet);
		printer.show(menuMap);
		printer.show(scores);
		printer.show(동물set);

		printer = new CollectionPrinter_Iterator();
		printer.show(LanguagesSet);
		printer.show(menuMap);
		printer.show(scores);
		printer.show(동물set);
 	}

}
