package com.przybylski.lamaniekodu.model.Health;

import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
@Data
public class BmiCalculator {
    private GenderEnum gender;
    @Min(25)
    @Max(300)
    private double weight;
    @Min(100)
    @Max(230)
    private int height;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}