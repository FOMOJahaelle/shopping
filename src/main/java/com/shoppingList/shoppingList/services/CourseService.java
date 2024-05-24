package com.shoppingList.shoppingList.services;

import com.shoppingList.shoppingList.Dto.CourseRequest;
import com.shoppingList.shoppingList.Dto.CourseResponse;
import com.shoppingList.shoppingList.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseResponse getOne (Long id);
    List<CourseResponse> findAll();

  List<CourseResponse> searchByTache(String nameTache);
    CourseResponse create(CourseRequest course);
    CourseResponse update(CourseRequest course,Long id);
    void delete(Long id);

}
