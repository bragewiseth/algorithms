
public class Selectionsort 
{
    static void selectionsort(int[] A)
    {
        for (int i=0; i < A.length; i++)
        {
            int k = i;
            for (int j=(i+1); j<A.length; j++)
            {
                if (A[j] < A[k]) { k=j; }
            }
            if (i != k)
            {
                int mellomlagring = A[i];
                A[i] = A[k];
                A[k] = mellomlagring;
            }
        }
    }
}
