package com.example.englishacademyspringbootfunction.student.service;

import com.example.englishacademyspringbootfunction.student.dao.entity.ClassRoom;
import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;

import java.util.List;
import java.util.Optional;

public interface ClassRoomService {
    void createClassRoom(ClassRoomDTO classRoomDTO);

    List<ClassRoom> getAllClassRooms();

    void deleteClassRoom(String id);

    Optional<ClassRoom> getClassRoomById(String id);
}
