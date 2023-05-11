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

    public void deleteStudent(Long id) {
        String sql = "delete from students where id = ?";
        jdbcTemplate.update(sql, Long.valueOf(id));
    }

    public void updateStudent(Student student) {
        String sql = "update students set course = ?, fullName = ?, groupName = ?, specialty = ? where id = ?";
        jdbcTemplate.update(sql, student.getCourse(), student.getFullName(), student.getGroupName(), student.getSpecialty(), student.getId());
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
