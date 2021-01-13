package com.pst.chatbot.repository;

import com.pst.chatbot.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findById(Long id);
    Optional<City> findByCityName( String name);
}
