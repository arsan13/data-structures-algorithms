package backtracking.level1;
import java.util.ArrayList;
import java.util.List;

public class SortArray {

	private static void sort(List<Integer> list) {
		
		if(list.size() == 1)
			return;
		
		int val = list.remove(list.size() - 1);
		sort(list);
		insert(list, val);
	}
	
	private static void insert(List<Integer> list, int val) {

		if(list.size() == 0 || list.get(list.size() - 1) <= val) {
			list.add(val);
			return;
		}
		
		int temp = list.remove(list.size() - 1);
		insert(list, val);
		list.add(temp);
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(6);
		list.add(3);
		
		System.out.println(list);
		sort(list);
		System.out.println(list);
	}
}
