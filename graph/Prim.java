import java.util.HashMap;
import java.io.IOException;
import java.util.PriorityQueue;


class Prim
{


    public static void main(String[] args) throws IOException 
    {
        Graf G = Graf.byggGraf(true,false);
        System.out.println(prim(G));
    }

    
    static HashMap<Character,Character> prim(Graf G)
    {
        PriorityQueue<Dijkstra.Node> queue = new PriorityQueue<>();
        HashMap<Character,Character> parents = new HashMap<>();
        queue.add(new Dijkstra.Node('A','0', 0));
        while(!queue.isEmpty())
        {
            Dijkstra.Node u = queue.poll();
            if (parents.get(u.a) == null) { parents.put(u.a, u.b);}
            for (char v : G.E.get(u.a))
            {
                int c = G.W.get("" + u.a + v);
                queue.add(new Dijkstra.Node(v, u.a, c));    
            }
        }
        return parents;
    }
}