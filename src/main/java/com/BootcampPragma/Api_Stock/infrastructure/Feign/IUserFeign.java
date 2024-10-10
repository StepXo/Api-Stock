package com.BootcampPragma.Api_Stock.infrastructure.Feign;


import com.BootcampPragma.Api_Stock.application.dto.UserResponse;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = InfraConstants.USER_API, url = "${user.api.url}",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface IUserFeign {

    @GetMapping(value = InfraConstants.ID_PATH,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    UserResponse getUserById(@PathVariable String id);

}
