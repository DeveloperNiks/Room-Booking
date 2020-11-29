package com.roombooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roombooking.models.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
