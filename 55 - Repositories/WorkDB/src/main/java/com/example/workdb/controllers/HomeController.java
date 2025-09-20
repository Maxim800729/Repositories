package com.example.workdb.controllers;

import com.example.workdb.entities.Teacher;
import com.example.workdb.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class HomeController {

    private final TeacherService service;

    public HomeController(TeacherService service) {
        this.service = service;
    }

    // findAll
    @GetMapping
    public Iterable<Teacher> getAll() { return service.findAll(); }

    // findById
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getOne(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // existsById (возвращаем 200/404)
    @GetMapping("/exists/{id}")
    public ResponseEntity<Void> exists(@PathVariable Long id) {
        return service.existsById(id) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    // findAllById ?ids=1,2,3
    @GetMapping("/by-ids")
    public Iterable<Teacher> getByIds(@RequestParam List<Long> ids) {
        return service.findAllById(ids);
    }

    // count
    @GetMapping("/count")
    public long count() { return service.count(); }

    // save (create)
    @PostMapping
    public Teacher create(@RequestBody Teacher t) { return service.save(t); }

    // saveAll (bulk)
    @PostMapping("/bulk")
    public Iterable<Teacher> createBulk(@RequestBody List<Teacher> list) {
        return service.saveAll(list);
    }

    // save (update) — по id
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher t) {
        if (!service.existsById(id)) return ResponseEntity.notFound().build();
        t.setId(id);
        return ResponseEntity.ok(service.save(t));
    }

    // deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!service.existsById(id)) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // delete (по сущности из тела)
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Teacher t) {
        service.delete(t);
        return ResponseEntity.noContent().build();
    }

    // deleteAll
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
