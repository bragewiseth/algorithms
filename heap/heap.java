import java.util.ArrayList;

class Heap {
    ArrayList<Integer> A = new ArrayList<Integer>();

    void insert(int x)
    {
        A.add(A.size(), x);
        int i = A.size()-1;
        while (i > 0 & A.get(i) < A.get((i-1)/2))
        {
            int A_i = A.get(i); A.remove(i);
            int A_i_half = A.get((i-1)/2); A.remove((i-1)/2);
            A.add(i-1,A_i_half); 
            A.add((i-1)/2, A_i);
            i = (i-1)/2;
        }
    }

    int remove()
    {
        int x = A.get(0);
        A.set(0, A.get(A.size()-1));
        int i = 0;
        int j;
        while ((2*i + 2) < (A.size()-1))
        {
            if ( A.get(2*i + 1) <= A.get(2*i + 2)) { j = 2*i + 1; }
            else { j = 2*i + 2; }
            if ( A.get(j) <= A.get(i)) 
            {
                int mellomlagring = A.get(i);
                A.set(i, A.get(j));
                A.set(j, mellomlagring);
                i = j;
                continue;
            }
            break;
        }
        if ((2*i + 1) < (A.size() - 1) & A.get(2*i + 1) <= A.get(i))
        {
            int mellomlagring = A.get(i);
            A.set(i, A.get(2*i + 1));
            A.set(2*i + 1, mellomlagring);
        }
        return x;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(6);
        heap.insert(1);
        heap.insert(5);
        heap.insert(0);
        heap.insert(4);
        heap.insert(10);
        heap.insert(3);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(12);
        // System.out.println(heap.A.size());
        for (int g : heap.A)
        {
            System.out.println(g);
        }
    }
}