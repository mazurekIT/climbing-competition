package mazurek.it.climbingcompetition.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HelloController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("demo")
    public String demo() {
        return "demo_ file";
    }
}
