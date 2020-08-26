
public class Punto1_2
{
    public int p;
    public int q;
    
    public Punto1_2(int p, int q)
    {
        this.p = 2;
        this.q = q;
    }

    public static int mcd (int p, int q){
       if (q == 0){
           return p;
        }else {
           return mcd (q, p % q);
        }
    }
}
