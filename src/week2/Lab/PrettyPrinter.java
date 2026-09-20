package week2.Lab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

//사용자에게 받는 컬렉션의 종류에 따라 출력하는 메소드를 다르게 오버로딩
public interface PrettyPrinter { //제너릭 클래스 아님
	
	//제너릭 메소드
	public <E> void show(Set<E> set);
	public <K, V> void show(Map<K, V> map);
	public <E> void show(ArrayList<E> list);
}
