package sortingAlgorithms;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {5,3,2,1,4};
        mergeSorts(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i + " ");
        }
    }
    static void mergeSorts(int[] arr, int l, int r){
        //Time Complexity = O(NLog(N))
        //Merge Sort involves breaking down the array into half repeatedly and
        //sorting the broken arrays and then
        int mid =(r+l)/2;
        if(l<r){
            mergeSorts(arr,l,mid);
            mergeSorts(arr,mid+1,r);
            merge(arr,l,r,mid);
        }
    }
    static void merge(int[] arr,int l, int r,int mid){
        //This method assumes the array from l to mid and mid+1 to r are sorted
        //To merge the two arrays we keep on comparing the elements in them
        int[] t = new int[r-l+1];//Temporary Array to store the sorted values
        int i = l,j=mid+1,k=0;
        //Merging the two array from l to mid and mid+1 to r
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]){//Ascending Order
                t[k++] = arr[j++];//Storing the sorted array into the temporary array
            }else {
                t[k++] = arr[i++];//Same here for other case
            }
        }
        //If the above loop is finished because the left or the
        //the elements on the right are exhausted

        //For the left side
       while (i<=mid){
           t[k++] = arr[i++];
       }
        //For the right side
       while(j<=r){
           t[k++] = arr[j++];
       }
        //Merging them now
            if (r + 1 - l >= 0) System.arraycopy(t, 0, arr, l, r + 1 - l);
    }

}
