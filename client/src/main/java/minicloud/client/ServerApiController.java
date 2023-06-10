package minicloud.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T01:42:30.937627644+02:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.miniCloud.base-path:}")
public class ServerApiController implements ServerApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ServerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
