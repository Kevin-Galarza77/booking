package keax_booking.keax_booking.IService;

import jakarta.validation.Valid;
import keax_booking.keax_booking.Entity.BookingEntity;
import keax_booking.keax_booking.EntityDTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBookingService {

    //SE DECLARAN LOS METODOS QUE SE VAN A USAR EN EL SERVICIO DE ESTE MODELO
    public ResponseEntity<ResponseDTO<List<BookingEntity>>> all() ;

    public ResponseEntity<ResponseDTO<BookingEntity>> create(@Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult);

    public ResponseEntity<ResponseDTO<BookingEntity>> update(@PathVariable Long bookingId, @Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult) ;

    public ResponseEntity<ResponseDTO<BookingEntity>> delete(@PathVariable Long bookingId) ;

}
