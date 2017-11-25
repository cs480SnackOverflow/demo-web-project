package edu.csupomona.cs480.service;


import edu.csupomona.cs480.data.entity.Set;
import edu.csupomona.cs480.data.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    private SetRepository setRepository;

    @Autowired
    public void setSetRepository(SetRepository SetRepository) {
        this.setRepository = SetRepository;
    }

    @Override
    public List<Set> listAllSets() {
        return setRepository.findAll();
    }

    @Override
    public Set getSetById(Integer id) {
        return setRepository.findOne(id);
    }

    @Override
    public Set saveSet(Set Set) {
        return setRepository.save(Set);
    }

    @Override
    public void deleteSet(Integer id) {
        setRepository.delete(id);
    }

    @Override
    public List<Set> listAllSetsBySetId(String setId) {
        return setRepository.findBySetId(setId);
    }

    @Override
    public List<Set> listAllSetsByTitle(String title) {
        return setRepository.findByTitle(title);
    }

}
