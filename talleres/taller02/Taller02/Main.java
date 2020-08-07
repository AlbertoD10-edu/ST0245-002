

public class Main
{
   
   
    public static void Main(String [] args)
    {
        int p = 30;
        int q = 15;
        Baldosas b1 = new Baldosas(p, q);
    
       if (p > q){
         System.out.println ("Datos correctos");
       } else if (p < q){
         System.out.println ("Datos incorrectos, el dato 1 es menor que el dato 2");
       }
    }

    
}
