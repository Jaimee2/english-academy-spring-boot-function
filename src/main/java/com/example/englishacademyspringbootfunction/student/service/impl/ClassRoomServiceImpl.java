package com.example.englishacademyspringbootfunction.student.service.impl;

import com.example.englishacademyspringbootfunction.student.dao.repository.ClassRoomsRepository;
import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;
import com.example.englishacademyspringbootfunction.student.service.ClassRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.englishacademyspringbootfunction.student.mapper.ClassRoomMapStruct.CLASS_ROOM_MAP_STRUCT;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomsRepository classRoomsRepository;

    public void createClassRoom(ClassRoomDTO classRoomDTO) {
        classRoomsRepository.save(CLASS_ROOM_MAP_STRUCT.fromDTOtoDAO(classRoomDTO));
    }

}
