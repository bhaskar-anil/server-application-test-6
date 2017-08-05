package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.OnlineStatus;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "license_plate", columnNames = {"licenseplate"})
)
public class CarDO {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();
	
	@Column(nullable = false)
    @NotNull(message = "License plate of a car can not be null!")
    private String licensePlate;
	
	@Column(nullable = false)
    @NotNull(message = "Seat count in a car can not be null!")
    private Integer seatCount;
	
	@Column
	private String manufacturer;
	
	@Column(nullable = false)
    private Boolean isConvertible;
	
	@Column(nullable = false)
    private Boolean isAvailable;
	
	@Column
	private Integer rating;
	
	@Enumerated(EnumType.STRING)
    private EngineType engineType;
	
	@Column
    private Boolean deleted = false;
	
	@OneToOne(mappedBy = "car")
	private DriverDO driverDO;
	
	private CarDO(){		
	}
	
	public CarDO(String licensePlate, Integer seatCount){
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.manufacturer = null;
		this.isConvertible = false;
		this.isAvailable = true;
		this.rating = 0;
		this.engineType = null;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Boolean getIsConvertible() {
		return isConvertible;
	}

	public void setIsConvertible(Boolean isConvertible) {
		this.isConvertible = isConvertible;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
