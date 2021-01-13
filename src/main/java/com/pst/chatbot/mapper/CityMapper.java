package com.pst.chatbot.mapper;

import com.pst.chatbot.dto.CityDto;
import com.pst.chatbot.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")

public interface CityMapper {
    CityDto cityToCityDto(City city);
    City cityDtoToCity(CityDto cityDto);
    List<CityDto> citiesToCitiesDto(List<City> cityList);
}
