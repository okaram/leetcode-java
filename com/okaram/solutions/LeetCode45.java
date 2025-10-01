package samples;

public class LeetCode45 {
    public static void printArray(int []nums){
        System.out.print("{ ");
        for(int num : nums) {
            System.out.print(String.format("%d, ", num));
        }
        System.out.println("}");
    }

    public static int jump(int[] nums) {
        int[] minJumps=new int[nums.length];
        minJumps[minJumps.length-1]=0;
        for(int i=minJumps.length-2; i>=0;--i){
            int min=nums.length;
            for(int j=i+1; j<minJumps.length && j<=i+nums[i]; ++j){                
                if (minJumps[j]<min){
                    min=minJumps[j];
                }
            }
            minJumps[i]=min+1;
        }
        printArray(minJumps);
        return minJumps[0];
    }
}
