class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findfirst(nums, target);
        int last=findlast(nums,target);
        return new int[]{first,last};

    }
    public int findfirst(int[]nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;

        while(low<=high){
            int mid =low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;

            }

            else {
                high=mid-1;
            }
        }
        return ans;
    }

    public int findlast(int[]nums, int target){
        int low=0;
        int high= nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            } else {
                high=mid-1;
            }

            }
            return ans;
        }
    }
