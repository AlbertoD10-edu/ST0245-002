import javafx.util.Pair; 
import java.util.TreeSet;

public class Tree{
    public static TreeSet<String> valSR(String[][] m, int variable){ // valSR = Todos los valores sin respuesta
        TreeSet<String> Rta = new TreeSet(); // Rta = Respuesta
        if(!AlertIsNumeric(m[0][variable])){
            for (int f = 0; f < m.length; f++){ // fila
                if(!m[f][variable].equals("")){
                    Rta.add(m[f][variable]);
                }
            }
        }else{
            double promedio = promedioSimple(m, variable);
            Rta.add(String.valueOf(promedio));

        }  
        return Rta; 
    }

    
    public static boolean countLabelsMatrix(String[][] m){
        int contNum = 0; // contNum = Contador numerico
        int contLen = m.length; // ContLen = Contado de longitud
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("1")){
                contNum++;
            }            
        } 
        double ProN = (contNum*100) / contLen; // ProN = probabilidad
        if(ProN >= 51){
            return true;
        } 
        return false;
    }     

    public static Pair<String[][],String[][]> divideMatrix(String[][] m, int posVariable, String valor){
        int  NoTrIz  = 0; //  NoTrIz = Nodo verdadero izquierdo
        if(AlertIsNumeric(valor)){ 
            double valDou = Double.parseDouble(valor);
            for (int f = 0; f <= (m.length-1); f++){ // nuevamente la f = fila
                if (Double.parseDouble(m[f][posVariable]) >= valDou){ 
                    NoTrIz ++;
                }
            }
        }else{
            for (int fila = 0; fila < m.length; fila++){
                if (m[fila][posVariable].equals(valor)){ 
                    NoTrIz ++;
                }
            }
        }
        int NoFaDe = m.length -  NoTrIz ; // NoFaDe = Nodo Falso derecho
        String[][] NoTrIz2 = new String[NoTrIz][m[0].length]; // NoTrIz2 = Nodo verdadero izquierdo [Matriz]
        String[][] NoFaDe2 = new String[NoFaDe][m[0].length]; //NoFaDe2 =Nodo falso derecho [Matriz]
        int fila0 = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila0<m.length){ //
            if(!AlertIsNumeric(valor)){
                if(m[fila0][posVariable].equals(valor)){
                    NoTrIz2[filaN1]=m[fila0];
                    fila0++;
                    filaN1++;
                }else{
                    NoFaDe2[filaN2]=m[fila0];
                    fila0++;
                    filaN2++;
                }
            }else{
                if(Double.parseDouble(m[fila0][posVariable]) >= Double.parseDouble(valor)){
                    NoTrIz2[filaN1]=m[fila0];
                    fila0++;
                    filaN1++;
                }else{
                    NoFaDe2[filaN2]=m[fila0];
                    fila0++;
                    filaN2++;
                }
            }
        }

        Pair<String[][],String[][]> parMatrix = new Pair(NoTrIz2,NoFaDe2);
        return parMatrix;
    }

    
    public static float giniNodo(String[][] m){
        float successfull = 0;
        for (int fila = 0; fila < m.length; fila++){
            if (m[fila][m[0].length-1].equals("1")){
                successfull++;
            }
        }
        float unsuccessfull = (float)m.length - successfull;
        float groupSuccessfull = successfull/(float)m.length;
        float groupUnsuccessfull = unsuccessfull/(float)m.length;
        float impurity = 1 - groupSuccessfull*groupSuccessfull - groupUnsuccessfull*groupUnsuccessfull;
        return impurity;        
    }

    public static double infoGain(String[][] nodeIzq, String[][] nodeDrch, float impurityMatrix){
        double a = (double)nodeIzq.length/((double)nodeIzq.length + (double)nodeDrch.length);
        return impurityMatrix - a * giniNodo(nodeIzq) - (1-a) * giniNodo(nodeDrch);
    }

    
    public static Pair< Float, Pair<String,Integer>> betterQuestion(String[][] matrix){ 
        // n*m*n = O(n^2*m*2^m)
        double best_gain = 0; 
        String best_question = "";
        float curren_uncertainty = giniNodo(matrix);
        int columna = 0; 
        double promedio = 0;
        for(int i = 0; i < matrix[0].length-1; i++){ //t(n) = m;//las columnas
            TreeSet<String> t = valSR(matrix, i);
            while(!t.isEmpty()){ // filas 
                String question = t.pollFirst();                 
                Pair<String[][],String[][]> pareja = divideMatrix(matrix, i, question); // las filas
                if(pareja.getKey().length == 0 || pareja.getValue().length == 0){
                    continue;
                }else{
                    double gain = infoGain(pareja.getKey(), pareja.getValue(), curren_uncertainty);
                    if(gain >= best_gain){
                        best_gain = gain;
                        best_question = question;
                        columna = i;
                    }
                }
            } 
        }
        Pair<String,Integer> m = new Pair(best_question, columna);
        Pair<Float,Pair<String,Integer>> bestQuestion = new Pair(best_gain, m);        
        return bestQuestion;
    }     

    public static double promedioSimple(String[][] m, int c) { //C = columna ; PromedioSimple = en este promedio simple se encuentra el promedio de una matriz  de forma comun(Simple)
        double cont = 0; // cont = contador
        double sum = 0; // Sum = suma
        for (int f = 1; f <= (m.length-1); f++){ // nuevamente f = fila
            sum += Double.parseDouble(m[f][c]);
            cont++;
        }
        return (sum / cont); // Al finalizar se devuelve el promedio
    }

    public static boolean AlertIsNumeric(String str){   // En AlertIsNumeric  se avisar si se encuentra algun numero
        try{  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe){  
            return false;  
        }  
        return true;  
    } 
}
