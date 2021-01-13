package com.pst.chatbot.service.impl;

import com.pst.chatbot.dto.CityDto;
import com.pst.chatbot.entity.City;
import com.pst.chatbot.mapper.CityMapper;
import com.pst.chatbot.repository.CityRepository;
import com.pst.chatbot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl  implements CityService {
    private final CityRepository  cityRepository;
    private final CityMapper cityMapper;

    @Override
    public CityDto getCityById(Long id) {
        City city = cityRepository.findById(id).orElse(new City());
        CityDto cityDto = cityMapper.cityToCityDto(city);
        return cityDto;
    }

    @Override
    public CityDto getCityByName(String name) {
        City city = cityRepository.findByCityName(name).orElse(new City());
        CityDto cityDto = cityMapper.cityToCityDto(city);
        return cityDto;
    }

    @Override
    public List<CityDto> getAll() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cityMapper.citiesToCitiesDto(cities);
    }

    @Override
    public void save(CityDto cityDto) {
        City city = cityMapper.cityDtoToCity(cityDto);
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
