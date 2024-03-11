package com.noreplypratap.notenest.model;

import java.sql.Timestamp;

public class NoteNest {
	
	int id;
	String title;
	String body;
	Timestamp time;
	
	
	
	
	
	public NoteNest(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}


	public NoteNest(int id, String title, String body, Timestamp time) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.time = time;
	}
	

	@Override
	public String toString() {
		return "NoteNest [id=" + id + ", title=" + title + ", body=" + body + ", time=" + time + "]";
	}

	public NoteNest() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

	
	
}
