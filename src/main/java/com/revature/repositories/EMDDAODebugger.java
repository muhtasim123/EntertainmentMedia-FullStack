package com.revature.repositories;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;

public class EMDDAODebugger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntertainmentMediaDAO emd = new EntertainmentMediaMemoryDao();
		
		List<EntertainmentMedia> catalogue = emd.findAll();
		
		for(EntertainmentMedia em : catalogue) {
			System.out.println(em);
		}
		
		try {
			EntertainmentMedia hp3 = emd.findEntertainmentMediaByName("HotFuzz");
			System.out.println("Found it ! : " + hp3);
		} catch (MediaNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<EntertainmentMedia> setCat = new TreeSet<>(catalogue);
		
		for(EntertainmentMedia em : setCat) {
			System.out.println(em);
		}
	}

}
