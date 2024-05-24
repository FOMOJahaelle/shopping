package com.shoppingList.shoppingList.services;

import com.shoppingList.shoppingList.Dto.CourseRequest;
import com.shoppingList.shoppingList.Dto.CourseResponse;
import com.shoppingList.shoppingList.entities.Course;
import com.shoppingList.shoppingList.mapper.CourseMapper;
import com.shoppingList.shoppingList.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

  private  final  CourseRepository courseRepository;

  private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseResponse getOne(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::mapToCourseResponse)
                .orElseThrow(()->new EntityNotFoundException("Not Course found with id : " +id));
    }

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::mapToCourseResponse)
                .toList();
    }

    @Override
    public List<CourseResponse> searchByTache(String nameTache) {
        return courseRepository.findByTachesNameTache(nameTache).stream()
                .map(courseMapper::mapToCourseResponse)
                .toList();
    }

    @Override
    public CourseResponse create(CourseRequest course) {
    Course course1 = courseMapper.mapToCourse(course);
        return courseMapper.mapToCourseResponse(courseRepository.save(course1));
    }

    @Override
    public CourseResponse update(CourseRequest course,Long id) {
        Course course1 = courseRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not Course found with id : " +id));
        courseMapper.mapToCourse(course);
        return courseMapper.mapToCourseResponse(courseRepository.save(course1));
    }

    @Override
    public void delete(Long id) {
         courseRepository.deleteById(id);
    }
}
