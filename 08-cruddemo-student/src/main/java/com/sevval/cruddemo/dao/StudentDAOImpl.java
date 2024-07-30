package com.sevval.cruddemo.dao;

import com.sevval.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //Beanin dao sınıfı olduğunu belirtmek için kullanılmaktadır.
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student); //öğrenciyi veritabanına kaydeder
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {

        TypedQuery<Student> theQuery=entityManager.createQuery(
                "FROM Student WHERE firstName=:theData", Student.class);

        theQuery.setParameter("theData", name);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student); //update the student

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student student=entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
