
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * La clase Recorrido tiene el objetivo de implementar un algoritmo para retornar si hay un 
 * camino entre dos vectores en un grafo bidireccional recorriendolo por DFS y BFS
 * 
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo) 
 * @version (13/11/2020)
 */
public class Recorrido
{

    public static boolean recorridoDFS(Digraph g, int source, int destination){
        boolean [] checked=new boolean[g.getSize()];
        return recorridoDFSAux( g, source, destination, checked);
    }

    public static boolean recorridoDFSAux(Digraph g, int source, int destination, boolean [] checked){
        ArrayList <Integer> next= g.getSuccessors(source);
        checked[source] = true;
        boolean answer = false;

        if(source==destination){
            answer=true;
        }

        for(int neighbor: next){
            if(checked[neighbor]!=true){
                answer = answer || recorridoDFSAux(g, neighbor, destination, checked);
            }
        }
        return answer;
    }

    public static boolean recorridoBFS(Digraph g, int source, int destination){
        boolean [] checked=new boolean [g.getSize()];
        return recorridoBFSAux(g, source, destination, checked);
    }

    public static boolean recorridoBFSAux(Digraph g, int source, int destination, boolean [] checked){
        ArrayList<Integer> visitedList = g.getSuccessors(source);
        Queue<Integer> lista=new LinkedList<Integer>();
        boolean answer=false;
        checked[source]=true;
        for(int nextNodo: visitedList){
            lista.add(nextNodo);
        }

        if(source==destination){
            answer=true;
        }
        //Si ya encontró el camino retorne true
        if(answer!=true){
            while(lista.size()!=0){
                int org =(int)lista.poll();
                //si ya lo visité paso al siguiente
                if(checked[org]!=true){
                    return recorridoBFSAux( g, org, destination, checked);        
                }
            }
        }
        return answer;
    }

}