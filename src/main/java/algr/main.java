package algr;

public class main {
    public static void main(String[] args){
        int[] arr={2,1,3,5,4};

        int[] result = QuickSort.quickSort(arr,0,4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }


    }
}
