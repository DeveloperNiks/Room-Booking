package com.roombooking.models;

public class RoomResponse {

	private String roomId;
	private String userId;
	private String roomStatus;
	private String error;
	
	public RoomResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RoomResponse [roomId=" + roomId + ", userId=" + userId + ", roomStatus=" + roomStatus + ", error="
				+ error + "]";
	}
	
	
	
}
