package spring.fun;

public class Algos {

    public static void main(String[] args) {
        int [] arr = {55555,6,2,1,100,150,99,0,3,7,8700};
        selectionSort(arr);
        print(arr);
        binarySearch(arr,992);
    }

    private static void binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            if (value > arr[middle]) {
                left = middle + 1;
            } else if (value < arr[middle]) {
                right = middle - 1;
            } else {
                System.out.println("We got the value, its on position: " + middle);
                return;
            }
        }
        System.out.println("The value not exists!");

    }

    private static void print(int []arr) {
        for (int i : arr)
            System.out.print(i + " , ");
    }

    private static void bubbleSort(int []array) {
        for (int i = array.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
    }

    private static void insertionSort(int []array) {
        for (int i = 0; i < array.length; i++) {
        }
    }

    private static void selectionSort(int []array) {
        for (int i = 0; i < array.length; i++) {
            int var = array[i];
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < var) {
                    var = array[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }
    }

    private static void mergeSort(int []array) {

    }

    private static void quickSort(int []array) {

    }
}
