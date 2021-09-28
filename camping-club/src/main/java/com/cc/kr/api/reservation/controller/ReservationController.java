package com.cc.kr.api.reservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cc.kr.api.reservation.model.Reservation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "예약")
@RestController
public class ReservationController {
	
	@ApiOperation(value = "예약 조회")
	@GetMapping(value = "/reservation")
	public Reservation reservation(@RequestParam("name") String name, @RequestParam("age") int age) {		
		System.out.println("reservation");
		return Reservation.builder()
				.name(name)
				.age(age)
				.build();
	}
}
