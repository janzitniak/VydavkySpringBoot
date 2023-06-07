package sk.tmconsulting.vydavky.service;

import sk.tmconsulting.vydavky.model.Vydavok;
import sk.tmconsulting.vydavky.repository.VydavokRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotacia sluzby, ktora "sprevadzkuje" sluzby databazy
// Implementacia CRUD operacii. Kostru mame ulozenu vo VydavokService
public class VydavokService implements IVydavokService {
    private VydavokRepository vydavokRepository;

    public VydavokService(VydavokRepository vydavokRepository) {
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
