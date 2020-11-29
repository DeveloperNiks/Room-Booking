package com.roombooking.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooking.models.Room;
import com.roombooking.models.RoomRequest;
import com.roombooking.models.RoomResponse;
import com.roombooking.models.User;
import com.roombooking.repository.RoomRepository;
import com.roombooking.repository.UserRepository;

@Service
public class IBookingServiceImpl implements IBookingService {
	
	private UserRepository userRepository;
	
	private RoomRepository roomRepository;
	
	
    @Autowired
	public IBookingServiceImpl(UserRepository userRepository, RoomRepository roomRepository) {
		super();
		this.userRepository = userRepository;
		this.roomRepository = roomRepository;
	}



	@Override
	public RoomResponse bookRoom(RoomRequest roomRequest) {
		
		RoomResponse roomResponse = new RoomResponse();
		
		Optional<Room> optionalRoom = roomRepository.findById(roomRequest.getRoomId());
		Optional<User> optionalUser = userRepository.findById(roomRequest.getUserId());
		
		if(optionalRoom.isPresent() && optionalUser.isPresent()) {
			
			Room room = optionalRoom.get();
			User user = optionalUser.get();
		
		if(room.getRoomPrice() <= user.getUserPoints()) {
			room.setRoomStatus("BOOKED");
			user.setUserPoints(user.getUserPoints() - room.getRoomPrice());
			
		}
		else if(room.getRoomPrice() > user.getUserPoints()) {
			room.setRoomStatus("PENDING APPROVAL");
		}
		
		roomRepository.save(room);
		userRepository.save(user);
		
		roomResponse.setRoomId(room.getRoomId());
		roomResponse.setUserId(user.getUserId());
		roomResponse.setRoomStatus(room.getRoomStatus());
		
		}
		else {
			roomResponse.setError("Value does not exist");
		}
		
		return roomResponse;
	}



	@Override
	public List<User> findAllUsers() {
	  
	  List<User> userList = new ArrayList<>();
	  userRepository.findAll().forEach(userList :: add);
	  
	  return Collections.unmodifiableList(userList);
		
	}

}
