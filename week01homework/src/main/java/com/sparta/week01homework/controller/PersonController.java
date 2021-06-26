package com.sparta.week01homework.controller;

import com.sparta.week01homework.domain.PersonRepository;
import com.sparta.week01homework.domain.PersonRequestDto;
import com.sparta.week01homework.domain.Person;
import com.sparta.week01homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    @GetMapping("/myinfo")
    public Person getPerson(){
        Person person = new Person();
        person.setName("르탄이");
        person.setAge(18);
        person.setAddress("서울시");
        person.setJob("학생");
        return person;
    }

    @PostMapping("/api/persons")
    public Person createCourse(@RequestBody PersonRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Person person = new Person(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return personRepository.save(person);
    }


    @GetMapping("/api/persons")
    public List<Person> getCourses() {
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("api/persons/{id}")
    public Long deleteCourse(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }

}
