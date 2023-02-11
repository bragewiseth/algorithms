
public class Insertionsort 
{

    static void inserttionsort(int[] A)
    {
        for (int i=1; i<A.length; i++)
        {
            int j = i;
            while (j > 0 && A[j-1] > A[j])
            {
                int mellomlagring = A[j-1];
                A[j-1] = A[j];
                A[j] = mellomlagring;
                j--;
            }
        }
    }
}
