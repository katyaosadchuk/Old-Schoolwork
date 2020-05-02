import java.util.ArrayList;

public class Permutation {

	public static boolean permutation(String word1, String word2){
		word1 = word1.toLowerCase();
		word1 = word1.replaceAll(" ", "");
		word2 = word2.toLowerCase();
		word2 = word2.replaceAll(" ", "");
		ArrayList<Boolean> truths = new ArrayList<Boolean>();
		
		if(word1.length() != word2.length()){
			return false;
		} else {
			ArrayList<Character> l1 = new ArrayList<Character>();
			ArrayList<Character> l2 = new ArrayList<Character>();
			for(int i = 0; i < word1.length(); i++){
				l1.add(word1.charAt(i));
				l2.add(word2.charAt(i));
			}
			for(Character c : l1){
				if(l2.contains(c)){
					truths.add(true);
				}
				else{
					truths.add(false);
				}
			
			}
			
			if(!truths.contains(false)){
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	public static void main(String args[]){
		String s = "abcde zyx";
		String t = "acd e y x ";
		System.out.println(permutation(s, t));
	}
}
