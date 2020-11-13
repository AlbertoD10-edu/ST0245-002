
/**
 * La clase principal tiene como objetivo realizar pruebas a los métodos de las clases Digraph y Recorrido.
 * (Main)
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo) 
 * @version (13/11/2020)
 */
public class Principal
{
    public static void main(String []args){

        Digraph lista=new Digraph(10);
        //(pos origen, pos destino)
        lista.addArc(0,1);
        lista.addArc(0,2);
        lista.addArc(3,4);
        lista.addArc(1,5);
        lista.addArc(1,6);
        lista.addArc(2,7);
        lista.addArc(0,8);
        lista.addArc(3,9);

        System.out.println("***   Matriz de adyacencia  ***");
        System.out.println("*Pos origen: "+0+  "  Pos destino: "+1+  "  Peso: "+lista.getWeight(0,1));
        System.out.println("Pos origen: "+0+  "  Pos destino: "+2+  "  Peso: "+lista.getWeight(0,2));
        System.out.println("Pos origen: "+3+  "  Pos destino: "+4+  "  Peso: "+lista.getWeight(3,4));

        System.out.println("Sucesores de 0: "+lista.getSuccessors(0));

        System.out.println("*Pos origen: "+1+  "  Pos destino: "+0+  "  Peso: "+lista.getWeight(1,0));
        System.out.println("Pos origen: "+2+  "  Pos destino: "+0+  "  Peso: "+lista.getWeight(2,0));
        System.out.println("Pos origen: "+4+  "  Pos destino: "+3+  "  Peso: "+lista.getWeight(4,3));

        System.out.println("Sucesores de 3: "+lista.getSuccessors(3));

        System.out.println("Recorrido  BFS");
        System.out.println("Hay camino de 1 a 2: "+Recorrido.recorridoBFS(lista, 1, 2));
        System.out.println("Hay camino de 2 a 4: "+Recorrido.recorridoBFS(lista, 2, 4));
        System.out.println("Hay camino de 8 a 9: "+Recorrido.recorridoBFS(lista, 8, 9));
        System.out.println("Hay camino de 5 a 7: "+Recorrido.recorridoBFS(lista, 5, 7));
        System.out.println("Recorrido  DFS");
        System.out.println("Hay camino de 1 a 2: "+Recorrido.recorridoDFS(lista, 1, 2));
        System.out.println("Hay camino de 2 a 4: "+Recorrido.recorridoDFS(lista, 2, 4));
        System.out.println("Hay camino de 8 a 9: "+Recorrido.recorridoDFS(lista, 8, 9));
        System.out.println("Hay camino de 5 a 7: "+Recorrido.recorridoDFS(lista, 5, 7));

    }

}