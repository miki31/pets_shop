package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.service.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/response")
@Slf4j
public class ResponseUiController {

    @Autowired
    private ResponseService responseService;


    // TODO: for testing
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id,
                           Model model){
        Response response = responseService.findById(id);
        model.addAttribute("response", response);
        return "fragments/card_response";
    }

    // TODO: for testing
    @GetMapping("/write")
    public String writeResponse(Model model){
        Response response = new Response();
        model.addAttribute("response", response);
        return "fragments/form_response";
    }

}
