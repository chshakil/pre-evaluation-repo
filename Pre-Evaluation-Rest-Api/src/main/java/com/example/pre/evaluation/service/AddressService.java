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

	public Address getAddressBySudentId(int id) {
		return _addressRepository.findByStudentId(id).orElse(null);
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
		
		existingAddress.setPerStreet(address.getPerStreet());
		existingAddress.setPerPostOffice(address.getPerPostOffice());
		existingAddress.setPerUpazila(address.getPerUpazila());
		existingAddress.setPerDistrict(address.getPerDistrict());
		existingAddress.setPerDivision(address.getPerDivision());
		existingAddress.setPreStreet(address.getPreStreet());
		existingAddress.setPrePostOffice(address.getPrePostOffice());
		existingAddress.setPreUpazila(address.getPreUpazila());
		existingAddress.setPreDistrict(address.getPreDistrict());
		existingAddress.setPerDivision(address.getPerDivision());
		
		return _addressRepository.save(existingAddress);
	}
}
