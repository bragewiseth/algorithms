import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class DFS_BFS
{

    public static void main(String[] args) throws IOException 
    {
        Graf G = Graf.byggGraf(false,true);
        // System.out.println(G);
        // System.out.println(G.E.values());
        System.out.println(BFSvisit_full(G));
        System.out.println(DFSvisit_full(G));
        System.out.println(DFSvisit_full_it(G));
        System.out.println(shortestPathBFS_from(G,'A'));
        System.out.println(shortestPathBetweenBFS(G, 'A', 'J'));
    }

    //
    // DFS
    //

    static void DFSvisit(Graf G, char u, HashSet<Character> visited)
    {
        visited.add(u);
        for (char v : G.E.get(u))
        {
            if (!visited.contains(v))
            {
                DFSvisit(G, v, visited);
            }
        }
    }

    static HashSet<Character> DFSvisit_full(Graf G)
    {
        HashSet<Character> visited = new HashSet<>();
        for (char v : G.V)
        {
            if (!visited.contains(v))
            {
                DFSvisit(G, v, visited);
            }
        }
        return visited; 
    }

    static void DFSvisit_it(Graf G, char s, ArrayList<Character> visited)
    {   
        Stack<Character> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty())        
        {
            char u = stack.pop();
            if (!visited.contains(u))
            {
                visited.add(u);
                for (char v : G.E.get(u))
                {
                    stack.push(v);
                } 
            }
        } 
    }
                                    
    static ArrayList<Character> DFSvisit_full_it(Graf G)
    {
        ArrayList<Character> visited = new ArrayList<>();
        for (char v : G.V)
        {
            if (!visited.contains(v))
            {
                DFSvisit_it(G, v, visited);
            }
        } 
        return visited;
    }

    //
    // BFS
    //

    static void BFSvisit(Graf G, char s, ArrayList<Character> visited)
    {
        ArrayList<Character> queue = new ArrayList<>();
        queue.add(s);
        while (!queue.isEmpty())
        {
            char u = queue.remove(0);
            if (!visited.contains(u))
            {  
                visited.add(u);
                for (char v : G.E.get(u))
                {
                    queue.add(v);
                }
            }
        }
            
    }

    static ArrayList<Character> BFSvisit_full(Graf G)
    {
        ArrayList<Character> visited = new ArrayList<>();
        for (char v : G.V)
        {
            if (!visited.contains(v))
            {
                BFSvisit(G, v, visited);
            }
        } 
        return visited;
    }



    //
    // SHORTEST PATH
    //



    static HashMap<Character,Character> shortestPathBFS_from(Graf G, char s)
    {
        ArrayList<Character> queue = new ArrayList<>();
        HashMap<Character, Character> parents = new HashMap<>();
        parents.put(s, null);
        queue.add(s);
        while (!queue.isEmpty())
        {
            char v = queue.remove(0);
            for (char u : G.E.get(v))
            {
                if (parents.get(u) == null & u != s)
                {  
                    parents.put(u, v);
                    queue.add(u);
                }
            }
        }
        return parents;
    }

    static ArrayList<Character> shortestPathBetweenBFS(Graf G, char s, char t)
    {
        HashMap<Character, Character> parents = shortestPathBFS_from(G, s);
        ArrayList<Character> path = new ArrayList<>();
        char v = t;
        if (!parents.containsKey(t)) {return path; }
        while (v != s)
        {   
            path.add(v);
            v = parents.get(v);
        }
        path.add(s);
        return path;
    }

}