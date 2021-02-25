package egovframework.msa.sample.controller;

import egovframework.msa.sample.service.CustomerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogsController {

	@Autowired
	private CustomerApiService customerApiService;

	@GetMapping("/catalogs/customerinfo/{customerId}")
	public String getCustomerInfo(@PathVariable String customerId) {
		String customerInfo = customerApiService.getCustomerDetail(customerId);
		System.out.println("response customerInfo : " + customerInfo);
		return String.format("[Customer id = %s at %s %s ]", customerId, System.currentTimeMillis(), customerInfo);
	}
}
