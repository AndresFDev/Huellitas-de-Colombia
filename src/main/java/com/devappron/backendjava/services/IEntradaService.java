package com.devappron.backendjava.services;

import java.util.List;

import com.devappron.backendjava.shared.EntradaCrearDto;
import com.devappron.backendjava.shared.EntradaDto;
import com.devappron.backendjava.shared.EntradaActualizarDto;

public interface IEntradaService {

    public EntradaDto crearEntrada(EntradaCrearDto entradaCreacionDto);

    public List<EntradaDto> obtenerUltimos();

    public EntradaDto obtenerEntrada(String id);

    public void eliminarEntrada(String entradaId, long usuarioId);

    public EntradaDto actualizarEntrada(String entradaId, EntradaActualizarDto entradaActualizarDto);
    
}
