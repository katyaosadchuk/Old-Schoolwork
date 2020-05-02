import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encrypting {
	
	private static ArrayList<Character> textSplit(String text){
		text = text.replaceAll("[\\W]", " ");
		text = text.replaceAll(" ", "");
		text = text.toLowerCase();

		ArrayList<Character> textSplit = new ArrayList<Character>();
		for(int i = 0; i < text.length(); i++){
			textSplit.add(text.charAt(i));
		}
		return textSplit;
	}
	
	
	private static ArrayList toNumbers(ArrayList<Character> list){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int n = 0;
		for(int j = 0; j < list.size(); j++){
			Character ch = list.get(j);
			n = (int)ch - (int)'a';
			numbers.add(n);	
		}
		return numbers;
		
	}
	
	private static ArrayList<Character> toLetters(ArrayList<Integer> list){
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int j = 0; j < list.size(); j++){
			int n = list.get(j);
			char x = ((char)(n+'A'));
			letters.add(x);
		}
		return letters;
	}
	
	
	private static ArrayList<Integer> ceasarEncrypt(ArrayList<Integer> numbers){
		System.out.println("Select an n: ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		for(int i = 0; i < numbers.size(); i++){
			int x = numbers.get(i);
			x = x + n;
			x = x % 26;
			numbers.set(i, x);
		}
		return numbers;
	}
	
	private static ArrayList<Integer> ceasarDecrypt(ArrayList<Integer> numbers){
		System.out.println("Enter the key n: ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		for(int i = 0; i < numbers.size(); i++){
			int x = numbers.get(i);
			x = x - n;
			x = x % 26;
			numbers.set(i, x);
		}
		System.out.println(numbers);
		return numbers;
	}
	
	
	private static ArrayList<Integer> vignereEncrypt(ArrayList<Integer> numbers){
		System.out.println("Enter a key: ");
		Scanner kb = new Scanner(System.in);
		String key = kb.nextLine();
		boolean isEncrypted = false;
		ArrayList<Integer> keyNums = toNumbers(textSplit(key));
		int sizeKey = keyNums.size();
		int sizeNumbers = numbers.size();
		
		for(int i = 0; i < sizeKey; i++){
			while(sizeKey != sizeNumbers){
				keyNums.add(sizeKey, keyNums.get(i));
				sizeKey++;
				i++;
			}
		}
	
		for(int i = 0; i < sizeNumbers; i++){
			int x = numbers.get(i);
			int y = keyNums.get(i);
			x = x + y;
			x = x % 26;
			numbers.set(i, x);
		}
				
		return numbers;
	}
	
	private static ArrayList<Integer> vignereDecrypt(ArrayList<Integer> numbers){
		System.out.println("Enter the key: ");
		Scanner kb = new Scanner(System.in);
		String key = kb.nextLine();
		boolean isEncrypted = false;
		ArrayList<Integer> keyNums = toNumbers(textSplit(key));
		int sizeKey = keyNums.size();
		int sizeNumbers = numbers.size();
		
		for(int i = 0; i < sizeKey; i++){
			while(sizeKey != sizeNumbers){
				keyNums.add(sizeKey, keyNums.get(i));
				sizeKey++;
				i++;
			}
		}
	
		for(int i = 0; i < sizeNumbers; i++){
			int x = numbers.get(i);
			int y = keyNums.get(i);
			x = x - y;
			x = x % 26;
			numbers.set(i, x);
		}
				
		return numbers;
	}
	
	public static void main(String args[]){
		Scanner kb = new Scanner(System.in);
		System.out.println("Encrypt or decrypt?");
		String eOrD = kb.nextLine();
		
		if(eOrD.equalsIgnoreCase("encrypt")){
			System.out.println("Enter the text you want to encrypt.");
			String text = kb.nextLine();
			ArrayList<Character> textSplit = textSplit(text);
			System.out.println("Which system? Ceasar or vignere?");
			String system = kb.nextLine();
			
			if(system.equalsIgnoreCase("ceasar")){
				System.out.println(toLetters(ceasarEncrypt(toNumbers(textSplit))));

			} else if(system.equalsIgnoreCase("vignere")){
				System.out.println(toLetters(vignereEncrypt(toNumbers(textSplit))));

			}
		} else if(eOrD.equalsIgnoreCase("decrypt")){
			System.out.println("Enter the text you want to decrypt.");
			String text = kb.nextLine();
			ArrayList<Character> textSplit = textSplit(text);
			System.out.println("Which system? Ceasar or vignere?");
			String system = kb.nextLine();
			
			if(system.equalsIgnoreCase("ceasar")){
				System.out.println(toLetters(ceasarDecrypt(toNumbers(textSplit))));

			} else if(system.equalsIgnoreCase("vignere")){
				System.out.println(toLetters(vignereDecrypt(toNumbers(textSplit))));

			}
		}
		
		
		
		
	}
}
