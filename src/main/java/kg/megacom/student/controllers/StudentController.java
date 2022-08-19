package kg.megacom.student.controllers;

import kg.megacom.student.models.Students;
import kg.megacom.student.services.StudentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/v1")
public class StudentController {
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/add-student")
    public Object createStudent(@RequestBody Students students){
        return studentsService.createStudent(students);
    }

}
