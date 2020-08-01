public class Main
{
    
    
    public  static  void  main ( String [] args )
    {
       int dia = 30;
       int mes = 7;
       int año = 2020;
       Fecha f1 = new Fecha (31, 7, 2020);
       Fecha f2 = new Fecha (dia, mes, año);
       System.out.println(f1);
       System.out.println(f2);
      if (f1.dia == f2.dia && f1.mes == f2.mes && f1.anio == f2.anio){
         System.out.println("0: fechas iguales");
      }else if ((f1.dia < f2.dia && f1.mes < f2.mes)||(f1.dia > f2.dia && f1.mes < f2.mes)){
         System.out.println("-1");
      }else if ((f1.dia > f2.dia && f1.mes > f2.mes)||(f1.dia < f2.dia && f1.mes > f2.mes)){
         System.out.println("1");
       }
    }

     
}
