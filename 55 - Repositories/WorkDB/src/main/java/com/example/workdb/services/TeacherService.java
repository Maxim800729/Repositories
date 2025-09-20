package com.example.workdb.services;

import com.example.workdb.entities.Teacher;

import java.util.Optional;

public interface TeacherService {
    Teacher save(Teacher t);                           // save
    Iterable<Teacher> saveAll(Iterable<Teacher> ts);   // saveAll

    Optional<Teacher> findById(Long id);               // findById
    boolean existsById(Long id);                       // existsById
    Iterable<Teacher> findAll();                       // findAll
    Iterable<Teacher> findAllById(Iterable<Long> ids); // findAllById
    long count();                                      // count

    void deleteById(Long id);                          // deleteById
    void delete(Teacher t);                            // delete
    void deleteAll();                                  // deleteAll
}
