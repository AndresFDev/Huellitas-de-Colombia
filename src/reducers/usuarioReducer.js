import { SET_USUARIO } from "../acciones/tipos";

const estadoInicial = {usuarios: [], fetched: false};

export default function usuarioReducer(estado = estadoInicial, accion) {

    const {type, payload} = accion;

    switch (type) {
        case SET_USUARIO:
            return{
                ...estado,
                fetched: payload.fetched,
                usuarios: payload.usuarios
            }
        default:
            return estado;
    }
}