package kg.megacom.student.controllers.rest;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;
import kg.megacom.student.services.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
public class StudentController {
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/add-student")
    public Object createStudent(@RequestBody StudentsDto students){
        return studentsService.createStudent(students);
    }

    @PutMapping("/update")
    public Object update(@RequestParam Long id, @RequestParam String title){
        return studentsService.updateStudent(id, title);
    }
    @DeleteMapping("/delete")
    public Object  deleteStudent(@RequestParam Long id){
       return studentsService.deleteStudent(id);
    }
    @GetMapping("/findAllNotDeleted")
    public List<Students> findNotDeleted(){
        return studentsService.findNotDeleted();
    }
}
