public class SegmentTree{
    
    static final int NEUT = 2147483647;
    
    public static void main(String[] args){
        int[] m = {4,0,7,1,3,5,8,8,3,2,2,1};
        int[] rmq = new int[m.length*4];
        rmq_init(1, 0, m.length, rmq, m);
        System.out.println(rmq_query(1, 0, m.length, rmq, 2, 5));
    }
    
    public static int LEFT(int n){
        return 2*n;
    }
    
    public static int RIGHT(int n){
        return 2*n+1;
    }
    
    public static int oper(int a, int b){
        return Math.min(a, b);
    }
    
    public static void rmq_init(int n, int s, int e, int[] rmq, int[] m){
        if(s+1 == e) {
            rmq[n] = m[s];
        }
        else{
            rmq_init(LEFT(n), s, (s+e)/2, rmq, m);
            rmq_init(RIGHT(n), (s+e)/2, e, rmq, m);
            rmq[n] = oper(rmq[LEFT(n)], rmq[RIGHT(n)]);
        }
    }
    public static void rmq_update(int n, int s, int e, int[] rmq, int[] m, int p, int v){
        if(s+1 == e){
            rmq[n] = m[s] = v;
        }
        else{
            if(p < (s+e)/2){
                rmq_update(LEFT(n), s, (s+2)/2, rmq, m, p, v);
            }
            else{
                rmq_update(RIGHT(n), (s+e)/2, e, rmq, m , p, v);
            }
            rmq[n] = oper(rmq[LEFT(n)], rmq[RIGHT(n)]);
        }
    }
    public static int rmq_query(int n, int s, int e, int[] rmq, int a, int b){
        if(a >= e || b <= s){
            return NEUT;
        }
        else if (s >= a && e <= b){
            return rmq[n];
        }
        else{
            int l = rmq_query(LEFT(n), s, (s+e)/2, rmq, a, b);
            int r = rmq_query(RIGHT(n), (s+e)/2, e, rmq, a, b);
            return oper(l, r);
        }
    }
}