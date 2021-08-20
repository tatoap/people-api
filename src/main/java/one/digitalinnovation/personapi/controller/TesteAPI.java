package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/peoples")
public class TesteAPI {

    @GetMapping
    public String testeAPI() {
        return "Olá Mundo";
    }
}
