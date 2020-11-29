/**
 * 
 */
package com.roombooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;





@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message = "Room Id can not be empty")
	private String roomId;

	@NotNull
	private Float roomPrice;

	@NotNull
	private String roomStatus;

	public Room() {

	}

	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Float getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Float roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomPrice=" + roomPrice + ", roomStatus=" + roomStatus + "]";
	}


}
