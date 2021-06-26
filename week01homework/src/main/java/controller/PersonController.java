package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import prac.Person;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson(){
        Person person = new Person();
        person.setName("르탄이");
        person.setAge(18);
        person.setAddress("서울시");
        person.setJob("학생");
        return person;
    }

}
