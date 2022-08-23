package kg.megacom.student.controllers;

import kg.megacom.student.models.Teachers;
import kg.megacom.student.models.dto.TeacherDto;
import kg.megacom.student.services.TeachersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/v1")
public class TeacherController {
    private final TeachersService teachersService;

    public TeacherController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @PostMapping("/add-teacher")
    public Object addTeacher(@RequestBody TeacherDto teacherDto){
        return teachersService.addTeacher(teacherDto);
    }
    @PostMapping("/delete-teacher")
    public void deleteTeacher(@RequestBody TeacherDto teacherDto){
        teachersService.deleteTeacher(teacherDto);
    }
    @GetMapping("/list-teacher")
    public Object teacherList(){
        return teachersService.listTeacher();
    }
}
