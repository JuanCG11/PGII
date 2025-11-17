package co.edu.uniquindio.poo.proyectofinaluq.logistica.app;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.*;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.DisponibilidadRepartidor;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.EnvioRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.RepartidorRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.UsuarioRepository;

public class DataSeeder {
    public static void seed(UsuarioRepository uRepo, RepartidorRepository rRepo, EnvioRepository eRepo) {
        Usuario u1 = new Usuario("u1","Diego Perez","diego@example.com","3001112222", "diego300", RolUsuario.ADMIN);
        Direccion d1 = new Direccion("d1","Casa","Calle 1","CiudadX","0,0");
        u1.getDirecciones().add(d1);
        uRepo.save(u1);

        Repartidor r1 = new Repartidor("r1","Carlos Ruiz","123456","3100000000", DisponibilidadRepartidor.ACTIVO, "Zona Centro");
        rRepo.save(r1);

        // ejemplo: seed envio simple
        Paquete p = new Paquete(2.5, 20, 10, 5);
        Envio e1 = new Envio("e1", d1, d1, p);
        eRepo.save(e1);
    }
}
