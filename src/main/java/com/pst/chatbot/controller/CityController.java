package com.pst.chatbot.controller;

import com.pst.chatbot.dto.CityDto;
import com.pst.chatbot.entity.City;
import com.pst.chatbot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/city/{id}")
    public String getCityById(@PathVariable(value = "id",required = false) Long id,Model model) {
        CityDto cityDto = cityService.getCityById(id);
        model.addAttribute("city", cityDto);
        return "city";
//        return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
    }

    @GetMapping("/city")
    public String addCity(Model model) {
        CityDto cityDto = new CityDto();
        model.addAttribute("city", cityDto);
        return "city";
    }
    @GetMapping("/city/all")
    public String  getAllCities(Model model) {
        model.addAttribute("cities", cityService.getAll());
        return "cityall";
//        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/city/find/{name}")
    public ResponseEntity<?> getCityByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(cityService.getCityByName(name), HttpStatus.OK);
    }
    @PostMapping("/city/create")
    public String create(@ModelAttribute (value = "city")CityDto cityDto,Model model){
        cityService.save(cityDto);
        model.addAttribute("cities", cityService.getAll());
        return "cityall";
    }
    @GetMapping("/city/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        cityService.delete(id);
        model.addAttribute("cities", cityService.getAll());
        return "cityall";
    }
}
