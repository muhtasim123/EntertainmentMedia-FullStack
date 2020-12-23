package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.EntertainmentMedia;
import com.revature.repositories.EntertainmentMediaDAO;

public class EntertainmentMediaServiceImplementation implements EntertainmentMediaService{

	static Logger serviceLogger = LogManager.getLogger("com.revature.e720");
	private EntertainmentMediaDAO emd;
	
	public EntertainmentMediaServiceImplementation(EntertainmentMediaDAO emd) {
		this.emd = emd;
	}
	
	public List<EntertainmentMedia> seeAllMedia() {
		return emd.findAll();
	}

	@Override
	public void rateMedia(EntertainmentMedia em, int rating) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntertainmentMedia purchaseMedia(EntertainmentMedia em) {
		// TODO Auto-generated method stub
		serviceLogger.debug(em.getName() + " was purchased");
		System.out.println("Your purchased worked! " + em.getName());
		return null;
	}

}
