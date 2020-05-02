import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import javax.swing.JFrame;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Graphs {
	
	public static <V,E> List<V> bFS(Graph<V,E> g, V start){
		List<V> visitOrder = new ArrayList<V>();
		Set<V>  seen = new HashSet<V>();
		Queue<V> queue = new LinkedList<V>();
		
		seen.add(start);
		queue.offer(start);
		while(!queue.isEmpty()) {
			V current = queue.poll();
			for(V neighbor : g.getNeighbors(current)) {
				if(!seen.contains(neighbor)) {
					seen.add(neighbor);
					queue.offer(neighbor);
				}
			}
			visitOrder.add(current);
		}
		return visitOrder;	
	}
	
	public static <V,E> List<V> dFS(Graph<V,E> g, V start){
		List<V> visitOrder = new ArrayList<V>();
		Set<V> seen = new HashSet<V>();
		Stack<V> stack = new Stack<V>();
		
		seen.add(start);
		stack.push(start);
		while(!stack.isEmpty()){
			V current = stack.pop();
			for(V child : g.getPredecessors(current)){
				if(!seen.contains(child)){
					seen.add(child);
					stack.push(child);
				}
			}
			visitOrder.add(current);
		}
		
		return visitOrder;
		
	}

	
	

	public static <V, E> void greedy(Graph<V,E> g, V start){
		Set<V> done = new HashSet<V>();
		Set<V> toDo = new HashSet<V>();
		Map<V, Integer> distance = new HashMap<V, Integer>();
		Map<V, V> through = new HashMap<V, V>();
	
		for(V v : g.getVertices()){
			toDo.add(v);
		}
		
		done.add(start);
		toDo.remove(start);
		
		
		for(V v: toDo){
			through.put(v, start);
			if(g.isNeighbor(start, v)){
				Object e = g.findEdge(start, v);
				int i = ((Integer) e).intValue();
				distance.put(v, i);
			} else {
				distance.put(v, (int) Double.POSITIVE_INFINITY);
			} 
		}
		
		
		while(toDo.size() != 0){
			double minDist = Double.POSITIVE_INFINITY;
			V u = null;
			for(V v: toDo){
				if(distance.get(v) < minDist){
					minDist = distance.get(v);
					u = v;
				}
			}
			toDo.remove(u);
			for(V v: toDo){
				if(g.isNeighbor(u, v)){
					Object e = g.findEdge(u, v);
					int weight = ((Integer) e).intValue();
					if(distance.get(u) + weight < distance.get(v)){
						int newDist = distance.get(u) + weight;
						distance.put(v, newDist);
						through.put(v, u);
					}
				}
			}
		}
		
		
		
		for(V v : g.getVertices()){
			if(!v.equals(start)){
				System.out.println("To get to vertex " + v + " from " + start + " takes a distance of " + distance.get(v) + " through " +  through.get(v));

			}
		}
		
	}

	

	public static void main(String args[]){
		Graph<String, Integer>  g =  new SparseGraph<String,Integer>();
		g.addVertex("A");
		
		g.addEdge(1, "S", "A");
		g.addEdge(2, "S", "B");
		g.addEdge(3, "S", "C");
		g.addEdge(4, "S", "X");
		g.addEdge(5, "X", "Y");
		g.addEdge(6, "A", "D");
		g.addEdge(7, "D", "B");
		g.addEdge(8, "B", "E");
		g.addEdge(9, "E", "G");
		g.addEdge(10, "C", "F");
		

		
	    Layout<Integer, String> layout = new CircleLayout(g);
	    layout.setSize(new Dimension(600,600)); // sets the initial size of the space
	     // The BasicVisualizationServer<V,E> is parameterized by the edge types
	     BasicVisualizationServer<Integer,String> vv = 
	              new BasicVisualizationServer<Integer,String>(layout);
	     //vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size
	     vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		 vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
			
	     JFrame frame = new JFrame("Simple Graph View");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.getContentPane().add(vv); 
	     frame.pack();
	     frame.setVisible(true);   
		
		System.out.println(bFS(g, "S"));
		System.out.println(dFS(g, "S"));
		greedy(g, "S");
	       
	}
}
