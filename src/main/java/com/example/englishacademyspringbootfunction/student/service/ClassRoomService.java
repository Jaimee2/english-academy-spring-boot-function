package com.example.englishacademyspringbootfunction.student.service;

import com.example.englishacademyspringbootfunction.student.dao.entity.ClassRoom;
import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;

import java.util.List;

public interface ClassRoomService {
    void createClassRoom(ClassRoomDTO classRoomDTO);

    List<ClassRoom> getAllClassRooms();

    void deleteClassRoom(String id);
}
