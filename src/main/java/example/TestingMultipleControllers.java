package example;

import example.person.PersonRepository;
import example.weather.WeatherClient;
import example.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@RestController
public class TestingMultipleControllers {

    private final PersonRepository personRepository;
    private final WeatherClient weatherClient;
    private static final Logger log = LoggerFactory.getLogger(TestingMultipleControllers.class)

    @Autowired
    public ExampleController(final PersonRepository personRepository, final WeatherClient weatherClient) {
        this.personRepository = personRepository;
        this.weatherClient = weatherClient;
    }

    @PostMapping("/hello")
}