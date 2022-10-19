package com.example.sortingexamples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
[1, 6, 5, 2, 10, 1]

1 -> [1, 5, 2, 6, 10, 1]
2 -> [1, 5, 2, 6, 1, 10]
3 -> [1, 2, 5, 6, 1, 10]
4 -> [1, 2, 5, 1, 6, 10]
5 -> [1, 2, 1, 5, 6, 10]
6 -> [1, 1, 2, 5, 6, 10]
 */
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

        for(int i = 0; i < n - 1; ++i) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                log.info("{}", array);
            }
        }

        bubbleSort(array, n - 1);

    }

//    private void bubbleSort(int[] array, int n) {
//
//        for(int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    swap(array, j, j + 1);
//                }
//            }
//        }
//
//    }

    private void swap(int[] array, int index1, int index2) {

        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
