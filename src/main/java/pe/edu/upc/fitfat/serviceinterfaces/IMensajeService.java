package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Mensaje;
import java.util.List;

public interface IMensajeService {
    public List<Mensaje> list();
    public void insert(Mensaje m);
    public Mensaje listId(int id);
    public void update(Mensaje m);
    public void delete(int id);
    public List<Mensaje> buscarxasunto(String asunto);
}
