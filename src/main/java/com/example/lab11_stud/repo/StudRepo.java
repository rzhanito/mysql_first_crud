package com.example.lab11_stud.repo;

import com.example.lab11_stud.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudRepo {
    private final JdbcTemplate jdbcTemplate;

    public StudRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeStudents(Student student) {
        String sql = "INSERT INTO students VALUES(NULL,?,?,?,?)";
        jdbcTemplate.update(sql, student.getCourse(), student.getFullName(), student.getGroupName(), student.getSpecialty());
    }

    public void deleteStudent(String fullName) {
        String sql = "delete from students where fullName = ?";
        jdbcTemplate.update(sql, String.valueOf(fullName));
    }

    public void updateStudent(Student student) {
        String sql2 = "SELECT * from students where fullName = ?";
        RowMapper studRowMap = (r,i)->{
            Student stud = new Student();
            stud.setId(r.getInt("id"));
            stud.setCourse(r.getInt("course"));
            stud.setFullName(r.getString("fullName"));
            stud.setGroupName(r.getString("groupName"));
            stud.setSpecialty(r.getString("specialty"));
            return stud;
        };
        String sql = "UPDATE students SET (course = ?, groupName = ?, specialty = ?) WHERE fullName = ?";
        jdbcTemplate.update(sql, student.getCourse(), student.getGroupName(), student.getSpecialty(), student.getFullName());
    }

    public List<Student> findAllStudents() {
        String sql = "SELECT * FROM students";
        RowMapper studentRowMapper = (r, i) -> {
            Student stud = new Student();
            stud.setId(r.getInt("id"));
            stud.setCourse(r.getInt("course"));
            stud.setFullName(r.getString("fullName"));
            stud.setGroupName(r.getString("groupName"));
            stud.setSpecialty(r.getString("specialty"));
            return stud;
        };
        return jdbcTemplate.query(sql, studentRowMapper);
    }
}
