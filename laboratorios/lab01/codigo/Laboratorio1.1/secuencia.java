public class secuencia{
    private static void combinacionA(String Px, String y) {
        if(y.length() == 0) {
            System.out.println(Px );
        }else{
            combinacionA( Px + y.charAt(0), y.substring(1));
            combinacionA( Px, y.substring(1));
        }
    }

    public static void combinacion(String s) {
        combinacionA("", s);
    }

    public static void main(String[]args){
        combinacionA("pring","pringft");

    }
}
