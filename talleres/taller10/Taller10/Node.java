
import javafx.util.Pair;
/**
 *En esta clase (Node) se implemento el nodo de un arbol binario de búsqueda.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (13/11/2020)
 */
public class Node{
    private Pair<String,Integer> data;
    private Node left;
    private Node right;

    public Node(String nombre,Integer numero){
        this.data=new Pair(nombre,numero);
        this.left=null;
        this.right=null;
    }

    public Pair<String,Integer> getData(){
        return this.data;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public void setRight(Node right){
        this.right=right;
    }

}