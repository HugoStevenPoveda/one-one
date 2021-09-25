package com.relationship.oneone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.oneone.Dao.AddressDao;
import com.relationship.oneone.entitys.Address;

@RestController
@RequestMapping("address")

public class ControllerAddress {

	@Autowired
	private AddressDao addressDao;

	@GetMapping
	public ResponseEntity<List<Address>> getAddresAll() {
		List<Address> lsAllAdress = addressDao.findAll();
		return ResponseEntity.ok(lsAllAdress);

	}

	@PostMapping
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		Address newAddress = addressDao.save(address);
		return ResponseEntity.ok(newAddress);

	}

	@PutMapping
	private ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		Optional<Address> pastAddress = addressDao.findById(address.getId());
		if (pastAddress.isPresent()) {
			Address addressUpdate = pastAddress.get();
			addressUpdate.setDescription(address.getDescription());
			addressUpdate.setEstadoEnvio(address.getEstadoEnvio());
			addressDao.save(addressUpdate);
			return ResponseEntity.ok(addressUpdate);

		}
		return ResponseEntity.noContent().build();

	}

	// TODO
	@DeleteMapping("{id}")
	public String deleteAddres(@PathVariable Long id) {
		if (addressDao.findById(id).isPresent()) {
			addressDao.deleteById(id);
			return "el address con id  " + id + "fue eliminado";

		}

		return "el address con id  " + id + "no existe";

	}

	@GetMapping("{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
		if (addressDao.findById(id).isPresent()) {
			return ResponseEntity.ok(addressDao.findById(id).get());

		}
		return ResponseEntity.noContent().build();

	}

}
