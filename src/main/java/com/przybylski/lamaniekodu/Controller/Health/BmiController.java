package com.przybylski.lamaniekodu.Controller.Health;

import com.przybylski.lamaniekodu.model.Health.BmiCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BmiController {

    @GetMapping("/health/bmiCalculator")
    public String bmi(Model model) {
        model.addAttribute("bmiCalculator", new BmiCalculator());
        return "health/bmiCalculator";
    }

    @PostMapping("/health/bmiCalculator")
    public String bmi(@ModelAttribute @Valid BmiCalculator bmiCalculator,
                      BindingResult bindingResult,
                      Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Błędnie wypełniony formularz");
            return "health/bmiCalculator";
        }
        model.addAttribute("bmi", 100 * 100 * bmiCalculator.getWeight() / (bmiCalculator.getHeight() * bmiCalculator.getHeight()));
        return "health/bmiResult";
    }
}

