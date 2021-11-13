package com.devappron.backendjava.errors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.devappron.backendjava.models.respuestas.MensajeErrorModel;
import com.devappron.backendjava.models.respuestas.ValidacionErrores;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppManipuladorException {

  @ExceptionHandler(value = {UsuarioExisteException.class})
    public ResponseEntity<Object> handleUsuarioExisteException(UsuarioExisteException ex, WebRequest webRequest){

        MensajeErrorModel mensajeErrorModel = new MensajeErrorModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(mensajeErrorModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, 
                                                                            WebRequest webRequest){

        Map<String, String> errores=new HashMap<>();

        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            String nombreCampo=((FieldError) error).getField();
            String mensajeError= error.getDefaultMessage();
            errores.put(nombreCampo, mensajeError);
        }
        
        ValidacionErrores validacionErrores = new ValidacionErrores(errores, new Date());

        return new ResponseEntity<>(validacionErrores, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest){

        MensajeErrorModel mensajeErrorModel = new MensajeErrorModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(mensajeErrorModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}