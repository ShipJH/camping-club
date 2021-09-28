package com.cc.kr.api.reservation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

@ApiModel(value ="예약 모델")
@Builder
public class Reservation {

	@ApiModelProperty(value = "이름", required = true)
	public String name;
	
	@ApiModelProperty(value = "나이", required = true)
	public int age;
}
