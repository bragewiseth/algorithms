import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

class Topsort
{   
    public static void main(String[] args) throws IOException 
    {
        Graf G = Graf.byggGraf(false, false);
        System.out.println(G);
        // System.out.println(topologiskSortering(G));
        System.out.println(topsortDFS(G));
    }






    static ArrayList<Character> topologiskSortering(Graf G)
    {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> output = new ArrayList<>();
        for (char v : G.V)
        {
            int inndegree = 0;
            // if (inndegree of v == 0) { stack.push(v); }
            for (HashSet<Character> set : G.E.values())
            {
                if ( set.contains(v)) { inndegree++; }
            }
            if (inndegree ==  0) {stack.push(v);}
        }
        while (!stack.isEmpty())
        {
            char u = stack.pop();
            output.add(u);
            HashSet<Character> kopi = new HashSet<>();
            kopi.addAll(G.E.get(u));
            for (char v : kopi)  
            {
                G.E.get(u).remove(v);
                int inndegree = 0;
                // if (inndegree of v == 0) { stack.push(v); }
                for (HashSet<Character> set : G.E.values())
                {
                    if ( set.contains(v)) { inndegree++; }
                }
                if (inndegree ==  0) {stack.push(v);}
            }
        }
        if (output.size() < G.V.size()) { System.err.println("sykel"); }
        return output;
    }

    

    static void DFSvisitTop(Graf G, char u, HashSet<Character> visited, Stack<Character> stack)
    {
        visited.add(u);
        for (char v : G.E.get(u))
        {
            if (!visited.contains(v))
            {
                DFSvisitTop(G, v, visited, stack);
            }
        }
        stack.push(u);
    }



    static Stack<Character> topsortDFS(Graf G)
    {   
        Stack<Character> stack = new Stack<>();
        HashSet<Character> visited = new HashSet<>();
        for (char u : G.V)
        {
            if (!visited.contains(u)) { DFSvisitTop(G, u, visited, stack); }
        }
        return stack;
    }



    Graf reverseGraph(Graf G)
    {
        HashMap<Character,HashSet<Character>> Ei = new HashMap<>(); 
        for (char u : G.E.keySet())
        {
            for (char v: G.E.get(u))
            {
                Ei.putIfAbsent(v, new HashSet<Character>());
                Ei.get(v).add(u);
            }
        }
        return new Graf(G.V, Ei, null);
    }



    static void DFSvisit(Graf G, char u, HashSet<Character> visited, HashSet<Character> component)
    {
        visited.add(u);
        component.add(u);
        for (char v : G.E.get(u))
        {
            if (!visited.contains(v))
            {
                DFSvisit(G, v, visited, component);
            }
        }
    }


    
    HashSet<HashSet<Character>> stronglyConnectedComponents(Graf G)
    {
        Stack<Character> stack = topsortDFS(G);
        Graf Gi = reverseGraph(G);
        HashSet<Character> visited = new HashSet<>();
        HashSet<HashSet<Character>> components = new HashSet<>();
        while (!stack.isEmpty())
        {
            char u = stack.pop();
            if (!visited.contains(u))
            {
                HashSet<Character> component = new HashSet<>();
                DFSvisit(Gi, u, visited, component);
                components.add(component);
            }
        }
        return components;
    }
}

