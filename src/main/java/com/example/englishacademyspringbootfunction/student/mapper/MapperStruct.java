package com.example.englishacademyspringbootfunction.student.mapper;

import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;
import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperStruct {

    MapperStruct INSTANCE = Mappers.getMapper(MapperStruct.class);

    @Mapping(target = "id", ignore = true)
    Student dtoToDao(RegistrationFormDTO formDTO);

}
