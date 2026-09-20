package week2.Lab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class CollectionPrinter_forEach implements PrettyPrinter {
	
	//Set 출력하기
	@Override
	public <E> void show(Set<E> set) {
		// TODO Auto-generated method stub
		System.out.println("[Set 출력]: for-each 이용");
		for (E e : set) {
			System.out.print(e + " ");
		}
		
		//람다식으로 출력하기, 사용형식: 컬렉션.forEach(매개변수 -> 실행문)
		System.out.println("\n\n ***Set의 forEach()를 람다식으로 표현하기");	
		set.forEach(e -> System.out.println(e + " "));
		
		//메소드 참조 연산자 :: 이용, n->syso(n) 대체
		System.out.println("\n ***Set의 forEach()를 메소드참조로 표현하기");	
		set.forEach(System.out::println); 
		
		System.out.println("\n=========================================\n");
		
		
		
	}
	
	//Map 출력하기
	@Override
	public <K, V> void show(Map<K, V> map) {
		// TODO Auto-generated method stub
		System.out.println("[Map 출력]: for-each 이용");
		for (Map.Entry<K, V> entry : map.entrySet()) { //entrySet()은 Map의 모든 키-값으로 이루어진 객체를 set에 담아선 리턴
			System.out.println(entry.getKey() + " => " + entry.getValue());
			
		}
		
		//람다식으로 출력하기, Map.Entry<K, V> 할 필요없이 바로 매개변수 2개를 주면 알아서 map의 키-값으로 매핑해준다
		System.out.println("\n\n ***Map의 forEach()를 람다식으로 표현하기");	
		map.forEach((key, value) -> System.out.println(key + ":" + value));
		
		//메소드 참조로 출력하기. entrySet()으로 map의 키-값 객체들을 전부 가져오고 전달
		System.out.println("\n ***Map의 forEach()를 메소드참조로 표현하기");	
		map.entrySet().forEach(System.out::println);
		
		System.out.println("\n=========================================\n");
		
	}
	
	//ArrayList 출력하기
	@Override
	public <E> void show(ArrayList<E> list) {
		// TODO Auto-generated method stub
		System.out.println("[ArrayList 출력]: for-each 이용");
		for (E e : list) {
			System.out.print(e + " ");
		}
		
		//람다식으로 출력하기, 사용형식: 컬렉션.forEach(매개변수 -> 실행문)
		System.out.println("\n\n ***ArrayList의 forEach()를 람다식으로 표현하기");
		list.forEach(e -> System.out.print(e + " "));
		
		//메소드 참조 연산자 :: 이용, n->syso(n) 대체
		System.out.println("\n\n ***ArrayList의 forEach()를 메소드참조로 표현하기");
		list.forEach(System.out::println);
		
		System.out.println("\n=========================================\n");
		
		
	}

}
