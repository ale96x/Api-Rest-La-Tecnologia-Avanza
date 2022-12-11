package com.sistema.blog.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String nombreDelRescurso;
    private String nombreDelCampo;
    private long valorDelCampo;

    public ResourceNotFoundException(String nombreDelRescurso, String nombreDelCampo, long valorDelCampo){
        super(String.format("%s no encontrado con: %s : '%s'",nombreDelRescurso,nombreDelCampo,valorDelCampo));
        this.nombreDelCampo = nombreDelCampo;
        this.nombreDelRescurso = nombreDelRescurso;
        this.valorDelCampo = valorDelCampo;
    }
}
