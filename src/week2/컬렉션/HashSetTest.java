package week2.컬렉션;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {

	//출력용 generic 메소드, 클래스 생성없이 바로 부르려고 static 
	public static <E> void show(Set<E> s) {
		
		//for-each
		for (E e: s) {
			System.out.print(e + " ");
		}
		System.out.println("\n--------------------------");
		
		//iterator
		Iterator<E> it = s.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ",");
		}
		System.out.println("\n--------------------------");
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//HashSet 만들고 add로 하나씩 넣기보다는 asList로 한번에 넣기
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
		Set<Integer> set3 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9));
		Set<Integer> set4 = new HashSet<>(Arrays.asList(8, 9, 10, 11, 12));
		Set<Integer> set5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
	
		//순서 상관없이 출력
		set1.addAll(set2); // 1 ~ 7
		set2.retainAll(set3); //교집합 5, 6, 7
		set3.removeAll(set4); //set3 - set4 5, 6, 7
		set4.removeAll(set3); //set4 - set3, 위에서 set3의 내용이 달라졌음 주의 8 ~ 12
		set5.containsAll(set4); //부분집합 set5
		
		show(set1);
		show(set2);
		show(set3);
		show(set4);
		show(set5);
		
		System.out.println("\n--------------------------");
		
		//람다식으로 출력하기
		set1.forEach(s -> System.out.print(s + " "));
		
		System.out.println("\n--------------------------");
		
		//자동으로 정렬함 
		Set <Integer> treeSet = new TreeSet<>(Arrays.asList(1, 10, 5));
		
		for (Integer t : treeSet) {
			System.out.println(t);
		}
	}

}
