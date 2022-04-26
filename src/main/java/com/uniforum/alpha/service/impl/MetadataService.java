package com.uniforum.alpha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniforum.alpha.entity.TypeGroupRef;
import com.uniforum.alpha.repository.TypeGroupRefRepository;
import com.uniforum.alpha.service.IMetadataService;

@Service
public class MetadataService implements IMetadataService {

	@Autowired
	private TypeGroupRefRepository typeGroupRefRepository;
	
	@Override
	public List<TypeGroupRef> getTypeGroupRefList() {
		return typeGroupRefRepository.findAll();
	}

}
