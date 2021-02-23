package algr;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        if(arr.length == 0){
            return arr;
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i+1];
            int preIndex = i;
            while( preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        return arr;
    }
}
