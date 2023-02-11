
public class Heapsort {
    static void bubbledown(int[] A , int i, int n)
    {
        int largest = i;
        int left = (2*i + 1);
        int right = (2*i + 2);
        if (left < n && A[largest] < A[left])
        {
            int mellomlagring = largest;
            largest = left; left = mellomlagring;
        }
        if (right < n && A[largest] < A[right])
        {
            int mellomlagring = largest;
            largest = right; right = mellomlagring;
        }
        if (i != largest)
        {
            int mellomlagring = A[i];
            A[i] = A[largest]; A[largest] = mellomlagring;
            bubbledown(A, largest, n);    
        }        
    }

    static void buildMaxHeap(int[] A, int n)
    {
        for (int i=(n/2); i >= 0; i--)
        {
            bubbledown(A, i, n);
        }
    }

    static void heapsort(int[] A)
    {
        buildMaxHeap(A, A.length);
        for (int i=(A.length-1); i>0; i--)
        {
            int mellomlagring = A[0];
            A[0] = A[i]; A[i] = mellomlagring;
            bubbledown(A, 0, i);
        }
    }
}