package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.services.ProjectTaskService;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;
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
    public Response save(@Valid @RequestBody ProjectTaskInDTO projectTaskInDTO, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        projectTaskService.save(projectTaskInDTO);
        return builder.success(projectTaskInDTO);
    }

    @GetMapping
    public List<ProjectTask> findAll(){
        return this.projectTaskService.findAll();
    }

}

