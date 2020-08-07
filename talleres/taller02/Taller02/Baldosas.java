
public class Baldosas
{
   public int p;
   public int q;

    public Baldosas( int p, int q)
    {
        this.p = p;
        this.q = q;
    }

    public static int mcd(int p, int q)
    {
      if (q == 0){
         return p;
      } else {
          return mcd (q, p % q);
      }
      
    }
    
    
}
