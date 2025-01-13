package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/practice/prac02/ask-bmi")
    public String askBmiForm() {
        return "practice/prac02/ask-bmi"; // ask-bmi.jsp 호출
    }

    @PostMapping("/practice/prac02/result-bmi")
    public String calculateBmi(@RequestParam("name") String name,
                               @RequestParam("height") double height,
                               @RequestParam("weight") double weight,
                               Model model) {
        double bmi = weight / Math.pow(height / 100, 2);
        String result;

        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi < 23) {
            result = "정상 체중";
        } else if (bmi < 25) {
            result = "과체중";
        } else {
            result = "비만";
        }

        model.addAttribute("name", name);
        model.addAttribute("bmi", String.format("%.2f", bmi));
        model.addAttribute("result", result);

        return "practice/prac02/result-bmi"; // result-bmi.jsp 호출
    }
}