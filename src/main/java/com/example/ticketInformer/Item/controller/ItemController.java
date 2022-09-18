package com.example.ticketInformer.Item.controller;

import com.example.ticketInformer.Item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @RequestMapping(value="/")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("itemList",itemService.getAllItems());
        return modelAndView;
    }
}
