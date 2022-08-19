package kg.megacom.student.controllers;

import kg.megacom.student.models.Teachers;
import kg.megacom.student.services.TeachersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/v1")
public class TeacherController {
    private final TeachersService teachersService;

    public TeacherController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @PostMapping("/add-teacher")
    public Object addTeacher(@RequestBody Teachers teachers){
        return teachersService.addTeacher(teachers);
    }
}
