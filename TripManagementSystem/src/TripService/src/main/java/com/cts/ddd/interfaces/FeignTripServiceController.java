//package com.cts.ddd.interfaces;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.ddd.application.FeignUserService;
//import com.cts.ddd.domain.user.User;
//
//@RestController
//public class FeignTripServiceController {
//
//	@Autowired
//	private FeignUserService userService;
//	
//	
//	 @GetMapping(value="/feign/userDetails/get", headers="Accept=application/json")
//	public @ResponseBody Iterable<User> getAllUser() {	 
//		  return userService.getAllUser();
//		 }
//}
