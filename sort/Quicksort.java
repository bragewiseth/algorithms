
public class Quicksort {
    static int partition(int[] A, int low, int high)
    {
        int p = choosePivot(A, low, high);
        int mellomlagring = A[p];
        A[p] = A[high]; A[high] = mellomlagring;
        int pivot = A[high];
        int left = low;
        int right = (high-1);
        while (left <= right)
        {
            while (left <= right & A[left] <= pivot) { left++; }
            while (right >= left && A[right] >= pivot) { right--; }
            if (left < right)
            {
                int mellomlagring_1 = A[left];
                A[left] = A[right]; A[right] = mellomlagring_1;
            }
        }
        int mellomlagring_2 = A[left];
        A[left] = A[high]; A[high] = mellomlagring_2;
        System.out.println(pivot + "pivotelemetn");
        for (int a=low; a <= high; a++)
        {
            System.out.println(A[a]);
        }
        System.out.println("##########");
        return left;
    }

    static int[] quicksort(int[] A, int low, int high)
    {
        if (low >= high) { return A; }
        int p = partition(A, low, high);
        quicksort(A, low, (p-1));
        quicksort(A, (p+1), high);
        return A;
    }

    static int choosePivot(int[] A, int low, int high)
    {
        if (A[low] < A[high] & A[low] > A[((high-low)/2)+low]) { return low; }
        if (A[high] < A[low] & A[high] < A[((high-low)/2)+low]) { return high; }
        else return ((high-low)/2)+low;
    }
}
