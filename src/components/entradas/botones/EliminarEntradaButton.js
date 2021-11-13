import axios from 'axios'
import React from 'react'
import { Button } from 'react-bootstrap'
import { confirmAlert } from 'react-confirm-alert'
import { useDispatch } from 'react-redux'
import { toast } from 'react-toastify'
import { obetenerUsuarioEntradas } from '../../../acciones/entradaAcciones'
import { ELIMINAR_ENTRADA_ENDPOINT} from '../../../helpers/endpoints'

export default function EliminarEntradaButton({entradaId, nombreMascota}) {

    const dispatch= useDispatch();

    const crearAlerta=()=>{
        confirmAlert({
            title:"Eliminar Entrada",
            message:`¿Desea eliminar la entrada de ${nombreMascota}?`,
            buttons:[
                {
                    label:'si',
                    onClick:()=>{eliminarEntrada()}
                },
                {
                    label:'No',
                    onClick:()=>{return false;}
                }
                
            ]
        })
    }

    const eliminarEntrada = async()=>{
       try {
            await axios.delete(`${ELIMINAR_ENTRADA_ENDPOINT}/${entradaId}`);
            
            await dispatch(obetenerUsuarioEntradas());

            toast.info("La entrada se ha eliminado con exito", {
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
            className="m-1"
        >
            ELIMINAR
        </Button>
    )
}

