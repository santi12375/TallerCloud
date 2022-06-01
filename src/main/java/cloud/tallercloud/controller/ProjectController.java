package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.services.ProjectService;
import cloud.tallercloud.services.dto.ProjectInDTO;
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
    public Response save(@Valid @RequestBody ProjectInDTO projectInDTO, BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        projectService.save(projectInDTO);
        return builder.success(projectInDTO);
    }

    @GetMapping
    public Response findAll() { return builder.success(projectService.findAll());}

}
