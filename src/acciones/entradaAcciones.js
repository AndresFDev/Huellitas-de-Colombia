import axios from "axios";
import { USUARIO_ENTRADAS_ENDPOINT } from "../helpers/endpoints";
import { SET_USUARIO_ENTRADAS } from "./tipos";

export const obetenerUsuarioEntradas=()=>dispatch => {
    return new Promise((resolve, reject) => {
        axios.get(USUARIO_ENTRADAS_ENDPOINT)
            .then(response =>{
                dispatch({
                    type: SET_USUARIO_ENTRADAS,
                    payload: {fetched: true, entradas: response.data}
                })

                resolve(response)
            })
            .catch(err => {
                reject(err)
            })
    });
}