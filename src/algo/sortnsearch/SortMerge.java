package algo.sortnsearch;

import java.util.Arrays;

public class SortMerge {
    public static void main(String[] args){
        int[] arrayForSort = {3,1,7,12,6,7};
        mergeSort(arrayForSort);
        for(int i : arrayForSort){
            System.out.println(i);
        }
    }

    static void mergeSort(int[] array){
        int[] helper = new int[array.length];
        mergeSort(array,helper,0,array.length-1);
    }
    static void mergeSort(int[] array, int[] helper, int low, int high){
        System.out.println("mergeSort: index " + low + " to " + high + ". array: " + Arrays.toString(array));
        if(low < high){
            int middle = low + (high - low)/2;
            mergeSort(array,helper,low,middle);
            mergeSort(array,helper,middle+1,high);
            merge(array,helper,low,middle,high);
        }
    }
    static void merge(int[] array, int[] helper, int  low, int middle, int high){
        System.out.print("merge: low: " + low + " high: " + high + " middle: " + middle + ". array: " + Arrays.toString(array));
        for(int i = low; i <= high; i++){
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;
        while(helperLeft <= middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = middle - helperLeft;
        for (int i=0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
        System.out.println(". Array after processing: " +  Arrays.toString(array));
    }
}



