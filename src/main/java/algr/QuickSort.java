package algr;

public class QuickSort {

    public static int[] quickSort(int[] arr,int leftIndex,int rightIndex){
        if (arr.length < 1 || leftIndex < 0 || rightIndex >= arr.length || leftIndex > rightIndex){
            return null;
        }

        int index = partition(arr,leftIndex,rightIndex);
        if(index > leftIndex)
            quickSort(arr,leftIndex,index - 1);
        if (index < rightIndex)
            quickSort(arr,index+1,rightIndex);
        return arr;
    }

    public static int partition(int[] arr,int leftIndex,int rightIndex){
        int pivot = (int) (leftIndex + Math.random() * (rightIndex - leftIndex + 1));
        int index = leftIndex - 1;
        swap(arr,pivot,rightIndex);
        for (int i = leftIndex; i <= rightIndex; i++){
            if (arr[i] <= arr[rightIndex]){
                index++;
                if (i > index)
                    swap(arr, i, index);
            }
        }
        return index;
    }

    public static void  swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
