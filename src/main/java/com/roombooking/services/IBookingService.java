package com.roombooking.services;



import java.util.List;

import com.roombooking.models.RoomRequest;
import com.roombooking.models.RoomResponse;
import com.roombooking.models.User;


public interface IBookingService {
	
	RoomResponse bookRoom(RoomRequest roomRequest);

	List<User> findAllUsers();

}
