package com.pst.chatbot.service;

import com.pst.chatbot.dto.CityDto;
import com.pst.chatbot.entity.City;

import java.util.List;

public interface CityService {

    CityDto getCityById(Long id);

    CityDto getCityByName(String name);

    List<CityDto> getAll();

    void save(CityDto cityDto);

    void  delete(Long id);
}
