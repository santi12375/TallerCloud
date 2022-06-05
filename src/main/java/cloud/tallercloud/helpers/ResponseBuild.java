package cloud.tallercloud.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ResponseBuild {

    public Response success() {
        return Response.builder()
                .data(OK)
                .code(OK.value()).build();
    }

    public Response success(Object data) {
        return Response.builder()
                .data(data)
                .code(OK.value()).build();
    }

    public Response failed(Object data) {
        return Response.builder()
                .data(data)
                .code(INTERNAL_SERVER_ERROR.value()).build();
    }

    public Response notFound(Object data) {
        return Response.builder()
                .data(data)
                .code(OK.value()).build();
    }
}
