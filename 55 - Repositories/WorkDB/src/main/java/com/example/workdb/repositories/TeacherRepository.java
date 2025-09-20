package com.example.workdb.repositories;

import com.example.workdb.DTOs.TeacherDTO;
import com.example.workdb.entities.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


//Repository
//CrudRepository
//save
//saveAll
//findById
//existById
//findAll
//findAllById
//count
//deleteById
//delete
//deleteAll







//PagingAndSortingRepository
//findAll(Pageable pageable)
//findAll(Sort sort)


//JPARepository

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {


}


