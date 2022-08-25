package kg.megacom.student.services;

import kg.megacom.student.models.Courses;
import kg.megacom.student.models.dto.CourseDto;

import java.util.Optional;

public interface CourseService {
    Courses addCourse(CourseDto courseDto);

    Courses findById(Long courseId);

}
