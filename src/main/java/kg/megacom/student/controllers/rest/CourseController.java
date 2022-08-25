package kg.megacom.student.controllers.rest;

import kg.megacom.student.models.dto.CourseDto;
import kg.megacom.student.services.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add-course")
    public Object addCourse(@RequestBody CourseDto courseDto){
        return courseService.addCourse(courseDto);
    }
}
