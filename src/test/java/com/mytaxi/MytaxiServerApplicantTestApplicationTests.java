package com.mytaxi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mytaxi.controller.DriverController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MytaxiServerApplicantTestApplication.class)
@WebMvcTest(DriverController.class)
public class MytaxiServerApplicantTestApplicationTests
{

	@Autowired
	private DriverController driverController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void isDriverControllerInitializedCorrectly()
    {
		assertThat(driverController).isNotNull();
    }
	
	@Test
	public void selectAnAvailableTaxiByAnOnlineDriver() throws Exception
	{
		mockMvc
				.perform(
						put(
								"/v1/drivers/4/drive?carId=100"
								))
				.andExpect(status().isOk());
	}
	
	@Test
	public void selectAnAvailableTaxiByAnOfflineDriver() throws Exception
	{
		mockMvc
				.perform(
						put(
								"/v1/drivers/1/drive?carId=101"
								))
				.andExpect(status().isBadRequest());
	}
	

}
