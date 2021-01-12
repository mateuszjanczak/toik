package com.mateuszjanczak.toikkolokwium.web;

import com.mateuszjanczak.toikkolokwium.model.Alert;
import com.mateuszjanczak.toikkolokwium.model.Result;
import com.mateuszjanczak.toikkolokwium.service.QuadraticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuadraticController {

    private final QuadraticService quadraticService;

    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @GetMapping("/api/math/quadratic-function")
    public ResponseEntity<Result> calculateQuadratic(@RequestParam double a, @RequestParam double b, @RequestParam double c) {
        Result result = quadraticService.calculate(a, b, c);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Alert handleException() {
        return new Alert("Parametry nie zostały wprowadzone");
    }

}
