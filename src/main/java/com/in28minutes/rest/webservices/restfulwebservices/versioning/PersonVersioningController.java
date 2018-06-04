package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @RequestMapping(method = RequestMethod.GET, path = "v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie")) ;
    }

}
