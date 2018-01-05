package com.helloword.web;
import java.util.List;

import com.helloword.dto.PersonDTO;
import com.helloword.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Created by scnyig on 1/4/2018.
 */
@RestController
public class HelloWorldRestController {
    @Autowired
    PersonService personService;


    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDTO>> listAllUsers() {
        List<PersonDTO> users = personService.listPersons();
        if(users.isEmpty()){
            return new ResponseEntity<List<PersonDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PersonDTO>>(users, HttpStatus.OK);
    }
}
