package com.sparta.week01homework;
import com.sparta.week01homework.domain.Person;
import com.sparta.week01homework.domain.PersonRepository;
import com.sparta.week01homework.domain.PersonRequestDto;
import com.sparta.week01homework.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week01homeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01homeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("김르탄", 18, "서울시", "학생"));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }

            PersonRequestDto requestDto = new PersonRequestDto("김르탄", 19, "서울시", "학생");
            personService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }

            //personRepository.deleteAll();  //삭제
        };
    }
}
