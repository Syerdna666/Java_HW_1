package Homeworks;

import java.util.*;

public class Homework_3 {
    public static void main(String[] args) {
        int[] arr = {2, 12, 33, 4, 52, 16, 72, 18, 9, 120};
        int length = arr.length;
//        System.out.println("Unsorted array: " + Arrays.toString(arr));
//        mergeSort(arr, 0, length - 1);
//        System.out.println("Sorted with merge sort array: " + Arrays.toString(arr));

//        removeEvenNumbers();

//        findMaxMinMean();

    }

    /**
     * Реализовать алгоритм сортировки слиянием
     */
    private static void mergeSort(int[] array, int left, int right){
        if (right <= left) return;
        int mid = (left + right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right){
        // calculate lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // create temp arrays

        int[] leftArray = new int [lengthLeft];
        int[] rightArray = new int [lengthRight];

        // copy sorted arrays to temp arrays

        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = array[left+i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if(leftIndex < lengthLeft && rightIndex < lengthRight){
                if(leftArray[leftIndex] < rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight){
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
    /**
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    private static void removeEvenNumbers() {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int val = random.nextInt(30);
            array.add(val);
        }
        System.out.println(array);
        for (int i = 0; i < array.size();) {
            if(array.get(i) % 2 == 0){
                array.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(array);
    }

    /**
     * Задан целочисленный список ArrayList.
     * Найти минимальное, максимальное и среднее из этого списка.
     */
    private static void findMaxMinMean(){
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int val = random.nextInt(30);
            array.add(val);
        }

        Collections.sort(array);
        System.out.println(array);
        System.out.println("Min: " + array.get(0));
        System.out.println("Max: " + array.get(array.size()-1));
        System.out.println("Mean: " + getMean(array));
    }
    private static double getMean(List<Integer> list){
        return list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }




}
