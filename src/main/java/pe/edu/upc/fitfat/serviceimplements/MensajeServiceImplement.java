package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Mensaje;
import pe.edu.upc.fitfat.repositories.IMensajeRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajeRepository mR;

    @Override
    public List<Mensaje> list() {
        return mR.findAll();
    }

    @Override
    public void insert(Mensaje m) {
        mR.save(m);
    }

    @Override
    public Mensaje listId(int id) {
        return mR.findById(id).orElse(new Mensaje());
    }

    @Override
    public void update(Mensaje m) {
        mR.save(m);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<Mensaje> buscarxasunto(String asunto) {
        return mR.buscarxasunto(asunto);
    }

}
