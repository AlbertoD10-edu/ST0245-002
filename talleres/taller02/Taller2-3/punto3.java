public class punto3{
    private static boolean SumaGrupoAvanzado(int start, int[] nums, int target) {
        if(start == nums.length){
            return target == 0;
        }
        else {
            return  SumaGrupoAvanzado(start +1, nums, target) || SumaGrupoAvanzado( start+1, nums, target - nums[start]);
        }
    }

}
