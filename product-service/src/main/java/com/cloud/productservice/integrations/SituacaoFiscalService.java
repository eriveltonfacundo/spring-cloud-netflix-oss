package com.cloud.productservice.integrations;


import com.cloud.productservice.configs.FeignConfig;
import com.cloud.productservice.fallback.FiscalServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(configuration = FeignConfig.class, value = "fiscal-service", fallbackFactory = FiscalServiceFallbackFactory.class)
public interface SituacaoFiscalService {

    @RequestMapping("/fiscal-situations/{id}")
    boolean exists(@PathVariable("id") Long id);
}
