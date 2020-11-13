
import javafx.util.Pair;

/**
 * La clase Tree implementa un arbol binario de búsqueda.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (11/13/2020)
 */
public class Tree
{
    private Node root;
    private int size;
    private  String codigo="";

    public Tree(){
        this.root=null;
        this.size=0;
    }

    public int getSize(){
        return this.size;
    }

    public Node getRoot(){
        return this.root;
    }

    public void insert(String nombre,Integer numero){
        if(root==null){
            this.root=new Node(nombre,numero);
            //T(n)=  c1
        }else{
            insertAux(nombre,numero, this.root);
            //T(n)= T(n/2) + c2
        }
        //T(n)= T(n/2)
        //O(log n)
        //n: numero de nodos en el arbol
        this.size++;
    }

    public void insertAux(String nombre,Integer numero, Node node){
        if((int)numero < (int)node.getData().getValue()){
            if(node.getLeft()==null){
                node.setLeft(new Node(nombre,numero));
            }else{
                insertAux(nombre,numero, node.getLeft());
            }
        }else{
            if(node.getRight()==null){
                node.setRight(new Node(nombre,numero));
            }else{
                insertAux(nombre,numero, node.getRight());
            }
        }
    }

    public boolean contains(String nombre,Integer numero){
        Pair <String, Integer> value = new Pair(nombre, numero);
        if(this.size==0){ //Si se encuentra vacio
            return false;             //T(n)= c1
        }else{ 
            return containsAux(value, this.root);
            //T(n)= T(n/2) + c2
            //T(n)= T(n/2)
            //O(log n) 
            //n: numero de nodos en el arbol
        }
    }

    public boolean containsAux( Pair <String, Integer>  value, Node node){

        if(value.getKey()==node.getData().getKey() && (int)value.getValue() == (int)node.getData().getValue() ){
            return true;
        }else{ 
            if((int)value.getValue() < (int)node.getData().getValue()){
                if(node.getLeft()==null){
                    return false;
                }else{
                    return containsAux(value, node.getLeft());
                }
            }else{
                if(node.getRight()==null){
                    return false;
                }else{
                    return containsAux(value, node.getRight());
                }
            }
        }
    }

    public void printPreOrder(){
        printPreOrderAux(this.root);
    }

    public void printPreOrderAux(Node node){
        System.out.println(node.getData().getValue()+"  ");
        if(node.getLeft() != null){
            printPreOrderAux(node.getLeft());
        }

        if(node.getRight() != null){
            printPreOrderAux(node.getRight());
        }

        //T(n) = T(n/2) + T(n/2)+ c1
        //O(n)
        //n: numero de nodos en el arbol
    }

    public void printPosOrder(){
        printPosOrderAux(this.root);
    }

    public void printPosOrderAux(Node node){

        if(node.getLeft() != null){
            printPosOrderAux(node.getLeft());
        }

        if(node.getRight() != null){
            printPosOrderAux(node.getRight());
        }

        System.out.println(node.getData().getValue()+"  ");
        //T(n) = T(n/2) + T(n/2)+ c1
        //O(n)
        //n: numero de nodos en el arbol
    }

    public void printInOrder(){
        printInOrderAux(this.root);
    }

    public void printInOrderAux(Node node){
        if(node.getLeft() != null){
            printInOrderAux(node.getLeft());
        }

        System.out.println(node.getData().getValue()+"  ");

        if(node.getRight() != null){
            printInOrderAux(node.getRight());
        }
        //T(n) = T(n/2) + T(n/2)+ c1
        //O(n)
        //n: numero de nodos en el arbol
        //array=new ArrayList<String>();
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void graficarArbol(Node node){

        if(node.getLeft()==null || node.getRight()==null){
            return;
        }
        else{
            codigo=codigo+node.getData().getValue()+" -> ";
            if(node.getLeft() != null){
                codigo=codigo+node.getLeft().getData().getValue()+" ";
                graficarArbol(node.getLeft());
            }

            codigo=codigo+node.getData().getValue()+" -> ";
            if(node.getLeft() != null){
                codigo=codigo+node.getRight().getData().getValue()+" ";
                graficarArbol(node.getRight());
            }

        }
    }
}