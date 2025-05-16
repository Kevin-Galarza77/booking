package keax_booking.keax_booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data //GENERA SETTER,GETTER Y CONTRUCTORES AUTOMATICAMENTE
@Entity//PERMITE A SPRING BOOT SABER Q ES UNA TABLA DE LA BDD
public class BookingEntity {

    @Id//ID DE LA BDD
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DECLARA AUTOINCREMENTAL EN LA BDD
    private Long bookingId;

    @NotBlank(message = "El nombre es requerido")//VALIDA EL CAMPO
    @Size(min = 2, max = 100, message = "El nombre del producto debe tener entre 2 y 100 caracteres")//VALIDA EL TAMANO DEL CAMPO
    private String name;

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 100, message = "El apellido del producto debe tener entre 2 y 100 caracteres")
    private String lastName;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo debe tener un formato válido")//VALIDA Q SEA EMAIL
    private String email;

    private boolean status = false;

    private boolean deleted = false;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
