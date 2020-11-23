import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.List;

public class Reader{
    public  String m[][];
    public static List<Integer> ListaP = new ArrayList<Integer>(List.of(0, 1, 2, 3, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,27, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 43, 44, 46, 47, 48, 49, 50, 51, 55,56, 57, 58, 61, 62, 63, 64, 75, 76));

    public Reader(String s) throws Exception{
        int cont = 0;
        BufferedReader bufread = new BufferedReader(new FileReader(s));
        String line = bufread.readLine();
        while((line = bufread.readLine())!= null){
            cont++;
        }
        System.out.println(cont);
        
        int Var1= 0; //F
        int Var2= 0; //C
        bufread.close();
        m = new String[cont][30];
        BufferedReader bufread2 = new BufferedReader(new FileReader(s));
        line = bufread2.readLine();
        while((line = bufread2.readLine()) != null){
            String[] split = line.split(";");
            for(int i = 0; i <= (split.length-1); i++) {
                if(ListaP.contains(i)){
                    continue;                
                }else{
                    m[Var1][Var2]= split[i];
                    Var2++;
                } 
            }
            Var2=0;
            Var1++;
        }
    }
}