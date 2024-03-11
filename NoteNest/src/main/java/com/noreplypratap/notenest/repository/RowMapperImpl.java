package com.noreplypratap.notenest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.noreplypratap.notenest.model.NoteNest;

public class RowMapperImpl implements RowMapper<NoteNest> {

	@Override
	public NoteNest mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoteNest note = new NoteNest();
        note.setId(rs.getInt("id"));
        note.setTitle(rs.getString("title"));
        note.setBody(rs.getString("body"));
        note.setTime(rs.getTimestamp("time"));
        return note;
	}

}
