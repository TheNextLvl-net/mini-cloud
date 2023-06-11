package minicloud.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.processing.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.miniCloud.base-path:}")
public class ServerApiController implements ServerApi {

    private final NativeWebRequest request;

    @Autowired
    public ServerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
