package cloud.tallercloud.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuild {

    public Response logicalDeleteSuccess(){
        return Response.builder()
                .code(OK.toString()).build();
    }

    public Response getSuccess(Object data){
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
                .code(BAD_REQUEST.toString()).build();
    }

    public Response badRequest(){
        return Response.builder()
                .code(BAD_REQUEST.toString()).build();
    }

    public Response noFound(){
        return  Response.builder()
                .code(NOT_FOUND.toString()).build();
    }

    public Response uniqueRestriction(){
        return  Response.builder()
                .code(FOUND.toString()+ " One project must have only one backlog").build();
    }

    public Response doubleValue(Double value){
        return Response.builder()
                .code(OK.toString())
                .data(value.toString()).build();
    }

}
