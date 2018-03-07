package com.cloud.productservice.fallback;

import com.cloud.productservice.integrations.SituacaoFiscalService;
import feign.hystrix.FallbackFactory;

public class FiscalServiceFallbackFactory implements FallbackFactory<SituacaoFiscalService> {
    @Override
    public SituacaoFiscalService create(Throwable cause) {
        return new SituacaoFiscalService() {
            @Override
            public boolean exists(Long id) {
                return false;
            }
        };
    }
}
