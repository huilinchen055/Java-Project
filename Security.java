import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Security {
    public static List<Integer> getNum() {
        List<Integer> allNum = new ArrayList<>();
        File file = new File("p079_keylog.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                Integer Num = sc.nextInt();
                allNum.add(Num);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return allNum;
    }

    public static DirectedSparseGraph<Integer, String> setGraph(List<Integer> list){
        DirectedSparseGraph<Integer,String> g = new DirectedSparseGraph<>();
        for (Integer Num:list) {
            int first= Num/100;
            int second = (Num-first*100)/10;
            int third = Num % 10;
            String First = Integer.toString(first);
            String Second = Integer.toString(second);
            String Third = Integer.toString(third);
            ((DirectedSparseGraph<Integer, String>) g).addEdge(First+Second, first, second);
            ((DirectedSparseGraph<Integer, String>) g).addEdge(Second+Third, second, third);
        }
        return g;
    }

    public static int eliminate(DirectedSparseGraph<Integer, String> g){
        for (int vertex:g.getVertices()) {
            if(g.inDegree(vertex)==0){
                g.removeVertex(vertex);
                return vertex;
            }
        }
        return 99;
    }

    public static List<Integer> Kahns(DirectedSparseGraph<Integer, String> g) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> result= new ArrayList<>();
        int size = g.getVertices().size();
        while(q.size()!=size) {
            q.add(eliminate (g));
            }
        while(!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = getNum();
        DirectedSparseGraph<Integer, String> g= setGraph(list);
        System.out.println(g);
        System.out.println(Kahns(g));
    }
}
