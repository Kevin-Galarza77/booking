package keax_booking.keax_booking.Controller;

import jakarta.validation.Valid;
import keax_booking.keax_booking.Entity.BookingEntity;
import keax_booking.keax_booking.EntityDTO.ResponseDTO;
import keax_booking.keax_booking.IService.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<BookingEntity>>> all() {
        return bookingService.all();
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<BookingEntity>> create(@Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult) {
        return bookingService.create(bookingEntity, bindingResult);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<ResponseDTO<BookingEntity>> update(@PathVariable Long bookingId, @Valid @RequestBody BookingEntity bookingEntity, BindingResult bindingResult) {
        return bookingService.update(bookingId, bookingEntity, bindingResult);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<ResponseDTO<BookingEntity>> delete(@PathVariable Long bookingId) {
        return bookingService.delete(bookingId);
    }

}
