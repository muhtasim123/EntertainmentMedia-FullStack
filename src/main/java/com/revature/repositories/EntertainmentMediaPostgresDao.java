package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.MediaNotFoundException;
//import com.revature.launcher.Entertainment720Launcher;
import com.revature.models.EntertainmentMedia;
import com.revature.models.Movie;
import com.revature.util.ConnectionFactory;

public class EntertainmentMediaPostgresDao implements EntertainmentMediaDAO{
	
	private ConnectionFactory cf = new ConnectionFactory(1);

	@Override
	public EntertainmentMedia updateEntertainmentMedia(EntertainmentMedia em) {
		return null;
	}
	
	@Override
	public List<EntertainmentMedia> findAll() {
		Connection conn = this.cf.getConnection();

		List<EntertainmentMedia> all = new ArrayList<EntertainmentMedia>();
		
		try {
			String sql = "select * from all_movies";	
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			
			while(res.next()) {
				Movie m = new Movie();
				m.setName(res.getString("Name"));
				m.setCopyrightOwner(res.getString("copyright_owner"));
				//m.setCredits((String[])((PgArray)res.getObject("credits")).getArray());
				m.setPrice(res.getDouble("price"));
				m.setRating(res.getInt("rating"));
				m.setRecommendedAgeRange(new int[] {res.getInt("min_age"), res.getInt("max_age")});
				m.setReleaseDate(res.getString("release_date"));
				all.add(m);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		//Entertainment720Launcher.e720Logger.info(all);
		return all;
	}

	@Override
	public EntertainmentMedia saveOne(EntertainmentMedia em) {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		try {
			String mediaSQL = "insert into \"media\" "  
						+ "(\"price\", \"type\", \"name\", \"copyright_owner\", \"release_date\", \"rating\", \"max_age\" , \"min_age\")"
						+ "values (?, ?, ?, ?, ?, ?, ?, ?) returning \"media_id\";";
			PreparedStatement insertMedia = conn.prepareStatement(mediaSQL);
			insertMedia.setDouble(1,  em.getPrice());
			insertMedia.setString(2,  em.getType());
			insertMedia.setString(3,  em.getName());
			insertMedia.setString(4,  em.getCopyrightOwner());
			insertMedia.setTimestamp(5, Timestamp.valueOf(em.getReleaseDate()));
			insertMedia.setInt(6,  em.getRating());
			insertMedia.setInt(7,  em.getRecommendedAgeRange()[1]);
			insertMedia.setInt(8, em.getRecommendedAgeRange()[0]);
			
			ResultSet res = insertMedia.executeQuery();
			int newId;
			if(res.next()) {
				newId = res.getInt("media_id");
			} else {
				throw new SQLException();
			}
			
			if(em.getClass() == Movie.class) {
				String movieSQL = "insert into movie (\"runtime\", \"main_media\")" + 
						  "		   values(?, ?);";
				PreparedStatement insertMovie = conn.prepareStatement(movieSQL);
				
				/*PreparedStatement insertCrew = conn.prepareStatement(crewSQL);
				PreparedStatement insertMovieCrew = conn.prepareStatement(movieCrewSQL);*/
			}
			
		} catch (SQLException e) {
			
		}
		return null;
	}

	@Override
	public EntertainmentMedia findEntertainmentMediaByName(String name) throws MediaNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
