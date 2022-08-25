package kg.megacom.student.controllers.rest;

import kg.megacom.student.models.Groups;
import kg.megacom.student.models.requests.GroupRequest;
import kg.megacom.student.services.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/v1")

public class GroupsController {
    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping("/create-group")
    public Groups create(@RequestBody GroupRequest groupRequest){
        return groupService.create(groupRequest);
    }
}
