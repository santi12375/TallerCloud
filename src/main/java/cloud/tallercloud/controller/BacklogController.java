package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.services.BacklogService;
import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;
    private final ProjectService projectService;


    @PostMapping
    public Response save(@Valid @RequestBody Backlog backlog , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        if(projectService.findProjectByProjectIdentifier(backlog.getProjectIdentifier()).isEmpty()){
            return builder.badRequest();
        }
        if(backlogService.findBacklogsByProjectIdentifier(backlog.getProjectIdentifier())){
            return builder.uniqueRestriction();
        }
        if(backlogService.findBacklogByProjectId(backlog.getProject().getId())){
            return builder.uniqueRestriction();
        }

        try {
            backlogService.save(backlog);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(backlog);
    }

    @GetMapping
    public Response findAll(){
        return builder.getSuccess(backlogService.findAll());
    }


}
