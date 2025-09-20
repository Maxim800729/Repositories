package com.example.workdb.services.impl;

import com.example.workdb.entities.Teacher;
import com.example.workdb.repositories.TeacherRepository;
import com.example.workdb.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repo;

    public TeacherServiceImpl(TeacherRepository repo) {
        this.repo = repo;
    }

    @Override public Teacher save(Teacher t) { return repo.save(t); }
    @Override public Iterable<Teacher> saveAll(Iterable<Teacher> ts) { return repo.saveAll(ts); }

    @Override public Optional<Teacher> findById(Long id) { return repo.findById(id); }
    @Override public boolean existsById(Long id) { return repo.existsById(id); }
    @Override public Iterable<Teacher> findAll() { return repo.findAll(); }
    @Override public Iterable<Teacher> findAllById(Iterable<Long> ids) { return repo.findAllById(ids); }
    @Override public long count() { return repo.count(); }

    @Override public void deleteById(Long id) { repo.deleteById(id); }
    @Override public void delete(Teacher t) { repo.delete(t); }
    @Override public void deleteAll() { repo.deleteAll(); }
}
