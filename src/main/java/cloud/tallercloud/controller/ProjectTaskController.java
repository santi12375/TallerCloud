package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.services.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        projectTaskService.save(projectTask);
        return builder.success(projectTask);
    }

    @GetMapping
    public List<ProjectTask> findAll(){
        return this.projectTaskService.findAll();
    }

    @GetMapping("/project/{projectIdentifier}")
    public List<ProjectTask> findTaskAll(@PathVariable("projectIdentifier") String projectIdentifier){ return this.projectTaskService.findTaskByProject(projectIdentifier);}

    @GetMapping("/project/hours/{projectIdentifier}")
    public double GetHours(@PathVariable("projectIdentifier") String projectIdentifier){ return this.projectTaskService.findHoursProject(projectIdentifier);}

    @GetMapping("/project/hours/{projectIdentifier}/{status}")
    public double GetHoursStatus(@PathVariable("projectIdentifier") String projectIdentifier, @PathVariable("status") String status){ return this.projectTaskService.findHoursProjectByStatus(projectIdentifier,status);}

    @PatchMapping("/{idtask}/{projectIdentifier}")
    public void PatchStatusToDeleted(@PathVariable("idtask") Long idtask, @PathVariable("projectIdentifier") String projectidentifier){this.projectTaskService.deleteTaskStatus(idtask,projectidentifier);}
}

