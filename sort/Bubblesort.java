
public class Bubblesort {
    static void bubblesort(int[] A)
    {
        for (int i=0; i<=(A.length-2); i++)
        {
            for (int j=0; j<=(A.length-i-2); j++)
            {
                if (A[j] > A[j+1])
                {
                    int mellomlagring = A[j];
                    A[j] = A[j+1];
                    A[j+1] = mellomlagring;
                }
            }
        }
    }
}
