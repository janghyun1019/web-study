package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.RequestDto;

@Controller
@RequestMapping("/request1")
public class RequestController {

    // Request 활용
    @GetMapping("/1")
    public String handleRequest1(HttpServletRequest request) {
        System.out.println("Category: " + request.getParameter("category"));
        System.out.println("Product: " + request.getParameter("product"));
        return "example/request1-1";
    }

    //  @RequestParam 활용
    @GetMapping("/2")
    public String handleRequest2(@RequestParam String category, @RequestParam String product, Model model) {
        System.out.println("Category: " + category);
        System.out.println("Product: " + product);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "example/request1-2";
    }

    // DTO 객체 활용
    @GetMapping("/3")
    public String handleRequest3(RequestDto dto, Model model) {
        System.out.println("Category: " + dto.getCategory());
        System.out.println("Product: " + dto.getProduct());
        model.addAttribute("dto", dto);
        return "example/request1-3";
    }

    // Map 활용
    @GetMapping("/4")
    public String handleRequest4(@RequestParam Map<String, String> params, Model model) {
        System.out.println("Category: " + params.get("category"));
        System.out.println("Product: " + params.get("product"));
        model.addAttribute("params", params);
        return "example/request1-4";
    }

}