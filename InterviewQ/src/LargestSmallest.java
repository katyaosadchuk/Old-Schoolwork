import java.util.TreeMap;
import java.util.TreeSet;

public class LargestSmallest {

	public static <E> E largestSmallest(Node<E> root){
		Node<E> smaller = root.left;
		while(smaller.right != null){
			smaller = smaller.right;
		}
		E largest = smaller.item;
		return largest;
	}
	
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		tree.add(16);
		tree.add(1);
		tree.add(7);
		tree.add(20);
		tree.add(23);
		tree.add(18);
		tree.add(5);
		tree.add(11);
		tree.add(0);
		tree.add(100);
		System.out.println(largestSmallest(tree.root));
		
		
		BinaryTree tree2 = new BinaryTree();
		tree2.add("g");
		tree2.add("a");
		tree2.add("b");
		tree2.add("k");
		tree2.add("z");
		tree2.add("w");
		tree2.add("t");
		tree2.add("f");		
		tree2.add("h");
		System.out.println(largestSmallest(tree2.root));
		
		
	}
}
