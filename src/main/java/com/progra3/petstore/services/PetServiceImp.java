package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progra3.petstore.Dao.PetDao;
import com.progra3.petstore.Exceptions.NotFoundException;
import com.progra3.petstore.entities.Pet;

@Service
public class PetServiceImp implements PetService{

	@Autowired
	private PetDao dao;
	
	@Override
	public List<Pet> listAll() {
		return (List<Pet>) dao.findAll();
	}

	@Override
	public Pet findById(Long id) {
		if(dao.existsById(id)) {
			Optional<Pet> ob = dao.findById(id);
			return ob.get();
		}else throw new NotFoundException("No se encontró la mascota en la base de datos");
	}

	@Override
	public Pet createPet(Pet pet) {
		dao.save(pet);
		return pet;
	}

	@Override
	public Pet updatePet(Long id, Pet pet) {
		if(dao.existsById(id)) {
			pet.setId(id);
			dao.save(pet);
		}else throw new NotFoundException("No se encontró la mascota en la base de datos");
		return pet;
	}

	@Override
	public void deletePet(Long id) {
		if(dao.existsById(id)) dao.deleteById(id);
		else throw new NotFoundException("No se encontró la mascota en la base de datos");
	}
}