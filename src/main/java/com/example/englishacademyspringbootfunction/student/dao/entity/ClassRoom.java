package com.example.englishacademyspringbootfunction.student.dao.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "classRooms")
public class ClassRoom {

    @Id
    @GeneratedValue
    private String id;

    private String className;
    private String schedule;

}
