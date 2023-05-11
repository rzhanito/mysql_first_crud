package com.example.lab11_stud.controller;

import com.example.lab11_stud.model.Student;
import com.example.lab11_stud.repo.StudRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudController {
    private final StudRepo studRepo;

    public StudController(StudRepo studRepo) {
        this.studRepo = studRepo;
    }
    @GetMapping("/student")
    public String showStudentForm(Model model){
        var students =studRepo.findAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        return "Students.html";
    }
    @PostMapping("/student-add")
    public String storeStudent(@ModelAttribute Student student, Model model){
        studRepo.storeStudents(student);
        var students =studRepo.findAllStudents();
        model.addAttribute("students", students);
        return "redirect:/student";
    }
    @GetMapping("/student/delete")
    public String deleteStudent(@RequestParam Long id){
        studRepo.deleteStudent(id);
        return "redirect:/student";
    }
    @PostMapping("/student/upd")
    public String updateStudent(@ModelAttribute("student") Student student){
        studRepo.updateStudent(student);
        return "redirect:/student";
    }
}
