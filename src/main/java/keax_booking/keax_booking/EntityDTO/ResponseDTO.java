package keax_booking.keax_booking.EntityDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//ESTA CLASE SE USARA PARA RESPONDER EN FORMATO STATUS,ALERT,MESSEGES,DATA
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private String alert;
    private boolean status;
    private T data;
    private List<String> messages;

    public ResponseDTO(String alert, boolean status, T data) {
        this.data = data;
        this.alert = alert;
        this.status = status;
        this.messages = new ArrayList<String>();
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
