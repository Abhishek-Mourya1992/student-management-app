package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Get all students
    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    // Find student by ID
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

	//----------****************----------------

    // Add new student
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    // Update student
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    // Delete student
    @Transactional
    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
