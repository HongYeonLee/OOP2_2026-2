package week2.컬렉션;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> hashMap = new HashMap<>();
		
		hashMap.put("menu1", "아이스아메리카노");
		hashMap.put("menu2", "아이스티노");
		hashMap.put("menu3", "딸기요거트스무디");
		hashMap.put("menu4", "카페라떼");
		hashMap.put("menu5", "물");
		
		//정렬안된 메뉴가 나옴
		for (String key : hashMap.keySet()) {
			System.out.println(key + " => " + hashMap.get(key));
		}
		
		System.out.println("------------------------------------");
		
		//람다식으로 출력하기
		hashMap.forEach((k, v) -> System.out.println(k + ":" + v));
		
		System.out.println("------------------------------------");
		
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		
		linkedHashMap.put("menu1", "아이스아메리카노");
		linkedHashMap.put("menu2", "아이스티노");
		linkedHashMap.put("menu3", "딸기요거트스무디");
		linkedHashMap.put("menu4", "카페라떼");
		linkedHashMap.put("menu5", "물");
		
		 //정렬안된 메뉴가 나옴
		for (String key : linkedHashMap.keySet()) {
			System.out.println(key + " => " + linkedHashMap.get(key));
		}
		
		System.out.println("------------------------------------");
		
		
		
	}

}
