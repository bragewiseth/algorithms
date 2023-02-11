import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    static class Node implements Comparable<Node>
    {
        String symbol;
        int frekvens;
        Node høyre, venstre;
        Node(String s, int f, Node v, Node h)
        {
            symbol = s;
            frekvens = f;
            høyre = h;
            venstre = v;
        }

        @Override
        public int compareTo(Node v) 
        {
            if (this.frekvens < v.frekvens) { return -1; }
            if (this.frekvens > v.frekvens) { return 1; }
            return 0;
        }
    }

    static Node huffman(HashMap<String, Integer> C)
    {
        PriorityQueue<Node> Q = new PriorityQueue<>();
        for (Map.Entry<String, Integer> set : C.entrySet()) 
        {
            Q.offer(new Node(set.getKey(), set.getValue() , null, null));
        }
        while (Q.size() > 1)
        {
            Node v1 = Q.poll();
            Node v2 = Q.poll();
            int f = v1.frekvens + v2.frekvens;
            Q.offer(new Node(null, f, v1, v2));
        }
        return Q.poll();
    }

    static void printtre(Node v)
        {
            if (v != null)
            {
                System.out.println("          "+v.frekvens + " " + v.symbol);
                printtre(v.venstre);
                printtre(v.høyre);
            }
        }

    public static void main(String[] args) 
    {
        HashMap<String, Integer> C = new HashMap<>();
        C.put("a", 8);    
        C.put("b", 4);    
        C.put("c", 1);    
        C.put("d", 9);    
        C.put("e", 10);    
        C.put("f", 2);    
        C.put("g", 4);
        Node v = huffman(C);
        printtre(v);    
    }
}
