import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;

    public LinkedListMauricio()
    {
        size = 0;
        first = null;	

    }

    public class Node {
        public int data;
        public Node next;
        public Node(int data)
        {
            next = null;
            this.data = data;
        }
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = first;
        temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {// Y si la lista está vacía? Y si voy a insertar en la posición 0?
        Node nuevoNodo = new Node(data);
        Node temp = first;
        for (int i = 1; i <= index - 1; i++)
            temp = temp.next;
        nuevoNodo.next = temp.next.next;
        temp.next = nuevoNodo;
    }

    // Borra el dato en la posición index
    public void remove(int index){
        if(getNode(index) != null){
           getNode(index).data = 0;
           // getNode(index) =getNode(index).next; 
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        //Iterando hasta que lo encontremos
        Node unNodo = first;
        while (unNodo != null){ //OJO con Null pointer exception           
            if (unNodo.data == data)
                return true;
            unNodo = unNodo.next;
        }
        return false;
        // OJO con Missing return statement
    }

}
