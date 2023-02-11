import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] A = new int[input];
        int i = 0;
        input = Integer.parseInt(br.readLine());
        while (input != -1)
        {
            A[i] = input;
            i++;
            input = Integer.parseInt(br.readLine());
        }
        Heapsort.heapsort(A);
        for (int k : A)
        {
            System.out.println(k);
        }
    }    
}
