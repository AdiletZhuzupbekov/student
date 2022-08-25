package kg.megacom.student.controllers;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;
import kg.megacom.student.services.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentViewController {
    private final StudentsService studentsService;

    public StudentViewController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    public String sudentList(Model model){
        List<Students> students = studentsService.listOfStudents();
        model.addAttribute("students",students);
        return "students";
    }
}
