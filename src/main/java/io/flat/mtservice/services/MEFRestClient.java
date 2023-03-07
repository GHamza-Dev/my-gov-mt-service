package io.flat.mtservice.services;

import io.flat.mtservice.transaction.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MEF-SERVICE")
public interface MEFRestClient {

    @PostMapping("/mef/transactions")
    ResponseEntity create(@RequestBody TransactionDto transactionDto);
}
