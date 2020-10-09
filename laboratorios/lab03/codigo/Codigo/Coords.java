import java.util.*; //Importamos toda la clase Java.util usando el * (Para resumir codigo)
import java.io.*;   //Importamos toda la clase Java.io   usando el * (Para resumir codigo)
public class Coords{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in); // Hacemos uso del scanner anteriormente importado
        System.out.print("Ingresar ruta del archivo (Con su extension)"); // imprimos un mensaje para poder ingresar la ruta del archivo
        String route = scan.next(); // Se crea una variable para ingresa la ruta
        Coords cord = new Coords(); // creamos un objeto de la clase
        LinkedList<String[]> listt = cord.readFile(route); // usamos el array anteriormente creado 
        for(int i = 0 ; i < listt.size() ; i++){ // inicio del for en i=0
            for(int n = 0 ; n < listt.get(i).length ; n++ ){ // incio del for en n=0
                System.out.print(listt.get(i)[n]); // con esto podemos obtener la listt en cada posicion
            }
            System.out.print("\n"); //con esto podemos realizar el salto en linea
        }
    }
    LinkedList<String[]> list = new LinkedList(); // cremos array de listas tipo String
    public LinkedList readFile(String nombreArchivo) throws FileNotFoundException{
        File archivo = new File(nombreArchivo);//Creamos una carpeta
        Scanner scan = new Scanner(archivo); // hacemos uso del Scanner anteriormente importado
        String stocker, stocker_Scolon ; // creamos nuestros almacenadores
        String[] s_util; // creamos  nuestro array
        int counter = 0; // creamos nuestro contador
        while(scan.hasNextLine()){         //Mientras encuentre alguna linea
            stocker = scan.nextLine(); // haciendo uso de la variable antes creada para almacenar(String) ire guardando cada linea que vaya entrando             
            stocker_Scolon = stocker.replace(";"," "); // haciendo uso de uno de los almacenadores ire remplandose cada ; por " " 
            s_util = stocker_Scolon.split(" ");        //               y hacer de esta forma mas facil la lectura
            Scanner sc_new = new Scanner(stocker_Scolon); // con el scanner haremos que nos busque todos los ;
            list.add(s_util); // usamos el metodo add para almacenar en nuestra array (list) los espacios(" ") que remplazaran al ; 
            counter++; // con esta variable anteriormente creada iremos contando cada unos de los datos 
        }
        System.out.println("los "+counter+" datos han sido cargados exitosamente !!");
        return list;
    }
}
