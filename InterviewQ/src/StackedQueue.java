import java.util.Stack;

public class StackedQueue<E> {

	public Stack<E> inbox = new Stack<E>();
	public Stack<E> outbox = new Stack<E>();
	public int size = 0;
 
	public void enqueue(E item){
		 inbox.push(item);
		 size++;
	 }
	 
	public E dequeue() {
	        if (outbox.isEmpty()) {
	            while (!inbox.isEmpty()) {
	               outbox.push(inbox.pop());
	            }
	        }
	        size--;
	        return outbox.pop();
	        
	 }
	
	public boolean isEmpty(){
		 if(inbox.isEmpty() && outbox.isEmpty()){
			 return true;
		 }
		 return false;
	 }
	 
	public static void main(String args[]){
		StackedQueue q = new StackedQueue();
		for(int i = 0; i < 10; i++){
			q.enqueue(i);
		}
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
		
	}
	
	
}
