package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody Project project, BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        if (project.getProjectIdentifier().length()<5 || project.getProjectIdentifier().length()>7){
            return builder.BadRequest();
        }
        projectService.save(project);
        return builder.success(project);
    }

    @GetMapping
    public Response findAll() {
        if (projectService.findAll().isEmpty()){
            return builder.noFount();
        }
        return builder.GetSuccess(projectService.findAll());}

}
