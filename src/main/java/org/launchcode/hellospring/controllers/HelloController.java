package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")     // this now lives /hello/goodbye
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles request of the form /hello?name=LaunchCode
    // lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) //more general annotation, lives at /hello
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // handles requests of the form /hello/LaunchCode
    // lives at hello/form
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // Creates a form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }
     // Exercise Controllers and Routing
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "Stinky";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";
        if (l.equals("english")) {
            greeting = "Hello";
        } else if (l.equals("french")) {
            greeting = "Bonjour";
        } else if (l.equals("italian")) {
            greeting = "Bonjourno";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }


}
