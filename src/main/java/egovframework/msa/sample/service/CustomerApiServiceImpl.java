package egovframework.msa.sample.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerApiServiceImpl implements CustomerApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getCustomerDetailFallback")
    public String getCustomerDetail(String customerId) {
        return restTemplate.getForObject("http://customer/customers/" + customerId, String.class);
//        return restTemplate.getForObject("http://localhost:8082/customers/" + customerId, String.class);
//        return customerId;
    }

    public String getCustomerDetailFallback(String customerId, Throwable ex) {
        System.out.println("Error: "+ ex.getMessage());
        return "고객정보 조회가 지연되고 있습니다.";
    }
}
