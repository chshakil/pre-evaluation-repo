package com.example.pre.evaluation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pre.evaluation.model.Address;
import com.example.pre.evaluation.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository _addressRepository;

	public Address createAddress(Address address) {
		return _addressRepository.save(address);
	}

	public List<Address> createAddresses(List<Address> addressList) {
		return _addressRepository.saveAll(addressList);
	}

	public List<Address> getAddressList() {
		return _addressRepository.findAll();
	}

	public Address getAddressById(int id) {
		return _addressRepository.findById(id).orElse(null);
	}

	public String deleteAddressById(int id) {
		_addressRepository.deleteById(id);
		return "address removed !!" + id;
	}

	public void deleteAllAddressList() {
		_addressRepository.deleteAll();
	}

	public Address updateAddress(Address address) {
		Address existingAddress = _addressRepository.findById(address.getId()).orElse(null);
		
		existingAddress.setPre_street(address.getPre_street());
		existingAddress.setPre_po(address.getPre_po());
		existingAddress.setPre_upa(address.getPre_upa());
		existingAddress.setPre_dist(address.getPre_dist());
		existingAddress.setPre_div(address.getPre_div());
		existingAddress.setPer_street(address.getPer_street());
		existingAddress.setPer_po(address.getPer_po());
		existingAddress.setPer_upa(address.getPer_upa());
		existingAddress.setPer_dist(address.getPer_dist());
		existingAddress.setPer_div(address.getPer_div());
		
		return _addressRepository.save(existingAddress);
	}
}
