package com.lu.test;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet() + 10000,
                            String.format(template, name));
    }

    @RequestMapping("/test")
    public Greeting test(HttpServletRequest request) {
        return new Greeting(counter.incrementAndGet() + 10000,
                String.format(template, request.getParameter("a")));
    }
}
