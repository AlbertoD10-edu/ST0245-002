public class Punto2{
    public static boolean groupSum(int start, int[] nums , int target){
        if (start == nums.length)
            return target == 0;
        else
            return groupSum( start+1, nums, target)
            || groupSum(start+1,nums,target-nums[start]);

    }

    public static void main(String[]args){
        for(int i=0 ; i<=10 ;i++){
            System.out.println(i);
            long ti= System.currentTimeMillis();
            groupSum(0,new int[i], 10);
            long tf = System.currentTimeMillis();
            System.out.println(tf-ti);
        }

    }
}
