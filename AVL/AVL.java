import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class  AVL {

    class Node 
    {
        int element;
        Node left;
        Node right;
        int høyde; 

        Node(int e) { element = e; }
    }

    
    int size;
    Node root;
    AVL() { size = 0; }

    Node insert(Node v, int x) 
    {
        if (v == null) 
        { 
            v = new Node(x); 
            this.size++;
        }
        else if (x < v.element) { v.left = insert(v.left, x); }
        else if (x > v.element) { v.right = insert(v.right, x); }
        v.høyde = 1 + Math.max(høyde(v.left), høyde(v.right));
        return balance(v);
    }    

    int høyde(Node v)
    {
        if (v == null) { return -1; }
        return v.høyde;
    }

    Node leftrotate(Node z)
    {
        Node y = z.right;
        Node t1 = y.left;
        
        y.left = z;
        z.right = t1;

        z.høyde = 1 + Math.max(høyde(z.left), høyde(z.right));
        y.høyde = 1 + Math.max(høyde(y.left), høyde(y.right));
    
        return y;
    }

    Node rightrotate(Node z)
    {
        Node y = z.left;
        Node t1 = y.right;
        
        y.right = z;
        z.left = t1;

        z.høyde = 1 + Math.max(høyde(z.left), høyde(z.right));
        y.høyde = 1 + Math.max(høyde(y.left), høyde(y.right));
    
        return y;
    }

    int balancefactor(Node v)
    {
        if (v == null) { return 0; }
        return (høyde(v.left) - høyde(v.right));
    }

    Node balance(Node v)
    {
        if (balancefactor(v) < -1)
        {
            if (balancefactor(v.right) > 0) { v.right = rightrotate(v.right); }
            return leftrotate(v);
        }
        if (balancefactor(v) > 1)
        {
            if (balancefactor(v.left) < 0) { v.left = leftrotate(v.left); }
            return rightrotate(v);
        }
        return v;
    }

    Boolean contains(Node v, int x)
    {
        if (v == null) { return false; }
        if (x == v.element) { return true; }
        if (x < v.element) { return contains(v.left, x); }
        if (x > v.element) { return contains(v.right, x); }
        return null;
    }

    Node remove(Node v, int x) 
    {
        if (v == null) { return null; }
        if (x < v.element) 
        { 
            v.left = remove(v.left, x); 
            return v;
        }
        if (x > v.element) 
        {
            v.right = remove(v.right, x);
            return v;
        }
        if (v.left == null) 
        {
            this.size--;
            return v.right; 
        }
        if (v.right == null) 
        { 
            this.size--;
            return v.left; 
        }
        Node u = finnMinste(v.right);
        v.element = u.element;
        v.right = remove(v.right, u.element);
        v.høyde = 1 + Math.max(høyde(v.left), høyde(v.right));
        return balance(v);
    }
   
    int size() 
    {
         return this.size; 
    }

    Node finnMinste(Node v)
    {
        if (v.left == null) { return v; }
        else { return finnMinste(v.left); }
    }

    public static void main(String[] args) throws IOException
    {
        AVL tre = new AVL();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) 
        {
            String[] data = br.readLine().split(" ");
            if (data[0].equalsIgnoreCase("insert")) { tre.root = tre.insert(tre.root, Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("contains")) { System.out.println(tre.contains(tre.root, Integer.parseInt(data[1]))); }
            if (data[0].equalsIgnoreCase("remove")) { tre.root = tre.remove(tre.root, Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("size")) { System.out.println(tre.size()); }
        }
    }
}