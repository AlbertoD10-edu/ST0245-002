import java.util.ArrayList;

public abstract class Graph
{
   //Tamaño del grafo
   protected int size;
   
   public  Graph(int vertices) 
   {
       size = vertices;
   }
   
   public  abstract void addArc(int source, int destination, int time);
   
   public abstract ArrayList<Integer> getSuccessors(int vertice);
   
   public abstract int getTime(int source, int destination);
   
   public  int size() {
       return size;
    }
}
