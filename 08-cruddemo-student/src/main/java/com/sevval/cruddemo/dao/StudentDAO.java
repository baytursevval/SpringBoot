package com.sevval.cruddemo.dao;

import com.sevval.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
