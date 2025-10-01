package samples;

public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        boolean[] canReach=new boolean[nums.length];
        canReach[canReach.length-1]=true;
        for(int i=canReach.length-1; i>=0;--i){
            for(int j=i+1; j<canReach.length && j<=i+nums[i]; ++j){
                if (canReach[j]){
                    canReach[i]=true;
                    break;
                }
            }
        }
        return canReach[0];
    }
}
