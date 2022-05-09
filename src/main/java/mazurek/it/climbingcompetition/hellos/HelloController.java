package mazurek.it.climbingcompetition.hellos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Stranger") String name) {
        return "Hello " + name;
    }

    @GetMapping(path = "/demo")
    public String demo(){
        return "demo_ file";
    }
}
