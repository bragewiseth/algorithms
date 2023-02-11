import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;





class Graf
{
    

    HashSet<Character> V;
    HashMap<Character, HashSet<Character>> E;
    HashMap<String,Integer> W;

    
    Graf(HashSet<Character> V, HashMap<Character,HashSet<Character>> E, HashMap<String,Integer> W)
    {
        this.V = V;
        this.E = E;
        this.W = W;
    }
    

    @Override
    public String toString() 
    {
        return E.toString();
    }
  
     
    static Graf byggGraf(boolean vekt, boolean urettet) throws IOException 
    {
        HashSet<Character> V = new HashSet<>();
        HashMap<Character, HashSet<Character>> E = new HashMap<>();
        HashMap<String,Integer> W = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        while (true)
        {
            char u = input[0].charAt(0);
            char v = input[1].charAt(0);

            // vekter

            if (vekt) 
            { 
                int w = Integer.parseInt(input[2]); 
                String kant = "" + u + v;
                W.put(kant, w);
                kant = "" + v + u;
                W.put(kant,w);
            }

            // Noder

            V.add(u);
            V.add(v);

            // Kanter

            E.putIfAbsent(u, new HashSet<Character>());
            E.putIfAbsent(v, new HashSet<Character>());
            E.get(u).add(v);
            if (urettet) { E.get(v).add(u); }
            
            try { input = br.readLine().strip().split(" "); }
            catch (NullPointerException e) { break; }
        }
        return new Graf(V,E,W);
    }



}