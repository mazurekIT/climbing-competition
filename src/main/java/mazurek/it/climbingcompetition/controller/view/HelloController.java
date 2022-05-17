package mazurek.it.climbingcompetition.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("demo")
    public String demo() {
        return "demo_ file";
    }
}
