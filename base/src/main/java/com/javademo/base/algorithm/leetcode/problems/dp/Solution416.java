package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 14:43
 **/
public class Solution416 {
    /**
     * 典型背包问题
     * 在n个物品中选出一定的物品 填满 sum/2的背包
     * F(i,c)=F(i-1,c)||F(i-1,c-w(i))
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2){
            return false;
        }

        int sum=0;
        for (int i = 0; i <n; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){//不能均分
            return false;
        }
        int c=sum/2;
        boolean[] memory=new boolean[c+1];
        for (int i = 0; i <=c; i++) {
            memory[i]=(nums[0]==i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >=nums[i] ; j--) {
                memory[j]=memory[j]||memory[j-nums[i]];
            }
        }
        return memory[c];
    }
    /**
     * memory[i][c]表示使用索引为[0...i]这些元素,是否可以完全填充一个容量为c的背包
     * -1表示为未计算 0表示不可以填充 1代表可以填充
     */
    private int[][]memory;
    /**
     * 典型背包问题
     * 在n个物品中选出一定的物品 填满 sum/2的背包
     * F(i,c)=F(i-1,c)||F(i-1,c-w(i))
     * @param nums
     * @return
     */
    public boolean canPartitionRS(int[] nums) {
        int n=nums.length;
        if(n<2){
            return false;
        }

        int sum=0;
        for (int i = 0; i <n; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){//不能均分
            return false;
        }
        memory=new int[n][sum/2+1];
        for (int i = 0; i <memory.length ; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j]=-1;
            }
        }

        return tryPartition(nums,n-1,sum/2);
    }

    /**
     * 使用nums[0...index],是否可以完全填充一个容量为sum的背包
     * @param nums
     * @param index
     * @param sum
     * @return
     */
    private boolean tryPartition(int[] nums, int index, int sum) {
        if(sum==0){
            return true;
        }
        if(sum<0||index<0){
            return false;
        }
        if(memory[index][sum]!=-1){
            return memory[index][sum]==1;
        }
        boolean result=tryPartition(nums,index-1,sum)||tryPartition(nums,index-1,sum-nums[index]);
        memory[index][sum]=result?1:0;
        return result;
    }
}
