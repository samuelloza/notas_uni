class SparseTable{
    public static void main(String[] args){
        int[] m = {95, 2, 4, 7, 8, 9, 5, 6, 56, -1};

        int[][] st = new int[m.length*m.length][m.length*m.length];

        st_init(m, st);
        
        System.out.println("[1, 3] -> min = " + st_query(st, 1, 3));
        System.out.println("[3, 7] -> min = " + st_query(st, 2, 5));
        System.out.println("[1, 10] -> min = " + st_query(st, 1, 10));
        
    }

    static int st_query(int[][] st, int s, int e){
        int k = 31 - Integer.numberOfLeadingZeros(e-s);
        if(st[k][s] < st[k][e-(1<<k)]){
            return st[k][s];            
        }
        else{
            return st[k][e-(1<<k)];
        }
    }
    static void st_init(int m[], int[][] st){
        for(int i=0; i< m.length; ++i) {
            st[0][i] = m[i];
        }
        for (int k = 1; (1<<k) <= m.length ; ++k ) {
            for (int i = 0; i+(1<<k) <= m.length; ++i) {
                if ( st[k-1][i] < st[k-1][i+(1<<(k-1))] ) {
                    st[k][i] = st[k-1][i];
                }
                else{
                    st[k][i] = st[k-1][i+(1<<(k-1))];
                }
            }
        }
    }
}