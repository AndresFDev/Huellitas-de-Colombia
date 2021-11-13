import axios from "axios";
import { PROFILE_ENDPOINT } from "../helpers/endpoints";
import { SET_USUARIO_ACTUAL } from "./tipos";

export const obtenerDatosUsuario=()=>dispatch => {
    return new Promise((resolve, reject) => {
        axios.get(PROFILE_ENDPOINT)
            .then(response =>{
                dispatch({
                    type: SET_USUARIO_ACTUAL,
                    payload: {fetched: true, usuarios: response.data}
                })

                resolve(response)
            })
            .catch(err => {
                reject(err)
            })
    });
}