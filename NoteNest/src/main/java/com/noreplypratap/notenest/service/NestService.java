package com.noreplypratap.notenest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noreplypratap.notenest.model.NoteNest;
import com.noreplypratap.notenest.repository.NestRepository;

@Service
public class NestService {
	
	@Autowired
	private NestRepository repo;

	public Boolean saveNote(NoteNest note) {
		if (repo.createNoteNest(note) > 0)
			return true;
		return false;
	}
	
	public List<NoteNest> getNotes() {
		return repo.readNoteNest();
	}
	
	public NoteNest getNotesById(int id) {
		return repo.readNoteNestById(id);
	}
	
	public Boolean deleteNote(int id) {
		if (repo.deleteNoteNest(id) > 0)
			return true;
		return false;
	}
	
	public Boolean updateNote(NoteNest note) {
		if (repo.updateNoteNest(note) > 0)
			return true;
		return false;
	}
}
