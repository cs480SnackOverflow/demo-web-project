package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.SetMetadata;
import edu.csupomona.cs480.data.repository.SetMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetMetadataServiceImpl implements SetMetadataService {

	private SetMetadataRepository setMetadataRepository;

	@Autowired
	public void setMetadataRepository(SetMetadataRepository setMetadataRepository) {
		this.setMetadataRepository = setMetadataRepository;
	}

	@Override
	public Iterable<SetMetadata> listAllSetMetadatas() {
		return setMetadataRepository.findAll();
	}

	@Override
	public SetMetadata getSetMetadataById(Integer setId) {
		return setMetadataRepository.findOne(setId);
	}

	@Override
	public SetMetadata saveSetMetadata(SetMetadata setMetadata) {
		return setMetadataRepository.save(setMetadata);
	}

	@Override
	public void deleteSetMetadata(Integer setId) {
		setMetadataRepository.delete(setId);
	}

	@Override
	public List<SetMetadata> listAllSetMetadatasByName(String name) {
		return setMetadataRepository.findByName(name);
	}

	@Override
	public List<SetMetadata> listAllSetMetadatasByUserId(String userId) {
		return setMetadataRepository.findByUserId(userId);
	}
}
