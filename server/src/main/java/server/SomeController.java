package server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class SomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello world!";
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public String name(@PathVariable("name") String name, @RequestParam("title") String title) {
        var sb = new StringBuilder();
        sb.append("Hello ");
        if (title != null) sb.append(title).append(" ");
        if (name != null) sb.append(name).append("!");
        return sb.toString();
    }
}