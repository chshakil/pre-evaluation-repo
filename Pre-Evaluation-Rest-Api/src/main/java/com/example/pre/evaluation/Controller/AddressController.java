package com.example.pre.evaluation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pre.evaluation.model.Address;
import com.example.pre.evaluation.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService _addressService;

	@PostMapping("/save-address")
	public Address saveAddress(@RequestBody Address address) {
		return _addressService.createAddress(address);
	}

	@PostMapping("/add-address-list")
	public List<Address> saveAddressList(@RequestBody List<Address> addressList) {
		return _addressService.createAddresses(addressList);
	}

	@GetMapping("/get-address-list")
	public List<Address> getAllAddresses() {
		return _addressService.getAddressList();
	}

	@GetMapping("/get-addressBy-Id/{id}")
	public Address findAddressById(@PathVariable int id) {
		return _addressService.getAddressById(id);
	}

	@DeleteMapping("/delete-addressBy-id/{id}")
	public String deleteAddressById(@PathVariable int id) {
		return _addressService.deleteAddressById(id);
	}

	@PutMapping("/update-address")
	public Address upateAddress(@RequestBody Address address) {
		return _addressService.updateAddress(address);
	}

	@DeleteMapping("/delete-all-address")
	public String deleteAll() {
		_addressService.deleteAllAddressList();
		return "Successfully delete all entities";
	}
}
