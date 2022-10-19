package com.example.sortingexamples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("bubble")
public class BubbleSort implements SortInterface {

    @Override
    public void sort(int[] array) {
        log.info("Start bubble sorting for {}", array);

        // recursive
        bubbleSort(array, array.length);

        log.info("Sorted: {}", array);

    }

    private void bubbleSort(int[] array, int n) {
        if (n == 0 || n == 1) {
            return;
        }

        for(int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }

        bubbleSort(array, n - 1);

    }

    private void swap(int[] array, int index1, int index2) {

        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
