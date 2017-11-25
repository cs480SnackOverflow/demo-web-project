package edu.csupomona.cs480.service;


import edu.csupomona.cs480.data.entity.Set;

import java.util.List;

public interface SetService {
	List<Set> listAllSets();
	Set getSetById(int id);
	Set saveSet(Set Set);
	void deleteSet(int id);
	List<Set> listAllSetsBySetId(String setId);
	List<Set> listAllSetsByTitle(String title);
}
