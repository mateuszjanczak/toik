package com.mateuszjanczak.toikkolokwium.web;

import com.mateuszjanczak.toikkolokwium.model.Alert;
import com.mateuszjanczak.toikkolokwium.model.Result;
import com.mateuszjanczak.toikkolokwium.service.QuadraticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class QuadraticController {

    private final QuadraticService quadraticService;

    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @GetMapping("/api/math/quadratic-function")
    public ResponseEntity<Object> calculateQuadratic(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b, @RequestParam(required = false) Double c, HttpServletRequest httpServletRequest) {

        Optional<Alert> optionalAlert = checkParams(httpServletRequest);

        if(optionalAlert.isPresent()) {
            return new ResponseEntity<>(optionalAlert.get(), HttpStatus.BAD_REQUEST);
        }

        Result result = quadraticService.calculate(a, b, c);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private Optional<Alert> checkParams(HttpServletRequest request) {

        Optional<Alert> optionalAlert = Optional.empty();

        ArrayList<String> errors = new ArrayList<>();

        if(!request.getParameterMap().containsKey("a")) errors.add("Podaj a");
        if(!request.getParameterMap().containsKey("b")) errors.add("Podaj b");
        if(!request.getParameterMap().containsKey("c")) errors.add("Podaj c");

        if(errors.size() > 0) {
            optionalAlert = Optional.of(new Alert(errors));
        }

        return optionalAlert;
    }

    /*@ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Alert handleException(MissingServletRequestParameterException ex) {
        return new Alert("Parametry nie zostały wprowadzone");
    }*/
}
