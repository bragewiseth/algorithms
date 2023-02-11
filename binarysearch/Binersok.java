class Binersok {

    static int binersok(int[] A, int x) {
        int lav = 0; int i = 0; int hoy = A.length;

        while( lav <= hoy ) {
            i = ( lav + hoy ) / 2;
            if( A[i] < x ) { lav = i+1; }
            else if ( A[i] > x ) { hoy = i-1; }
            else if ( A[i] == x ) { return i; }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,12,13,14,15,16};
        System.out.println(binersok(A,5)); 
        System.out.println(System.currentTimeMillis()/1000000000);       
    }
}