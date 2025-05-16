package keax_booking.keax_booking.ImpService;

import jakarta.validation.Valid;
import keax_booking.keax_booking.Entity.BookingEntity;
import keax_booking.keax_booking.EntityDTO.ResponseDTO;
import keax_booking.keax_booking.IService.IBookingService;
import keax_booking.keax_booking.Repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingRepository bookingRepository;

    public ResponseEntity<ResponseDTO<List<BookingEntity>>> all() {

        ResponseDTO<List<BookingEntity>> response = new ResponseDTO<>("No se han encontrado las reservas", false, null);

        try {
            List<BookingEntity> bookings = bookingRepository.findByDeleted(false);

            if (!bookings.isEmpty()) {
                response = new ResponseDTO<>("Se han encontrado las reservas",true, bookings);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ResponseDTO<BookingEntity>> create(@Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult) {

        ResponseDTO<BookingEntity> response = new ResponseDTO<>("No se pudo crear la reserva", false, bookingEntity);

        try {
            List<String> errors = validateBindingResult(bindingResult);

            if (!errors.isEmpty()) {
                response.setMessages(errors);
            } else {
                BookingEntity saved = bookingRepository.save(bookingEntity);
                response = new ResponseDTO<>("Se creo correctamente la reserva", true, saved);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ResponseDTO<BookingEntity>> update(@PathVariable Long bookingId, @Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult) {

        ResponseDTO<BookingEntity> response = new ResponseDTO<>("No se pudo actualizar la reserva", false, bookingEntity);

        try {
            List<String> errors = validateBindingResult(bindingResult);

            if (!errors.isEmpty()) {
                response.setMessages(errors);
            } else {

                Optional<BookingEntity> search = bookingRepository.findById(bookingId);

                if (search.isPresent()) {
                    bookingEntity.setBookingId(bookingId);
                    BookingEntity update = bookingRepository.save(bookingEntity);
                    response = new ResponseDTO<>("Se actualizar la reserva", true, update);
                } else {
                    response.getMessages().add("No se ha encontrado la reserva");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ResponseDTO<BookingEntity>> delete(@PathVariable Long bookingId) {

        ResponseDTO<BookingEntity> response = new ResponseDTO<>("No se pudo eliminar la reserva", false, null);

        try {

            Optional<BookingEntity> search = bookingRepository.findById(bookingId);

            if (search.isPresent()) {
                BookingEntity present = search.get();
                present.setDeleted(true);
                bookingRepository.save(present);
                response = new ResponseDTO<>("Se elimina la reserva", true, null);
            } else {
                response.getMessages().add("No se ha encontrado la reserva");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    private List<String> validateBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
    }

}
