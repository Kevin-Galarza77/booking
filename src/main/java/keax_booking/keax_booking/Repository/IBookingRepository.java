package keax_booking.keax_booking.Repository;

import keax_booking.keax_booking.Entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingEntity, Long> {

    //SE USA PARA DECLARAR METODOS DE BUSQUEDA POR ATRIBUTOS ADICIONALES O TAMBIEN SE PUEDE USAR SINTAXIS SQL DIRECTA
    List<BookingEntity> findByDeleted(boolean deleted);

}
