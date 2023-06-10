package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-10T23:08:49.260205852+02:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.miniCloud.base-path:}")
public class ApiApiController implements ApiApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
