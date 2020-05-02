import java.util.LinkedList;
import java.util.List;

public class Duplicates {

	public static LinkedList deDupes(LinkedList list){
		for(int i = 0; i < list.size(); i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i).equals(list.get(j))){
					list.remove(j);
				}
			}
		}
		return list;
		
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		for(int i = 0; i < 25; i ++){
			list.add(i);
		}
		for(int j = 0; j < 5; j++){
			list.add(j);
		}
		System.out.println(list);
		deDupes(list);
		System.out.println(list);
	}
}
