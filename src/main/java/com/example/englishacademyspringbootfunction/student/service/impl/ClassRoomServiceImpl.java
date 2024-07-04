package com.example.englishacademyspringbootfunction.student.service.impl;

import com.example.englishacademyspringbootfunction.student.dao.entity.ClassRoom;
import com.example.englishacademyspringbootfunction.student.dao.repository.ClassRoomsRepository;
import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;
import com.example.englishacademyspringbootfunction.student.service.ClassRoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.englishacademyspringbootfunction.student.mapper.ClassRoomMapStruct.CLASS_ROOM_MAP_STRUCT;

@Slf4j
@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomsRepository classRoomsRepository;

    @Override
    public void createClassRoom(ClassRoomDTO classRoomDTO) {
        classRoomsRepository.save(CLASS_ROOM_MAP_STRUCT.fromDTOtoDAO(classRoomDTO));
    }

    @Override
    public List<ClassRoom> getAllClassRooms() {
        return classRoomsRepository.findAll();
    }

    @Override
    public void deleteClassRoom(String id) {
        classRoomsRepository.findById(id).ifPresentOrElse(
                classRoom -> classRoomsRepository.delete(classRoom),
                () -> log.error("Class with id: {} does not exist", id)
        );
    }

    @Override
    public Optional<ClassRoom> getClassRoomById(String id) {
        return classRoomsRepository.findById(id);
    }

}
