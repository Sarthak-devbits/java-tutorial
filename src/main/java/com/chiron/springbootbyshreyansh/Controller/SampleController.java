package com.chiron.springbootbyshreyansh.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping(value = "/api")
public class SampleController {

    @InitBinder
    protected void initBinder(DataBinder dataBinder){
        dataBinder.registerCustomEditor(String.class,"firstName",new FirstNamePropertyEditor());
        dataBinder.registerCustomEditor(String.class,"name", new namePropertyEditor());
    }

    @GetMapping(path = "/fetchUser")
    public String getUserDetails(
            @RequestParam(name="firstName")
            String firstName,
            @RequestParam(name="lastName")
            String lastName,
            @RequestParam(name="age")
            int age
    ){
        return "The user are "+firstName+" "+lastName+" and age: "+age;
    }

    @GetMapping(path = "/user/{name}")
    public String getUserName(
            @PathVariable(value = "name")
            String name
    ){
        return name;
    }

    @PostMapping(value = "/saveUser")
    public ResponseEntity<String> getSavedUser(
            @RequestBody
            User user
    ){
        return ResponseEntity.status(HttpStatus.OK).body(user.getEmail()+" name: "+user.getUsername());
    }
}



class User{
    @JsonProperty("user_name")
    private String username ;
    private String email ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class FirstNamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.trim().toUpperCase());
    }
}

class namePropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
       setValue(text.trim().toUpperCase());
    }
}