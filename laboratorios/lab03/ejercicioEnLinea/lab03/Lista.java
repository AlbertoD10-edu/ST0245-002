import java.util.LinkedList;
import java.util. *;
public class Lista {
    
    private Nodo inicio;
    private int tamanio;
    private Nodo fin;
    private String s1;
    
    public LinkedList tecladoRoto (String a){
      LinkedList < String > ll = new LinkedList();
      return ll ;
    }
    
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
 
    public boolean esVacia(){
        return inicio == null;
    }
   
    public int getTamanio(){
        return tamanio;
    }
   
    public void agregarAlFinal(int valor){
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);
        if (esVacia()) {
            fin = nuevo;
        } else{
            Nodo aux = fin;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);
        }
    
        tamanio++;
    }
    
    public void agregarAlInicio(int valor){
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);
        if (esVacia()) {
            inicio = nuevo;
        } else{ 
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
  
        tamanio++;
    }
    
    public static void main (String [] args) {
        return;
    }
 }
