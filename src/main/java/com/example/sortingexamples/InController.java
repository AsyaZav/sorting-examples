package com.example.sortingexamples;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class InController {

    private final Map<String, SortInterface> sortInterfaces;

    @PostMapping("/sort/{type}")
    public void sort(@PathVariable("type") String type,
                     @RequestBody int[] array) {

        SortInterface sortInterface = sortInterfaces.get(type);
        sortInterface.sort(array);

    }
}
