package com.mateuszjanczak.toikkolokwium.service;

import com.mateuszjanczak.toikkolokwium.model.Result;
import org.springframework.stereotype.Service;

@Service
public class QuadraticServiceImpl implements QuadraticService {

    @Override
    public Result calculate(double a, double b, double c) {
        double delta = b*b-4*a*c;
        double sqrtDelta = Math.sqrt(delta);

        if(delta < 0) {
            return new Result();
        } else if (delta == 0) {
            double x0 = (-b+sqrtDelta)/(2*a);
            return new Result(String.valueOf(x0));
        } else {
            double x1 = (-b-sqrtDelta)/(2*a);
            double x2 = (-b+sqrtDelta)/(2*a);
            return new Result(String.valueOf(x1), String.valueOf(x2));
        }
    }
}
