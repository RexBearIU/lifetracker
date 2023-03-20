package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.bean.DietRecord;
import com.example.bean.LifeUser;
import com.example.service.DietRecordService;
import com.example.service.UserService;

import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/dietRecord")
public class DietRecordController {

    @Resource
    DietRecordService dietRecordService;

    @Resource
    UserService userService;

    

    @RequestMapping(value = "/get/{period}")
    public String getDietRecords(@PathVariable("period") String period, Model model, Principal principal) {
        LifeUser user = userService.getUser(principal.getName());
        List<DietRecord> dietRecords = dietRecordService.getDietRecord(user.getId(), period);
        DietRecord dietRecord = new DietRecord();
        model.addAttribute("lifeUser", user);
        model.addAttribute("period", period);
        model.addAttribute("dietRecords", dietRecords);
        model.addAttribute("dietRecord", dietRecord);

        return "dietRecords";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Integer deleteId) {

        boolean delectDietRecord = dietRecordService.delectDietRecord(deleteId);
        System.out.println(delectDietRecord);

        return "redirect:/dietRecord/get/sevenDays";
    }

    @RequestMapping("/update")
    public String put(@ModelAttribute DietRecord dietRecord) {

        boolean putDietRecord = dietRecordService.putDietRecord(dietRecord);
        System.out.println("putDietRecord=" + putDietRecord);

        return "redirect:/dietRecord/get/sevenDays";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute DietRecord dietRecord) {
        boolean createDietRecord = dietRecordService.createDietRecord(dietRecord);       
        System.out.println("createDietRecord=" + createDietRecord);

        return "redirect:/dietRecord/get/sevenDays";
    }

    @RequestMapping(value="/search")
    public String getDietRecordByName(@RequestParam String food, Model model, Principal principal) {

        LifeUser user = userService.getUser(principal.getName());
        List<DietRecord> searchDietRecord = dietRecordService.searchDietRecord(user.getId(),food);

        DietRecord dietRecord = new DietRecord();
        model.addAttribute("lifeUser", user);
        //change
        model.addAttribute("period", food);

        model.addAttribute("dietRecords", searchDietRecord);
        model.addAttribute("dietRecord", dietRecord);

        return "dietRecords";
    }
    

}
