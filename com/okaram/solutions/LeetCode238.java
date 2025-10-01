package com.okaram.solutions;

public class LeetCode238 {
    private int[] makePrefixProducts(int[] nums) {
        int prefixprods[]=new int[nums.length];
        prefixprods[0]=1;
        for (int i=1;i<nums.length;++i) {
            prefixprods[i]=prefixprods[i-1]*nums[i-1];
        }
        return prefixprods;
    }

    private int[] makeSuffixProducts(int[] nums) {
        int suffixprods[]=new int[nums.length];
        suffixprods[nums.length-1]=1;
        for (int i=nums.length-2; i>=0; --i) {
            suffixprods[i]=suffixprods[i+1]*nums[i+1];
        }
        return suffixprods;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] prefixProducts=makePrefixProducts(nums);
        int[] suffixProducts=makeSuffixProducts(nums);

        //overwriting prefix, to save one allocation
        for(int i=0; i<nums.length;++i) {
            prefixProducts[i]*=suffixProducts[i];           
        }
        return prefixProducts;
    }

    public int[] productExceptSelf(int[] nums) {
        int tmpProds[]=new int[nums.length];
        tmpProds[0]=1;
        for (int i=1;i<nums.length;++i) {
            tmpProds[i]=tmpProds[i-1]*nums[i-1];
        }
        int postProd=1;
        for (int i=nums.length-2; i>=0; --i) {
            postProd=postProd*nums[i+1];
            tmpProds[i]*=postProd;
        }

        return tmpProds;
    }    
}
