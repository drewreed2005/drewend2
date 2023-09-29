package com.nighthawk.spring_portfolio.mvc.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/survey")  // all requests in file begin with this URI
public class SurveyApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private SurveyJpaRepository repository;

    /* GET List of Survey Questions
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Survey>> getSurvey() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /* Update Agreements
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PostMapping("/agree/{id}")
    public ResponseEntity<Survey> setAgr(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Survey> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Survey survey = optional.get();  // value from findByID
            survey.setAgree(survey.getAgree()+1); // increment value
            repository.save(survey);  // save entity
            return new ResponseEntity<>(survey, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update Disagreements
     */
    @PostMapping("/disagree/{id}")
    public ResponseEntity<Survey> setDis(@PathVariable long id) {
        Optional<Survey> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Survey survey = optional.get();
            survey.setDisagree(survey.getDisagree()+1);
            repository.save(survey);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Update neither responses
     */
    @PostMapping("/neither/{id}")
    public ResponseEntity<Survey> setNei(@PathVariable long id) {
        Optional<Survey> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Survey survey = optional.get();
            survey.setNeither(survey.getNeither()+1);
            repository.save(survey);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}