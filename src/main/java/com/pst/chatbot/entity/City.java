package com.pst.chatbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="CITY")
public class City  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CITYNAME")
    private String cityName;

    @Column(name = "DESCRIPTION")
    private String description;
}
