package com.helloword.service;

/**
 * Created by scnyig on 12/14/2017.
 */
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.helloword.dao.PersonDao;
import com.helloword.dto.PersonDTO;
import com.helloword.entity.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author imssbora
 *
 */
@Service("personService")
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonDao userDao;

    @Transactional
    @Override
    public void add(Person person) {
        userDao.add(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonDTO> listPersons() {
        List<Person> persons = userDao.listPersons();
        if (persons.size() == 0) return null;
        List<PersonDTO> personDTOs = new ArrayList<>(persons.size());
        for (Person person:persons) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtils.copyProperties(person,personDTO);
            personDTOs.add(personDTO);
        }
        return personDTOs;
    }

}
