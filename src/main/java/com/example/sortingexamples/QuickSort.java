package com.example.sortingexamples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
[1, 6, 5, 2, 10, 1]

1 -> [1, 1, 5, 2, 10, 6]
2 -> [1, 1, 2, 5, 10, 6]
3 -> [1, 1, 2, 5, 6, 10]
 */
@Slf4j
@Service("quick")
public class QuickSort implements SortInterface {

    @Override
    public void sort(int[] array) {
        log.info("Start quick sorting for {}", array);

        // recursive
        quickSort(array, 0, array.length - 1);

        log.info("Sorted: {}", array);

    }

    private void quickSort(int[] array, int leftBorder, int rightBorder) {
        int left = leftBorder;
        int right = rightBorder;

        if (left >= right) {
            return;
        }

        // нашли центральный элемент
        int medium = array[(left + right) / 2];
        log.info("{}", medium);

        while (left <= right) {
            while (array[left] < medium) {
                left++;
            }

            while (array[right] > medium) {
                right--;
            }

            if (left <= right) {
                if (left < right) {
                    swap(array, left, right);
                    log.info("{}", array);
                }
                left++;
                right--;
            }
        }

        if (left < rightBorder) {
            quickSort(array, left, rightBorder);
        }

        if (leftBorder < right) {
            quickSort(array, leftBorder, right);
        }

    }

    private void swap(int[] array, int index1, int index2) {

        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
