package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.ResponseItem;

@Controller
@RequestMapping("/response1")
public class ResponseController {

    // Request 활용
    @GetMapping("/1")
    public String response1(HttpServletRequest request) {
        request.setAttribute("response001", "넘어간 값1");
        request.setAttribute("response099", "넘어간 값99");
        return "response/response1-1";
    }

    // Model 활용
    @GetMapping("/2")
    public String response2(Model model) {
        model.addAttribute("response001", "넘어간 값1");
        model.addAttribute("response099", "넘어간 값99");
        return "response/response1-2";
    }

    // ModelAndView 활용
    @GetMapping("/3")
    public ModelAndView response3() {
        ModelAndView mav = new ModelAndView("response/response1-3");
        mav.addObject("response001", "넘어간 값1");
        mav.addObject("response099", "넘어간 값99");
        return mav;
    }


    @GetMapping("/4")
    public String response4(@ModelAttribute("responseItem") ResponseItem responseItem) {
        responseItem.setResponse001("넘어간 값1");
        responseItem.setResponse099("넘어간 값99");
        return "response/response1-4";
    }
}