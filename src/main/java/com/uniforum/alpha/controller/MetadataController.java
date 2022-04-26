package com.uniforum.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniforum.alpha.constant.AppConstants;
import com.uniforum.alpha.constant.AppConstants.MetadataApiConstants;
import com.uniforum.alpha.entity.TypeGroupRef;
import com.uniforum.alpha.service.IMetadataService;

@RestController
@RequestMapping(AppConstants.BASE_API+MetadataApiConstants.METADATA_CONTROLLER_BASE)
public class MetadataController {

	@Autowired
	private IMetadataService metadataService;
	
	@GetMapping(path = MetadataApiConstants.GET_TYPE_GROUP_REF, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TypeGroupRef>> getTypeGroupRefList() {
		
		return new ResponseEntity<List<TypeGroupRef>>(metadataService.getTypeGroupRefList(), HttpStatus.OK);
	}
}
