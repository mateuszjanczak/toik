package com.demo.springboot.service.impl;

import com.demo.springboot.service.PeselService;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class PeselServiceImpl implements PeselService {
    @Override
    public boolean check(String id) {
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        if (id.length() != 11) return false;

        int sum = IntStream.range(0, 10).map(i -> Integer.parseInt(id.substring(i, i + 1)) * weights[i]).sum();

        int checkDigit = Integer.parseInt(id.substring(10, 11));

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return (sum == checkDigit);
    }
}
