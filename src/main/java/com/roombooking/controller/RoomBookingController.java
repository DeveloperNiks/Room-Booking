package com.roombooking.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.roombooking.models.RoomRequest;
import com.roombooking.models.RoomResponse;
import com.roombooking.models.User;
import com.roombooking.services.IBookingService;

@RestController
@RequestMapping("/v1/booking")
public class RoomBookingController {
	
	private IBookingService bookingService;
	 
	@Autowired
	public RoomBookingController(IBookingService bookingService) {
		this.bookingService = bookingService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> findllUsers (){
		
		return new ResponseEntity<List<User>>(bookingService.findAllUsers(), HttpStatus.OK);
	}
	

	@PostMapping("{userId}/book/{roomId}")
	public ResponseEntity<RoomResponse> bookRoom (@PathVariable("userId")String userId,
												  @PathVariable("roomId")String roomId){
		
		RoomRequest roomRequest = new RoomRequest();
		roomRequest.setRoomId(roomId);
		roomRequest.setUserId(userId);
		
		RoomResponse roomResponse = bookingService.bookRoom(roomRequest);
		
		if (Objects.isNull(roomResponse)) {
			return new ResponseEntity<RoomResponse>(roomResponse, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RoomResponse>(roomResponse, HttpStatus.OK);

		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult()
	        .getAllErrors().stream()
	        .map(ObjectError::getDefaultMessage)
	        .collect(Collectors.toList());
	}
	
	
}
