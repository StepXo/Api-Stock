package com.BootcampPragma.Api_Stock.infrastructure.Feign;


import com.BootcampPragma.Api_Stock.domain.spi.TransactionFeignPort;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ApiTransaction", url = "http://localhost:9092/transaction",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ITransactionFeign extends TransactionFeignPort {
    @Override
    default String getDate(long id){
        return checkDate(id).getBody();
    }

    @GetMapping("/date")
    ResponseEntity<String> checkDate(
            @RequestParam long id
    );

}
