package be.yonicon.template.view.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping(value = "/ping", produces = "application/json")
    public String ping() {
        return "i am alive";
    }
}
