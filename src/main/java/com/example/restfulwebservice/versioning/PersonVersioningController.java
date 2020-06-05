package com.example.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    /* first version */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV1(){
        return new PersonV1("Elmir Ahadov");
    }

    /* second version */
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Elmir", "Ahadov"));
    }




}
