import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Maria Alejandra Velez Clavijo y Laura Katterine Zapata Rendon
 * @version 1
 */
public class DigraphAM extends Graph
{
    //matriz que contiene los arcos entre los vertics
    private int [][] grafoAM;
    /**
     * Constructor de DiagraphAM
     */
    public DigraphAM(int vertices) {
        super(vertices);
        grafoAM = new int[size][size];
        for(int i=0; i< grafoAM.length ; i++){
            for(int j=0; j< grafoAM.length; j++){
                grafoAM[i][j]=0;
            }
        }
    }

    public int[][] getGrafoAM(){
        return this.grafoAM;
    }

    /**
     * Metodo que agrega un arco entre dos vertices
     */
    @Override
    public void addArc(int source, int destination, int time)
    {
        grafoAM[source][destination] = time;
    }

    /**
     * Metodo que retorna el un ArrayList con el numero de todos los vertices que tengan una conexion
     * con uno
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertice)
    {
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        for(int i = 0;i < size;i++){           
            if(grafoAM[vertice][i] != 0){
                sucesores.add((Integer)i);
            }
        }
        return sucesores;
    }

    /**
     * Metodo que retorna el valor o peso de un arco entre dos vertices
     */
    @Override
    public int getTime(int source, int destination)
    { return grafoAM[source][destination];
    }
}
