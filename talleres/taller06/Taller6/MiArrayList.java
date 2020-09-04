/**
 * @author Mauricio Toro, Andres Paez
 * Modificado por Alberto Andres Diaz Mejia
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];        
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size; // O(1)
    }   

    private void algoritmoDanielArango(int e){
        int[] arreglo = new int[elements.length * 2]; //1 -> O(1)
        for (int i = 0; i < elements.length; i++) // 2 -> O(n)
            arreglo[i] = elements[i];          // -> O(n)
        elements = arreglo; // 3                // ->  O(1)
    }                                           // T(n) es O(n)

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        boolean estaLleno = size == elements.length;
        if (estaLleno){
            algoritmoDanielArango(e); // O(n)
        }
        int laUltimaPosicion = size; // porque size - 1 ya está ocupado
        elements[laUltimaPosicion] = e;
        size++;
    }                                   // T(n) es O(n)

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        //int index = index;
        if (elements[index] != 0){
            System.out.println("Esta ocupado");
        } else{
            elements[index] = e;   
        }

    } 

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        if (elements[index] == 0){
            System.out.println("Esta vacio");
        } else{
            elements[index] = 0;   
        }
    }
}
