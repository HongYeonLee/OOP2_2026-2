package week2.Lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionPrinter_Iterator implements PrettyPrinter {
	
	//Set 출력하기
	@Override
	public <E> void show(Set<E> set) {
		// TODO Auto-generated method stub
		System.out.println("[Set 출력]: Iterator 이용");
		Iterator<E> e = set.iterator(); //Iterator도 <E> 타입인거 잊지 말기. set이 자신의 Iterator를 가져와서 e에 저장
		while(e.hasNext()) {
			System.out.print(e.next() + " ");
		}
		
		System.out.println("\n=========================================\n");
		
	}
	
	//Map 출력하기
	@Override
	public <K, V> void show(Map<K, V> map) {
		// TODO Auto-generated method stub
		System.out.println("[Map 출력]: Iterator 이용");
		//entrySet(): Map의 모든 키-값으로 이루어진 객체를 set에 담아선 리턴, 따라서 Iterator<K, V>가 아니라 Map의 객체(entry)로 받아야함
		Iterator<Map.Entry<K, V>> e = map.entrySet().iterator(); 
		
		while(e.hasNext()) {
			Map.Entry<K, V> entry = e.next(); //map에서 하나의 객체(키-값)을 꺼내서 저장
			System.out.println(entry.getKey() + " => " + entry.getValue()); //Map.Entry는 키와 값에 각각 접근 가능
		}
		System.out.println("\n=========================================\n");
	}
	
	//ArrayList 출력하기
	@Override
	public <E> void show(ArrayList<E> list) {
		// TODO Auto-generated method stub
		System.out.println("[ArrayList 출력]: Iterator 이용");
		Iterator<E> e = list.iterator();
		while(e.hasNext()) {
			System.out.print(e.next() + " ");
		}
		System.out.println("\n=========================================\n");
	}

}
