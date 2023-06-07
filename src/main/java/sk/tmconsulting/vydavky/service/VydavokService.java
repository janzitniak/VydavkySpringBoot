package sk.tmconsulting.vydavky.service;

import sk.tmconsulting.vydavky.model.Vydavok;

import java.util.List;

public interface VydavokService {
    List<Vydavok> ziskajVsetkyVydavky();
    Vydavok ulozVydavok(Vydavok vydavokObjekt);
    Vydavok ziskajVydavokPodlaId(long id);
    Vydavok aktualizujVydavok(Vydavok vydavokObjekt);
    void odstranVydavokPodlaId(long id);
}
