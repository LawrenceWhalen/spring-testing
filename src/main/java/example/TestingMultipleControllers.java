package example;

import example.person.Person;
import example.person.PersonRepository;
import example.weather.WeatherClient;
import example.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@RestController
public class TestingMultipleControllers {

    private final PersonRepository personRepository;
    private final WeatherClient weatherClient;
    private final Logger log = LoggerFactory.getLogger(TestingMultipleControllers.class);

    @Autowired
    public TestingMultipleControllers(final PersonRepository personRepository, final WeatherClient weatherClient) {
        this.personRepository = personRepository;
        this.weatherClient = weatherClient;
    }

    @PostMapping("/person")
    public String addPerson(@RequestBody Person newPerson){
        try {
            personRepository.save(newPerson);
        } catch (Exception e) {
            log.error("Person failed to save.");
        }
        log.info("Added " + newPerson.getFirstName() + " " + newPerson.getLastName());
        return String.format("welcome %s %s!", newPerson.getFirstName(), newPerson.getLastName());
    }
}