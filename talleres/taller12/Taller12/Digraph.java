import java.util.ArrayList;

/**
 * La clase (Diagraph) se encargara de la implementacion de grafos bidirigidos
 *
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo) 
 * @version (13/11/2020)
 */
public class Digraph {
    private int size;
    private int [][] matriz;

    /**
     * Constructor para el grafo bidirigido
     * @param vertices el numero de vertices que tendra el grafo bidirigido
     *
     */

    public Digraph(int size) {
        this.size=size;
        this. matriz = new int [size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.matriz[i][j]=0;
            }
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination) {
        this.matriz[source][destination]=1;
        this.matriz[destination][source]=1;
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> array=new ArrayList<>();

        for(int i=0; i<this.size; i++){
            if(getWeight(vertex,i)!=0){
                array.add((Integer)i);
            }
        }
        return array;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {
        int weight =0;
        if(this.matriz[source][destination]!=0){
            weight=this.matriz[source][destination];
        }
        return weight;
    }

    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int getSize() {
        return this.size;
    }
}
