package net.javaguides.helloworld.service;

import net.javaguides.helloworld.model.Vydavok;
import net.javaguides.helloworld.repository.VydavokRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // anotocia sluzby, ktora bude "sprevadzkuje" sluzby databazy
// Implementacia CRUD operacii. Kostru mame ulozenu vo VydavokService
public class VydavokServiceImpl implements VydavokService {
    private VydavokRepository vydavokRepository;

    public VydavokServiceImpl(VydavokRepository vydavokRepository) {
        this.vydavokRepository = vydavokRepository;
    }

    @Override
    public List<Vydavok> ziskajVsetkyVydavky() {
        return vydavokRepository.findAll();
    }

    @Override
    public Vydavok ulozVydavok(Vydavok vydavokObjekt) {
        return vydavokRepository.save(vydavokObjekt);
    }

    @Override
    public Vydavok ziskajVydavokPodlaId(long id) {
        return vydavokRepository.findById(id).get();
    }

    @Override
    public Vydavok aktualizujVydavok(Vydavok vydavokObjekt) {
        return vydavokRepository.save(vydavokObjekt);
    }

    @Override
    public void odstranVydavokPodlaId(long id) {
        vydavokRepository.deleteById(id);
    }


}
