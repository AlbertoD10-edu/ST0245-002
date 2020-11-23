public class Proyecto{
    public static float giniPonderado(String[][] matrizI, String[][] matrizD, int columnaActual){
        float tamañoDerecha = 0;
        float elGiniDeLaIzquierda = impurezaGiniDeUnaMatriz(matrizI, columnaActual);
        float elGiniDeLaDerecha = impurezaGiniDeUnaMatriz(matrizD, columnaActual);
        float tamañoIzquierda = matrizI.length;
        for(String[] fila: matrizD){
            if(!fila[columnaActual].isEmpty()){
                tamañoDerecha++;
            }
        }
        //Ip = (ni*Ii + nd*Id) / (ni + nd)
        float giniPonderado = ((tamañoIzquierda * elGiniDeLaIzquierda) + (tamañoDerecha * elGiniDeLaDerecha)) /
            (tamañoIzquierda + tamañoDerecha);
        return giniPonderado;
    }

    public static float calcularMediaDeAtributo(String[][] m, int posVariable){
        float sumaDeAtributo = 0;
        float total = 0;
        for (String[] fila: m){
            if(!fila[posVariable].isEmpty()){
                sumaDeAtributo += (float)Float.parseFloat(fila[posVariable]);  
                total++;
            }
        }
        float media = sumaDeAtributo/m.length;
        return media;
    }

    public static float impurezaGiniDeUnaMatriz(String [][] matriz, int columnaActual){

        return 0;
    }
}
