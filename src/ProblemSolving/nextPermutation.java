package ProblemSolving;

public class nextPermutation {
    //This approach doesn't work but was my first try
    public static void nextPermutations(int[] nums) {
        int low  = 0,high =nums.length-1;
        int min = -1,max = -1;
        while(high>=low){
            if(nums[high]>nums[low]){
                max = high;
                min = low;
                low++;
            }else{
                high--;
            }
        }
        if(high==low){
            if(nums[high]==nums[low]){
                return;
            }
            high = 0;
            low = nums.length-1;
            while(high>low){
                if(nums[high]>nums[low]){
                    max = high;
                    min = low;
                    high++;
                }else{
                    low--;
                }
            }

        }
        int temp = nums[max];
        nums[max] = nums[min];
        nums[min] = temp;
    }
    //Solution uses the two pointer approach similar to bubble sort
    //And reverses the order of the numbers at the end if needed
    public void nextPermutationBest(int[] nums) {
        int j = nums.length-2, i = nums.length-1;
        if(nums.length == 1){
            return;
        }
        while(j>=0&&nums[j+1]<=nums[j]){
            j--;
        }
        if(j>=0){
            while(nums[j]>=nums[i]){
                i--;
            }
            swap(nums,i,j);
        }
        reverse(nums,j+1);
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(int[] arr,int i){
        int end = arr.length-1;
        while(i<end){
            swap(arr,i++,end--);
        }
    }
}
