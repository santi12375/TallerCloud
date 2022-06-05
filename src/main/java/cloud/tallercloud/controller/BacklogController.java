package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.services.BacklogService;
import lombok.RequiredArgsConstructor;
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


    @PostMapping
    public Response save(@Valid @RequestBody Backlog backlog , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        backlogService.save(backlog);
        return builder.success(backlog);
    }

    @GetMapping
    public Response findAll(){
        return builder.GetSuccess(backlogService.findAll());
    }


}
