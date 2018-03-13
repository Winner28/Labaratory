package spring.fun;

import java.util.Arrays;

public class Algos {

    public static void main(String[] args) {
        int [] arr = {55555,6,2,1,100,150,99,0,3,7,8700};
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
        //insertionSort(arr);
      //  print(arr);
      //  System.out.println(secondFib(45));
        assert factorial(5) == 1320;

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
            while (j>=0 && var > array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            if (j != i + 1)
                array[j + 1] = var;
        }
    }

    private static void selectionSort(int []array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[index])
                    index = j;
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static void mergeSort(int []array, int l, int r) {
        if (l >= r)
            return;
       int middle = (l+r)/2;
       mergeSort(array, l, middle);
       mergeSort(array, middle + 1, r);
       merge(array, l, middle, r);
    }

    private static void merge(int[] array, int l, int middle, int r) {
        int n1 = middle - l + 1;
        int n2 = r - middle;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[i + l];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[j + middle +1];
        }
        int i = 0, j = 0;
        int k = l;
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i++];
            } else {
                array[k] = R[j++];
            }
            ++k;
        }

        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = R[j++];
        }
    }



    private static void quickSort(int []array) {
        reallyQuick(array, 0, array.length - 1);
    }

    private static void reallyQuick(int []array, int left, int right) {
      int l = left;
      int r = right;
      int pivot = l - (l - right)/2;
      while (l <= r) {
          while (array[l] < array[pivot]) l++;
          while (array[r] > array[pivot]) r--;

          if (l <= r) {
              int temp = array[l];
              array[l++] = array[r];
              array[r--] = temp;
          }
      }
      if (left < r) reallyQuick(array, left, r);
      if (right > l) reallyQuick(array, l, right);
    }

    private static int fib(int n) {
        if (n < 2)
            return n;
        return fib(n-1) + fib(n-2);
    }

    private static int secondFib(int n) {
        if (n<2) {
            return n;
        }
        int prev = 0;
        int next = 1;
        for (int i = 2; i<=n; i++) {
            next += prev;
            prev = next - prev;
        }

        return next;
    }

    private static int factorial(int number) {
        if (number == 0) return 1;
        if (number < 2) return number;
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    private static int [] secondChance(int []array) {
        if (array.length < 2) return array;
        int [] farray = Arrays.copyOfRange(array, 0, array.length/2);
        int [] sarray = Arrays.copyOfRange(array, array.length/2, array.length);
        return secondMerge(secondChance(farray), secondChance(sarray));
    }

    private static int[] secondMerge(int[] fir, int[] sir) {
        int [] result = new int[fir.length + sir.length];
        int f = 0, s = 0;
        for (int i = 0; i < result.length; i++) {
            if (f == fir.length) {
                result[i] = sir[s++];
            } else if (s == sir.length) {
                result[i] = fir[f++];
            } else if (fir[f] < sir[s]) {
                result[i] = fir[f++];
            } else {
                result[i] = sir[s++];
            }
        }
        return result;
    }
}


