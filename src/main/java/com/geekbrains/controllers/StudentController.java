package com.geekbrains.controllers;

import com.geekbrains.entities.Student;
import com.geekbrains.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


// http://localhost:8189/app/students/...
@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentsService;

    @Autowired
    public void setStudentsService(StudentService studentsService) {
        this.studentsService = studentsService;
    }

    // GET http://localhost:8189/app/students/show_form
    @GetMapping("/show_form")
    public String showSimpleForm(Model model) {
        Student student = new Student();
        student.setFirstName("Bob");
        model.addAttribute("student", student);

        List<String> programmingLanguagesList = Arrays.asList(new String[]{"C++", "Java", "Python", "PHP", "C#"});
        model.addAttribute("pLanguages", programmingLanguagesList);
        return "student_form";
    }

    // POST http://localhost:8189/app/students/process_form
    @PostMapping("/process_form")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student_form_result";
    }

    // http://localhost:8189/app/students/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentById(@PathVariable Long id) {
        return studentsService.findById(id).orElseThrow(() -> new RuntimeException());
    }

    // http://localhost:8189/app/students/show
    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String showAllStudents(Model model) {
        List<Student> students = studentsService.getAllStudents();
        model.addAttribute("students", students);
        return "all_students";
    }
}