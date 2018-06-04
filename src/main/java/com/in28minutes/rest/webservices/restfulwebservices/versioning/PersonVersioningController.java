package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // URI versioning
    @RequestMapping(method = RequestMethod.GET, path = "v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie")) ;
    }

    // Request Parameter versioning
    @RequestMapping(method = RequestMethod.GET, path = "/person/param", params={ "version1" })
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/person/param", params="version2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // header versioning
    @RequestMapping(method = RequestMethod.GET, path = "/person/header", headers={ "X-API_VERSION-1" })
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/person/header", headers="X-API_VERSION-2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Accept header versioning / MIME type versioning / content negotiation
    @RequestMapping(method = RequestMethod.GET, path = "/person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/person/produces", produces="application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
