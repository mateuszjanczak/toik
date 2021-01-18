package com.mateuszjanczak.toikkolokwium.web;

import com.mateuszjanczak.toikkolokwium.model.Alert;
import com.mateuszjanczak.toikkolokwium.model.Result;
import com.mateuszjanczak.toikkolokwium.service.QuadraticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class QuadraticController {

    private final QuadraticService quadraticService;

    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @GetMapping("/api/math/quadratic-function")
    public ResponseEntity<Object> calculateQuadratic(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b, @RequestParam(required = false) Double c, HttpServletRequest httpServletRequest) {

        ArrayList<String> errors = new ArrayList<>();

        if(!httpServletRequest.getParameterMap().containsKey("a")) errors.add("Podaj a");
        if(!httpServletRequest.getParameterMap().containsKey("b")) errors.add("Podaj b");
        if(!httpServletRequest.getParameterMap().containsKey("c")) errors.add("Podaj c");

        if(errors.size() > 0) {
            return new ResponseEntity<>(new Alert(errors), HttpStatus.BAD_REQUEST);
        }

        Result result = quadraticService.calculate(a, b, c);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*@ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Alert handleException(MissingServletRequestParameterException ex) {
        return new Alert("Parametry nie zostały wprowadzone");
    }*/

}
