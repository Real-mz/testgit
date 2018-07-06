public class testadd{
    public static void quickSort(int[] arr, int low, int high) {
        int pivot;
        if(low<high){
            pivot = partition(arr,low,high);
            quickSort(arr,pivot+1,high);
            quickSort(arr,low,pivot-1);
        }        
    }
    public static int quickSelect(int[] arr, int k, int low, int high){
        if(low == high)
            return arr[high];
        int index = partition(arr,low,high);
        if(index-low+1>k)
            return quickSelect(arr,k,low,index-1);
        else if(index-low+1 ==k)
            return arr[index];
        else
            return quickSelect(arr,k-index+low-1,index+1,high);
    }
    public static int partition(int[] arr,int low,int high) {
        int pivotKey = arr[low];
        while(low<high){
            while(low<high && arr[high] <= pivotKey)
                high--;
            swap(arr,low,high);
            while(low<high && arr[low] >= pivotKey)
                low++;
            swap(arr,low,high);
        }
        return low;
    }
    
    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1,3,5,7,2,5,4};
        //quickSort(input,0,input.length-1);
        // for(int i = 0;i<input.length;i++){
        //     System.out.println(input[i]);
        // }
        int result = quickSelect(input,3,0,input.length-1);
        System.out.println(result);
    }
}