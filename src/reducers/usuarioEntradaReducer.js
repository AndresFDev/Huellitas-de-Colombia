import { SET_USUARIO_ENTRADAS } from "../acciones/tipos";

const estadoInicial = {entradas: [], fetched: false};

export default function usuarioEntradaReducer(estado = estadoInicial, accion) {

    const {type, payload} = accion;

    switch (type) {
        case SET_USUARIO_ENTRADAS:
            return{
                ...estado,
                fetched: payload.fetched,
                entradas: payload.entradas
            }
        default:
            return estado;
    }
}
