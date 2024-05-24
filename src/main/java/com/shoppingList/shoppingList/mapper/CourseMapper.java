package com.shoppingList.shoppingList.mapper;

import com.shoppingList.shoppingList.Dto.CourseRequest;
import com.shoppingList.shoppingList.Dto.CourseResponse;
import com.shoppingList.shoppingList.entities.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {
    // comment utiliser le framework mapStruct a chercher

    public Course mapToCourse(CourseRequest courseRequest){
        return Course.builder()
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .dateCreation(courseRequest.getDateCreation())
                .build();
    }

    public CourseResponse mapToCourseResponse(Course course){
        return CourseResponse.builder()
                .name(course.getName())
                .description(course.getDescription())
                .dateCreation(course.getDateCreation())
                .build();
    }
}
