class Taller5{

 public int a;

  public static int suma(int[] a){
     int resultado = 0;  
     for (int i = 0; i < a.length; i++) 
        resultado = resultado + a[i];
     return resultado; 
  }               
                  
  public static void main(String[] args){
      for (int n = 28000000; n < 280000000; n = n + 28000000){ 
        long tiempoInicial = System.currentTimeMillis();
        suma(new int[n]);
        long tiempoFinal = System.currentTimeMillis();
        System.out.println(tiempoFinal-tiempoInicial);      
      }
      
  }
  
}
