package simple.servicebroker.cf.haash.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.cloud.Cloud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import simple.servicebroker.cf.haash.haash.HashingService;
import simple.servicebroker.cf.haash.model.ServiceInstance;
import simple.servicebroker.cf.haash.repository.ServiceBindingRepository;
import simple.servicebroker.cf.haash.repository.ServiceInstanceRepository;
import simple.servicebroker.cf.haash.repository.ServiceRepository;

@RunWith(MockitoJUnitRunner.class)
public class ServiceBrokerControllerTest {

	@InjectMocks
	ServiceBrokerController serviceBrokerController;
	
	@Mock
    ServiceRepository serviceRepository;

	@Mock
    ServiceInstanceRepository serviceInstanceRepository;

	@Mock
    ServiceBindingRepository serviceBindingRepository;

	@Mock
    HashingService haashService;

	@Mock
    Cloud cloud;
	
	@Mock
	ServiceInstance serviceInstance;
	
	/*@Test
	public void catalogTest(){
		Map<String, Iterable<Service>> serviceDetails = serviceBrokerController.catalog();
		Iterable<Service> services = serviceDetails.get("services");
	}*/
	
	@Test
	public void createTest(){
		String id = "1001";
		when(serviceInstanceRepository.exists(id)).thenReturn(true);
		when(serviceInstanceRepository.findOne(id)).thenReturn(serviceInstance);
		when(serviceInstance.equals(serviceInstance)).thenReturn(true);
		ResponseEntity<String> actualResult = serviceBrokerController.create(id, serviceInstance);
		assertEquals(HttpStatus.OK, actualResult.getStatusCode().OK);
	}
}
