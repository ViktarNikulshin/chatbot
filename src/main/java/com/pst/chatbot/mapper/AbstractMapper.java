package com.pst.chatbot.mapper;

public interface AbstractMapper<Class, ClassDto> {
    ClassDto toDto(Class object);

    Class fromDto(ClassDto dto);
}
