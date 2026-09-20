package week2.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		for (String s : list1) {
			System.out.println(s);
		}
		
		list1.set(1, "키위"); //1번 위치의 원소 바꾸기
		
		//람다식
		list1.forEach(System.out::println);
		
		list1.set(2, "무화과");
		list1.forEach(s->System.out.println(s));
		
		
	}

}
