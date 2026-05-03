package com.likelion.session.week5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return calculatorService.add(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/sub")
    public int subTwoNumbers(@RequestBody CalculatorSubRequest request){
        return calculatorService.sub(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/multiply")
    public int MultiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return calculatorService.multiply(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/divide")
    public int DivideTwoNumbers(@RequestBody CalculatorDivideRequest request){
        return calculatorService.divide(request.getNumber1(), request.getNumber2());
    }
}
