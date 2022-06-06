package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
        try {
            projectService.save(project);
        }catch (Exception e){
            return builder.badRequest();
        }

        return builder.success(project);
    }

    @GetMapping
    public Response findAll() {
        if (projectService.findAll().isEmpty()){
            return builder.noFound();
        }
        return builder.getSuccess(projectService.findAll());}

}
