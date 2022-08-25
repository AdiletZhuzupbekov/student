package kg.megacom.student.services.impls;

import kg.megacom.student.domains.GroupsRepo;
import kg.megacom.student.domains.LessonsRepo;
import kg.megacom.student.models.Courses;
import kg.megacom.student.models.Groups;
import kg.megacom.student.models.Lessons;
import kg.megacom.student.models.Payments;
import kg.megacom.student.models.enums.Day;
import kg.megacom.student.models.requests.GroupRequest;
import kg.megacom.student.services.CourseService;
import kg.megacom.student.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {


    private final GroupsRepo groupRepo;

    private final CourseService courseService;
    private final LessonsRepo lessonRepo;


    public GroupServiceImpl(GroupsRepo groupRepo, CourseService courseService, LessonsRepo lessonRepo) {
        this.groupRepo = groupRepo;
        this.courseService = courseService;
        this.lessonRepo = lessonRepo;
    }


    private List<Date> getLessonsDates(List<Day> days, int duration, Date startDate){
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        for (int i = 0; i < duration; ){
            long count = days
                    .stream()
                    .map(Day::getDayValue)
                    .filter(x-> x == calendar.get(Calendar.DAY_OF_WEEK))
                    .count();
            if (count == 1) {
                i++;
                dates.add(calendar.getTime());
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }


    @Override
    public Groups create(GroupRequest groupRequest) {

        Courses course = courseService.findById(groupRequest.getCourseId());
        if (course.getDuration() <= 0)
            throw new RuntimeException("Длительность не может быть меньше или равна нулю!");

        List<Date> lessonsDates = getLessonsDates(groupRequest.getDays(), course.getDuration(), groupRequest.getStartDate());
        Date maxDate = lessonsDates.get(course.getDuration()-1);


        Groups group = new Groups();
        group.setCourses(course);
        group.setStartDate(groupRequest.getStartDate());
        group.setEndDate(maxDate);
        group.setName(groupRequest.getGroupTitle());
        group = groupRepo.save(group);


        //adding lessons date to lessons table

        Groups finalGroup = group;
        List<Lessons> lessons = lessonsDates
                .stream()
                .map(x-> {
                    Lessons lesson = new Lessons();
                    lesson.setDay(x);
                    lesson.setGroups(finalGroup);
                    return lesson;
                })
                .collect(Collectors.toList());
        lessonRepo.saveAll(lessons);

        return group;
    }

    @Override
    public Groups findById(Long groupId) {
        return groupRepo.findById(groupId).get();
    }
}
