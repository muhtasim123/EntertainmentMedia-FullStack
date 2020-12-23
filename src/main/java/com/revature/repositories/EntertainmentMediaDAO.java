package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;

//DAO stands for Data Access Object
public interface EntertainmentMediaDAO {

	public EntertainmentMedia saveOne(EntertainmentMedia em);
	
	public EntertainmentMedia updateEntertainmentMedia(EntertainmentMedia em);
	
	public List<EntertainmentMedia> findAll();
	
	public EntertainmentMedia findEntertainmentMediaByName(String name) throws MediaNotFoundException;
}
