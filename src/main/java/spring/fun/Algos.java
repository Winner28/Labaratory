package spring.fun;

public class Algos {

    public static void main(String[] args) {
        int [] arr = {55555,6,2,1,100,150,99,0,3,7,8700};
        quickSort(arr);
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
            int var = array[i];
            int j = i - 1;
            while (j>=0 && var < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = var;
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
        reallyQuick(array, 0, array.length - 1);
    }

    private static void reallyQuick(int []array, int left, int right) {
        int l = left;
        int r = right;
        int pivot = (l + r)/2;

        while (l <= r) {
            while (array[l] < array[pivot]) l++;
            while (array[r] > array[pivot]) r--;

            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        if (l < right) reallyQuick(array, l, right);
        if (left < r) reallyQuick(array, left, r);
    }
}
