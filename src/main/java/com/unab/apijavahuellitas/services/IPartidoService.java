package com.unab.apijavahuellitas.services;

import java.util.List;

import com.unab.apijavahuellitas.shared.PartidoActualizarDTO;
import com.unab.apijavahuellitas.shared.PartidoCrearDTO;
import com.unab.apijavahuellitas.shared.PartidoDTO;

public interface IPartidoService {

    public PartidoDTO crearPartido(PartidoCrearDTO partidoCreacionDto);

    public List<PartidoDTO> obtenerUltimos();

    public PartidoDTO obtenerPartido(String id);

    public void eliminarPartido(String partidoId, long usuarioId);

    public PartidoDTO actualizarPartido(String partidoId, PartidoActualizarDTO partidoActualizarDto);
    
}
