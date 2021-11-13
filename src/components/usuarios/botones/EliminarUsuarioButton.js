import axios from 'axios'
import React from 'react'
import { Button } from 'react-bootstrap'
import { confirmAlert } from 'react-confirm-alert'
import { useDispatch } from 'react-redux'
import { toast } from 'react-toastify'
import { ELIMINAR_USUARIOS_ENDPOINT } from '../../../helpers/endpoints'

export default function EliminarUsuarioButton({userId, nombre, userName, email, phone}) {

    const dispatch= useDispatch();

    const crearAlerta=()=>{
        confirmAlert({
            title:"Eliminar Usuario",
            message:`¿Desea eliminar la cuenta usuario ${userName}?`,
            buttons:[
                {
                    label:'si',
                    onClick:()=>{eliminarUsuario()}
                },
                {
                    label:'No',
                    onClick:()=>{return false;}
                }
                
            ]
        })
    }

    const eliminarUsuario= async()=>{
       try {
            await axios.delete(`${ELIMINAR_USUARIOS_ENDPOINT}/${userId}`);
            
            await dispatch(obetenerUsuarioUsuarios());

            toast.info("El usuario se ha eliminado con exito", {
                position: toast.POSITION.BOTTOM_CENTER, autoClose: 2000
            });
       } catch (error) {
            toast.error(error.response.data.mensage, {
                position: toast.POSITION.BOTTOM_CENTER, autoClose: 2000
            });
       }
    }

    return (
        <Button 
            variant="primary" size="sm"
            onClick={crearAlerta}
        >
            Eliminar
        </Button>
    )
}

