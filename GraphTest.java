
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;


import java.util.*;

public class GraphTest {
    public static StringBuilder discovery = new StringBuilder();
    public static StringBuilder finish = new StringBuilder();


    public static <V, E> String bfs(Graph<V,E> g){
        StringBuilder path = new StringBuilder();
        V start=(V)g.getVertices().toArray()[0];
        Queue<V> Queue =  new LinkedList<V>();
        Set<V> visited = new HashSet<>();
        Set<V> identified = new HashSet<>();
        ((LinkedList<V>) Queue).add(start);
        identified.add(start);
        while(!Queue.isEmpty()){
            V vertex = Queue.remove();
            for (V vertices: g.getNeighbors(vertex)) {
                if (!identified.contains(vertices)&& !visited.contains(vertices)){
                    identified.add(vertices);
                    Queue.add(vertices);
                }
            }
            path.append(vertex.toString() + " ");
            visited.add(vertex);
        }
        return path.toString();
    }



    public static <V, E> void dfs(Graph<V,E> g, V current, Map<V,V> parent, Set<V> visited,Set<V> finished){
        visited.add(current);
        discovery.append (current.toString()+" ");
        for (V vertices: g.getNeighbors(current)) {
            if (!visited.contains(vertices)) {
                parent.put(vertices, current);
                dfs(g, vertices, parent, visited, finished);
            }
        }
        finished.add(current);
        finish.append(current.toString() + " ");
    }

    public static void main (String[] args){
        Graph<Integer,String> g = new SparseGraph<>();
        g.addEdge("01",0, 1);
        g.addEdge("02",0, 3);
        g.addEdge("12",2, 3);
        g.addEdge("20",2, 1);
        g.addEdge("23",2, 9);
        g.addEdge("28",2, 8);
        g.addEdge("24",1, 4);
        g.addEdge("27",1, 7);
        g.addEdge("16",1, 6);
        g.addEdge("46",4, 6);
        g.addEdge("47",4, 7);
        g.addEdge("67",6, 7);
        g.addEdge("45",4, 5);
        System.out.println(bfs(g));
        dfs(g,(Integer)g.getVertices().toArray()[0], new HashMap<>(), new HashSet<>(), new HashSet<>());
        System.out.println(discovery);
    }

}
