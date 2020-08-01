
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class  Main_Punto {

    public  static  void  main ( String [] args ) {

        // 10

        Punto p =  new Punto ( - 1 , 1 );
        // 0,0
        System.out.println( " Punto: {% f,% f} \n " + p .x()+p.y ());
        // 1 * sqrt (2)
        System.out.println ( " Radio Polar: "+p.radioPolar ());
        // -45
        System.out.println ( " Angulo Polar: "  +  Math . toDegrees (p . anguloPolar ()));
        // 2
        System.out.println ( " Angulo Polar: "  + p . distanciaEuclidiana ( new  Punto ( 1 , 1 )));

    }
}

