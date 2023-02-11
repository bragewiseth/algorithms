import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Biconnectivity 
{


    public static void main(String[] args) throws IOException 
    {
        Graf G = Graf.byggGraf(false,true);
        
    }

    boolean isBiconnectedNaive(Graf G)
    {
        for (char v : G.V)
        {
            Graf G_0 = new Graf(G.V, G.E, null);
            G_0.V.remove(v);
            for (char x : G.E.get(v)) { G.E.get(x).remove(v); }
            G.E.remove(v);
            HashSet<Character> visited = new HashSet<>();
            Character[] a = new Character[1];
            char u = G_0.V.toArray(a)[0];
            DFS_BFS.DFSvisit(G_0, u, visited);
            if (!visited.containsAll(G_0.V))
            {
                return false;
            }
        }
        return true;
    }


    
        
    HashSet<Character> separationVertices(Graf G)
    {
        HashMap<Character,Integer> depth = new HashMap<>();
        HashMap<Character,Integer> low = new HashMap<>();
        HashSet<Character> seps = new HashSet<>();

        char s = 'A';
        depth.put(s, 0);
        low.put(s, 0);
        for (char u : G.E.get(s))
        {
            if (!depth.containsKey(u)) { separationVerticesRec(G,u,1,depth,low,seps); }
        }
        HashSet<Character> uer = new HashSet<>();
        for (char u : G.E.get(s))
        {
            if (depth.get(u) == 1) { uer.add(u); }
        }
        if (uer.size() > 1) { seps.add(s); }    
        return seps;
    }


    void separationVerticesRec(Graf G, char u, int d, HashMap<Character,Integer> depth, HashMap<Character,Integer> low, HashSet<Character> seps )
    {
        depth.put(u, d);
        low.put(u,d);
        for (char v : G.E.get(u))
        {
            if (depth.containsKey(v)) 
            { 
                low.put(u, Math.min(low.get(u), depth.get(u))); 
                continue;
            }
            separationVerticesRec(G, u, d + 1, depth, low, seps);
            low.put(u, Math.min(low.get(u), depth.get(v)));
            if (d <= low.get(v))
            {
                seps.add(u);
            }
        }

    }


    boolean isBiconnected(Graf G)
    {
        return separationVertices(G).isEmpty();       
    }
}
