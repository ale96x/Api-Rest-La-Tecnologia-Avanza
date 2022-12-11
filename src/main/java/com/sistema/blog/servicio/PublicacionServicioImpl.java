package com.sistema.blog.servicio;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.entidades.Publicacion;
import com.sistema.blog.repositorio.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class PublicacionServicioImpl implements PublicacionServicio{

    @Autowired
    private PublicacionRepositorio repositorio;

    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {
        //Se mapea el Dto con la entidad
        Publicacion publicacion = new Publicacion(); //
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setContenido(publicacionDTO.getContenido());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());

        Publicacion nuevaPubliacion = repositorio.save(publicacion); //Se guarda en la base de datos la publicacion

        //Convertimos de entidad a Dto
        PublicacionDTO publicacionRespuesta = new PublicacionDTO();
        publicacionRespuesta.setId(nuevaPubliacion.getId());
        publicacionRespuesta.setTitulo(nuevaPubliacion.getTitulo());
        publicacionRespuesta.setContenido(nuevaPubliacion.getContenido());
        publicacionRespuesta.setDescripcion(nuevaPubliacion.getDescripcion());

        return publicacionRespuesta;
    }

    @Override
    public List<PublicacionDTO> obtenerTodasLasPublicaciones() {
        List<Publicacion> publicaciones = repositorio.findAll();
        return publicaciones.stream()
                .map()
    }
}
