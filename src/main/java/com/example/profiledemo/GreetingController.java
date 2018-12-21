package com.example.profiledemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
    @GetMapping("/hello")
    @ResponseBody
    public Greeting sayHello() {
        ShellCommand cmd = new ShellCommand();
        String command = "mvn archetype:generate -DarchetypeArtifactId=maven-archetype-archetype -DgroupId=groupId -DartifactId=asimio-api-archetype -DinteractiveMode=false";
        cmd.execute(command);

        return new Greeting("hello");
    }
}
