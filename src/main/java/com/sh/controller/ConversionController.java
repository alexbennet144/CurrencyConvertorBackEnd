package com.sh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Example Controller", description = "APIs for managing examples")
@RequestMapping("/conversion")
public class ConversionController {

	public static final int DOLLAR_VALUE = 75;

	@GetMapping("/convert")
	@ApiOperation(value = "Get an example", notes = "Get an example by ID")
	public Double convertCurrency(@RequestParam Double amount, @RequestParam String toCurrency,
			@RequestParam String fromCurrency) {

		if ("USD".equalsIgnoreCase(fromCurrency) && "INR".equalsIgnoreCase(toCurrency)) {
			return amount * DOLLAR_VALUE; // Convert USD to INR
		} else if ("INR".equalsIgnoreCase(fromCurrency) && "USD".equalsIgnoreCase(toCurrency)) {
			return amount / DOLLAR_VALUE; // Convert INR to USD
		} else {
			// Unsupported currency conversion
			throw new IllegalArgumentException(
					"Unsupported currency conversion: " + fromCurrency + " to " + toCurrency);
		}
	}
}
