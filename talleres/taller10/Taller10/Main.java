import javafx.util.Pair;
/**
 * En esta clase (main) se realizan las pruebas con los metodos creados en la clase Tree.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (13/11/2020)
 */
public class Main{
    public static void main(String []args){

        Tree tree=new Tree();

        tree.insert("Maria",123123);
        tree.insert("Juan",321321);
        tree.insert("Carlos",111111);
        tree.insert("Laura",111112);
        tree.insert("Alejandra",222222);
        tree.insert("Katterine",4);
        tree.insert("Julian",999999);
        tree.insert("Mauricio",2);
        tree.insert("Camila",800);
        tree.insert("Alvaro",1000000);
        tree.insert("Mariana",700000);
         
        System.out.println("InOrder:");
        tree.printInOrder();
        System.out.println();

        System.out.println("PreOrder:");
        tree.printPreOrder();
        System.out.println();

        System.out.println("PosOrder:");
        tree.printPosOrder();
        System.out.println(tree.getSize());
        System.out.println(tree.contains("Maria",123123));
        System.out.println(tree.contains("Jose",564735));
        tree.graficarArbol(tree.getRoot());
        System.out.println(tree.getCodigo());
    }
}
