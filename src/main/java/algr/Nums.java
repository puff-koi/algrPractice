package algr;

import java.util.Arrays;

public class Nums{

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int[] result = fun(nums,18);
        System.out.println(Arrays.toString(result));
    }

    public static int[] fun(int[] nums,int target){
        int len = nums.length;
        for (int i = 0; i < len-1 ; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] + nums[j] == target){
                    int[] res = {i,j};
                    return res;
                }
            }
        }

        return null;
    }
}