package com.deployed.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deployed.service.CalculateCostService;



@RestController
public class CalculateCostController {

	@Autowired
	private CalculateCostService calculateCostService;

	@PostMapping("/calculate")
	@ResponseBody
	public int calculator(@RequestParam(value = "inputArray") int[] input) {
		return calculateCostService.calculateMinCost(input);

	}

}
