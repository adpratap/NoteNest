package com.noreplypratap.notenest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.noreplypratap.notenest.model.NoteNest;
import com.noreplypratap.notenest.service.NestService;

@Controller
public class NestController {
	
	@Autowired
	private NestService service;
	
	// Home
	@GetMapping("/")
	public String getNoteNest(Model model) {
		model.addAttribute("list",service.getNotes());
		return "home";
	}
	
	// Add Note page
	@GetMapping("/add")
	public String saveNoteNest() {
		return "add";
	}
	
	@GetMapping("/update/{id}")
	public String updateNoteNest(@PathVariable int id, Model model) {
		model.addAttribute("note",service.getNotesById(id));
		return "update";
	}
	
	@PostMapping("/update")
	public String updateNote(@ModelAttribute NoteNest note, RedirectAttributes attribute) {
		attribute.addFlashAttribute("status", service.updateNote(note));
		return "redirect:/";
	}
	
	@PostMapping("/save")
	public String getById(@ModelAttribute NoteNest note, RedirectAttributes attribute) {
		attribute.addFlashAttribute("status",service.saveNote(note));
		return "redirect:/";
	}

	// Delete
	@GetMapping("/delete/{id}")
	public String deleteNoteNest(@PathVariable int id, RedirectAttributes attribute) {
		attribute.addFlashAttribute("status",service.deleteNote(id));
		return "redirect:/";
	}
}
