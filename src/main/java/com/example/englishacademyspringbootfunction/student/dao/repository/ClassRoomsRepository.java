package com.example.englishacademyspringbootfunction.student.dao.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.englishacademyspringbootfunction.student.dao.entity.ClassRoom;

import java.util.List;

public interface ClassRoomsRepository extends CosmosRepository<ClassRoom, String> {
    @Override
    List<ClassRoom> findAll();

}
