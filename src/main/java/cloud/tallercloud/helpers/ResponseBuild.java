package cloud.tallercloud.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuild {

    public Response GetSuccess(Object data){
        return Response.builder()
                .data(data)
                .code(OK.toString()).build();
    }

    public Response success(Object data) {
        return Response.builder()
                .data(data)
                .code(CREATED.toString()).build();
    }

    public Response failed(Object data) {
        return Response.builder()
                .data(data)
                .code(INTERNAL_SERVER_ERROR.toString()).build();
    }

    public Response BadRequest(){
        return Response.builder()
                .code(BAD_REQUEST.toString()).build();
    }

    public Response noFount(){
        return  Response.builder()
                .code(NOT_FOUND.toString()).build();
    }

}
