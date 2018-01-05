package com.helloword.service;

/**
 * Created by scnyig on 12/14/2017.
 */
import com.helloword.dto.PersonDTO;
import com.helloword.entity.Person;

import java.util.List;


public interface PersonService {
    void add(Person person);
    List<PersonDTO> listPersons();
}
