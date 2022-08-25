package kg.megacom.student.controllers;

import kg.megacom.student.models.Teachers;
import kg.megacom.student.services.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherViewController {
    private final TeachersService teachersService;

    public TeacherViewController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping("/teachers")
    public String teacherList(Model model){
        List<Teachers> teachers = (List<Teachers>) teachersService.listTeacher();
        model.addAttribute("teachers",teachers);
        return "teachers";
    }
}
