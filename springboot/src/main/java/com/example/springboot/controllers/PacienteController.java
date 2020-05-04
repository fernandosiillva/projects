package com.example.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.models.Paciente;
import com.example.springboot.repositories.PacienteRepository;

@RestController
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	public ResponseEntity<List<Paciente>> getAllPacientes(){		
		List<Paciente> pacienteList = pacienteRepository.findAll();		
		if (pacienteList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Paciente>>(pacienteList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> getOnePaciente(@PathVariable(value="id") long id){		
		Optional<Paciente> paciente = pacienteRepository.findById(id);		
		if (!paciente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Paciente>(paciente.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/pacientes")
	public ResponseEntity<Paciente> savePaciente(@RequestBody @Valid Paciente paciente){
		return new ResponseEntity<Paciente>(pacienteRepository.save(paciente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/pacientes/{id}")
	public ResponseEntity<?> deletePaciente(@PathVariable(value="id") long id){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if (!paciente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pacienteRepository.delete(paciente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable(value = "id") long id,
			@RequestBody @Valid Paciente pacienteModel){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if (!paciente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pacienteModel.setId(paciente.get().getId());
			return new ResponseEntity<Paciente>(pacienteRepository.save(pacienteModel), HttpStatus.OK);
		}
	}
}
