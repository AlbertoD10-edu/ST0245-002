class TorreHanoii {
    public int n;
    public String a;
    public String b;
    public String c;
 public static void hanoi(int n){
    hanoi(n, "Torre a", "Torre b", "Torre c");
 }


 public static void hanoi(int n, String a, String b, String c){
    if (n == 1)
        System.out.println (a + " > " + c);
    else {
        hanoi(n - 1 ,a , c ,b);
        hanoi(n - 1 ,c , b ,a);
        hanoi(n - 1 ,b , a ,c);
       
      
    }
    return;
 }

 

 public static void main(String[] args){
   hanoi(3);
 }
}
