package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
	
	@JsonIgnore
    private Long id;
	
	@NotNull(message = "License plate of a car can not be null!")
    private String licensePlate;
	
	@NotNull(message = "Seat count in a car can not be null!")
    private Integer seatCount;
		
	private CarDTO(){
	}
	
	public CarDTO(Long id, String licensePlate, Integer seatCount){
		this.id = id;
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
	}
	
	public static CarDTOBuilder newBuilder(){
		return new CarDTOBuilder();
	}
	
	@JsonProperty
    public Long getId()
    {
        return id;
    }
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public static class CarDTOBuilder{
		private Long id;
		private String licensePlate;
		private Integer seatCount;
		
		public CarDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		public CarDTOBuilder setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
			return this;
		}
		public CarDTOBuilder setSeatCount(Integer seatCount) {
			this.seatCount = seatCount;
			return this;
		}
		
		public CarDTO createCarDTO(){
			return new CarDTO(id, licensePlate, seatCount);
		}
	}

}
