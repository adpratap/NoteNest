package com.noreplypratap.notenest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.noreplypratap.notenest.model.NoteNest;

@Repository
public class NestRepository {

	@Autowired
	private JdbcTemplate db;
	
	// Create
	public int createNoteNest(NoteNest note) {
		String q = "INSERT INTO NoteNest(title,body) values (?,?)";
		return db.update(q,note.getTitle(),note.getBody());	
	}
	
	// Read
	public List<NoteNest> readNoteNest() {
		String q = "SELECT * from NoteNest";
		//return db.query(q,new BeanPropertyRowMapper<>(NoteNest.class));
		return db.query(q, new RowMapperImpl());
	}
	
	public NoteNest readNoteNestById(int id) {
		String q = "SELECT * from NoteNest where id = ?";
		//return db.queryForObject(q, new BeanPropertyRowMapper<>(NoteNest.class) , id);
		return db.queryForObject(q, new RowMapperImpl() , id);
	}
	
	// Update
	public int updateNoteNest(NoteNest note) {
		String q = "UPDATE NoteNest SET title = ? , body = ? where id = ? ";
		return db.update(q,note.getTitle(),note.getBody(),note.getId());
	}
	
	
	// Delete
	public int deleteNoteNest(int id) {
		String q = "DELETE from NoteNest where id = ?";
		return db.update(q,id);
	}
	
}
