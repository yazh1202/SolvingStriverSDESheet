package ProblemSolving;

public class zeroOneTwoSort {

    //Bruteforcing Bubble Sort Algorithm to sort the array
    public void sortColors(int[] nums) {

        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>=nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    //Array Preprocessing to calculate the number of zeroes, one's and two's
    //Followed by reassigning the array the number of them
    public void sortColorsBetter(int[] nums) {
        int zero=0;
        int one= 0;
        int two = 0;
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else if(nums[i]==1){
                one++;
            }else if(nums[i]==2){
                two++;
            }
        }
        for(index = 0;index<zero;index++){
            nums[index]=0;
        }
        for(int j = 0;j<one;j++,index++){
            nums[index] = 1;
        }
        for(int j = 0;j<two;j++,index++){
            nums[index] = 2;
        }
    }

    //Dutch National Flag Algorithm
    public void sortColorsBest(int[] nums) {
        //Three pointers to track the numbers
        int low = 0,mid = 0,high = nums.length-1;

        while(mid<=high){ //Loop should run til mid reaches high
            if(nums[mid]==0){  //Element is 0
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }else if(nums[mid]==1){ //Element is 1
                mid++;
            }else{ // Element is 2
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
