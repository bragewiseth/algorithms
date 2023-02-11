import java.util.HashMap;
import java.io.IOException;
import java.util.PriorityQueue;


class Dijkstra
{


    public static void main(String[] args) throws IOException 
    {
        Graf G = Graf.byggGraf(true,false);
        // System.out.println(G);
        System.out.println(dijkstra(G, 'A'));
    }



    static class Node implements Comparable<Node>
    {
        char a;
        char b;
        int vekt;

        public int compareTo(Node v) 
        {
            if (this.vekt > v.vekt) { return 1; }
            if (this.vekt < v.vekt) { return -1; }
            if (this.vekt == v.vekt) { return 0; }
            return 0;
        }

        Node(char a, char b, int vekt)
        {
            this.a = a;
            this.b = b;
            this.vekt = vekt;
        }
         

    }
    



    static HashMap<Character,Integer> dijkstra(Graf G, char s)
    {
        HashMap<Character,Integer> dist = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, '0', 0));
        dist.put(s,0);
        while (!queue.isEmpty())
        {
            Node u = queue.poll();
            for (char v : G.E.get(u.a))
            {
                int c = dist.get(u.a) + G.W.get("" + u.a + v);
                if (dist.get(v) == null) {dist.put(v,Integer.MAX_VALUE);}
                if (c < dist.get(v))
                {
                    dist.put(v,c);
                    queue.add(new Node(v,'0',c));
                }
            }
        }
        return dist;
    }


    
}