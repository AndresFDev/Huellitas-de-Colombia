import axios from "axios";
import { USUARIO_PARTIDOS_ENDPOINT } from "../connection/helpers/endpoints";
import { SET_USUARIO_PARTIDOS } from "../reducers/tipos";

export const obetenerUsuarioPartidos=()=>dispatch => {
    return new Promise((resolve, reject) => {
        axios.get(USUARIO_PARTIDOS_ENDPOINT)
            .then(response =>{
                dispatch({
                    type: SET_USUARIO_PARTIDOS,
                    payload: {fetched: true, partidos: response.data}
                })

                resolve(response)
            })
            .catch(err => {
                reject(err)
            })
    });
}


