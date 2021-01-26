package com.hotbev.tea.Controllers;

import com.hotbev.tea.Repositories.TeaRepository;
import com.hotbev.tea.Services.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeaController {

    @Autowired
    TeaService teaService;

    @Autowired
    TeaRepository teaRepository;

    @RequestMapping(
            value = "/teas",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String teaTest(
            @RequestParam String tea,
            @RequestParam String description) {
        return "Tea Name " + tea + " Description " + description;

        // public ResponseEntity<String> helloCoffee2 () {
        //return ResponseEntity.status(HttpStatus.OK).body("You hit me!");
    }


    @RequestMapping(
            value = "/addTea",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String makeTea(
            @RequestParam String description,
            @RequestParam String name,
            @RequestParam String source) {
        return teaService.makeTea(description, name, source);
    }



    @RequestMapping(
            value = "/getAllTeas",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getCoffeesDrinks() {

        return teaService.findAllTeas();

    }

    @RequestMapping(
    value="/deleteTea",
    method = RequestMethod.POST,
    consumes = "application/x-www-form-urlencoded",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteTea(Integer id) {
        teaService.deleteTea(id);
        return "TeaController:: Tea entry successfully deleted!";
    }
}
