package com.cts.ddd.application;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.ddd.domain.user.User;

@FeignClient(name = "auth-service")
public interface FeignUserService {

	@GetMapping(value = "/userDetails/get", headers = "Accept=application/json")
	public @ResponseBody Iterable<User> getAllUser();
}
