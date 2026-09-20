package week2.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> list1 = new ArrayList<>();
		
		//이미 만들어진 기능들 편리하게 호출하게 사용하기 => 컬렉션 사용 의의
		list1.add("사과");
		list1.add("수박");
		list1.add("복숭아");
		
		//for-each로 출력
		for (String s : list1) {
			System.out.println(s);
		}
		
		System.out.println("=================");
		
		list1.set(1, "키위"); //1번 위치의 원소를 키위로 바꾸기
		
		//forEach + 람다식으로 출력
		list1.forEach(System.out::println);
		
		System.out.println("=================");
		
		list1.set(2, "무화과"); //2번 위치의 원소를 무화과로 바꾸기
		
		//forEach + 람다식으로 출력
		list1.forEach(s->System.out.println(s));
		
		System.out.println("=================");
		
		list1.remove(2); //2번 위치의 원소 삭제
		
		//반복자 iterator로 출력
		Iterator <String> e = list1.listIterator();
		while(e.hasNext()) {
			System.out.println(e.next());
		}
		
		
	}

}
