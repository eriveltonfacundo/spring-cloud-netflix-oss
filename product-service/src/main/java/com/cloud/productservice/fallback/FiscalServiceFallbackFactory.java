package com.cloud.productservice.fallback;

import com.cloud.productservice.entities.SituacaoFiscal;
import com.cloud.productservice.integrations.SituacaoFiscalService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FiscalServiceFallbackFactory implements FallbackFactory<SituacaoFiscalService> {
    @Override
    public SituacaoFiscalService create(Throwable cause) {
        return new SituacaoFiscalService() {
            @Override
            public SituacaoFiscal findById(Long id) {
                System.out.println(cause.getMessage());
                return null;
            }
        };
    }
}
