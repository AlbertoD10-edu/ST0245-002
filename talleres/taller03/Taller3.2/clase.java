public class clase {

       public static void main(String[] args) throws Exception {
           String str = "abcd";
           StringBuffer strBuf = new StringBuffer(str);
           Alobruto(strBuf,str.length());
       }    

       public static void Alobruto(StringBuffer str, int index){
           if(index <= 0)
               System.out.println(str);            
           else { 
               Alobruto(str, index-1);
               int var = str.length()-index;
               for (int i = var+1; i < str.length(); i++) { 
                   bruto(str,var, i);
                   Alobruto(str, index-1);
                   bruto(str,i, var);
               }
           }
       }

       public static void bruto(StringBuffer str, int pos1, int pos2){
           char t1 = str.charAt(pos1);
           str.setCharAt(pos1, str.charAt(pos2));
           str.setCharAt(pos2, t1);
       }
}
