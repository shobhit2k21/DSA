class Solution {
    public int findMin(int[] nums) {

      int start=0, end=nums.length-1;
      int mid=0;
      int ans= Integer.MAX_VALUE;

      while(start<=end) {
        mid= (start+end)/2;
        int num= nums[mid];
        
       if(nums[start]<=num) {
        if(ans>nums[start]) 
        ans=nums[start];
        start=mid+1;
       }

       else {
        if(mid<end && ans>=nums[mid]) 
        ans=nums[mid];
        end=mid-1;
       }
    }
    return ans;
  }
}
