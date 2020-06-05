package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Configuration
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //using the get method and hello-world as URI
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello from Bean"); //constructor of HelloWorldBean
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s", name));
    }

    /* Internationalization */
    @GetMapping(path = "/hello-world-international")
    public String messageIntenationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("hello.message", null, LocaleContextHolder.getLocale());
    }

}