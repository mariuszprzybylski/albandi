package com.przybylski.lamaniekodu.model.Health;

import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public double calculateBmi(BmiCalculator bmiCalculator) {
        return (100 * 100 * bmiCalculator.getWeight() / (bmiCalculator.getHeight() * bmiCalculator.getHeight()));
    }
}

