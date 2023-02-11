
import java.util.Arrays;

public class Mergesort {
    static int[] merge(int[] A1, int[] A2, int[] A)
    {
        int i = 0; int j = 0;
        while (i < A1.length & j < A2.length)
        {
            if (A1[i] < A2[j])
            {
                A[i+j] = A1[i];
                i++;
            }
            else
            {
                A[i+j] = A2[j];
                j++;
            }
        }
        while (i < A1.length)
        {
            A[i+j] = A1[i];
            i++;
        }
        while (j < A2.length)
        {
            A[i+j] = A2[j];
            j++;
        }
        return A;
    }

    static int[] mergesort(int[] A)
    {
        if (A.length <= 1)
        {
            return A;
        }
        int i = (A.length/2);
        for (int a : A) { System.out.println(a);}
        int[] A1 = mergesort(Arrays.copyOfRange(A, 0, i));
        int[] A2 = mergesort(Arrays.copyOfRange(A, i, A.length));
        return merge(A1, A2, A);
    }
}
