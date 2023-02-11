
import java.util.ArrayList;


class Bucketsort 
{
    static class Par
    {
        String verdi;
        int nøkkel;
        Par(String v, int n)
        {
            verdi = v;
            nøkkel = n;
        }
    }
    static Par[] bucketsort(Par[] A) 
    {
        @SuppressWarnings("unchecked")
        ArrayList<Par>[] B = new ArrayList[10];
        for (int i=0; i < 10; i++) 
        { 
            B[i] = new ArrayList<>(); 
        }
        for (int i=0; i < A.length; i++)
        {
            B[A[i].nøkkel].add(A[i]);   
        } 
        int j = 0;
        for (int k=0; k < 10; k++)
        {
            for (Par x : B[k])
            {
                A[j] = x;
                j++;
            }
        }
        return A;
    }

    static String[] bucketsort(String[] A, int d)       // Heltall
    {
        @SuppressWarnings("unchecked")
        ArrayList<String>[] B = new ArrayList[10];
        for (int i=0; i < 10; i++) 
        { 
            B[i] = new ArrayList<>(); 
        }
        for (int i=0; i < A.length; i++)
        {
            B[Character.getNumericValue(A[i].charAt(d))].add(A[i]);   
        } 
        int j = 0;
        for (int k=0; k < 10; k++)
        {
            for (String x : B[k])
            {
                A[j] = x;
                j++;
            }
        }
        return A;
    }

    static int[] radixsort(int[] A)
    {
        int d = 3;  // Antall siffer i det største tallet
        String[] B = new String[A.length];
        int j = 0;
        for (int k : A)
        {
            String tall = Integer.toString(k);
            while (tall.length() < 4)
            {
                tall = "0" + tall;
            }
            B[j] = tall;
            j++;  
        }
        for (int i=d; i >= 0; i-- )
        {
            B = bucketsort(B,i);
        } 
        int teller = 0;
        for (String s : B)
        {
            A[teller] = Integer.parseInt(s);
            teller++;
        }
        return A;
    }

    public static void main(String[] args) {
        
        // Par[] A = new Par[6];
        // A[0] = new Par("a",0);
        // A[1] = new Par("a",0);
        // A[2] = new Par("b",1);
        // A[3] = new Par("d",4);
        // A[4] = new Par("h",8);
        // A[5] = new Par("a",0);
        // for (Par i : A)
        // {
        //     // System.out.println(i.verdi + " " + i.nøkkel);
        // }
        // A = bucketsort(A);
        // for (Par i : A)
        // {
        //     System.out.println(i.verdi);
        // }

        int[] A = new int[6];
        A[0] = 3055;
        A[1] = 309;
        A[2] = 165;
        A[3] = 4092;
        A[4] = 8;
        A[5] = 9012;
        A = radixsort(A);
        for (int i : A)
        {
            System.out.println(i);
        }
        
    }
}
