package com.daniel.example.dao;

import com.daniel.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoHeapData implements StudentDao {

    private static Map<Integer, Student> students;
    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Kanye West", "Math"));
                put(2, new Student(2, "Marshal Matters", "English"));
                put(3, new Student(3, "Lil Wane", "Programming"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }

    @Override
    public Student getStudentById(int id){
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        students.merge(student.getId(), student, (s1, s2) -> s1=s2);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
