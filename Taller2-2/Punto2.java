public class Punto2 {  
    public static boolean SumaGrupo(int[] nums, int target) { 
        return SumaGrupo(0, nums, target);   
    }          

    private static boolean SumaGrupo(int start, int[] nums, int target) {   
        if (start == nums.length){
            if (target == 0){
                return true;
            }else return false;
        }else{ 
            return SumaGrupo(start+1, nums, target - nums[start]) || SumaGrupo(start+1, nums, target); 
        }
    }
}
