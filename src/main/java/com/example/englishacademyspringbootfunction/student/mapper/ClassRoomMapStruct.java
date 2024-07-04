package com.example.englishacademyspringbootfunction.student.mapper;

import com.example.englishacademyspringbootfunction.student.dao.entity.ClassRoom;
import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClassRoomMapStruct {

    ClassRoomMapStruct CLASS_ROOM_MAP_STRUCT = Mappers.getMapper(ClassRoomMapStruct.class);

    @Mapping(target = "id", ignore = true)
    ClassRoom fromDTOtoDAO(ClassRoomDTO classRoomDTO);

    ClassRoomDTO fromDaoToDto(ClassRoom classRoom);

    List<ClassRoomDTO> fromDaoToDto(List<ClassRoom> classRoom);

}
