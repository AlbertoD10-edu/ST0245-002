class Punto1{

  public static int maximo(int start, int[] nums){ // { }
    if (start == nums.length-1)
        return nums[nums.length-1];
    else
        return Math.max( nums[start] , maximo(start+1,nums) );
 }

   public static void main(String[] args){
  System.out.println(new int[]{-1, -2, -3});
 }
 
}
