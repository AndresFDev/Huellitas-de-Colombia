import React, { useState } from 'react'
import { Alert, Container } from 'react-bootstrap'
import { useHistory } from 'react-router-dom'
import validator from 'validator'
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import axios from 'axios';
import { CREAR_ENTRADA_ENDPOINT } from '../helpers/endpoints';
import { toast } from 'react-toastify';
import { useDispatch } from 'react-redux';
import { obetenerUsuarioEntradas } from '../acciones/entradaAcciones';
import NuevoEntradaFormulario from '../components/formularios/NuevoEntradaFormulario';

export default function NuevoeEntrada() {

    const [errores, setErrores] = useState({});
    const history = useHistory();
    const dispatch = useDispatch()

    const crearEntrada =  async({fecha, estatus, tipo, nombreMascota, raza, descripcion, direccion, nombreDueno, phoneDueno, ciudadCiudades}) => {
        const errores={};
        setErrores(errores);

        if(!validator.isDate(fecha)){
            errores.fecha= "Fecha invalida"
        }

        if(validator.isEmpty(estatus)){
            errores.estatus = "Debe seleccionar el estado de la mascota"
        }

        if(validator.isEmpty(tipo)){
            errores.tipo = "Debe seleccionar un tipo de mascota"
        }

        if(validator.isEmpty(nombreMascota)){
            errores.nombreMascota = "El nombre de la mascota no puede estar vacio"
        }

        if(validator.isEmpty(raza)){
            errores.raza = "La raza no puede estar vacia"
        }

        if(validator.isEmpty(descripcion)){
            errores.descripcion = "La descripción de la mascota no puede estar vacio"
        }

        if(validator.isEmpty(direccion)){
            errores.direccion = "El dirección no puede estar vacio"
        }

        if(validator.isEmpty(nombreDueno)){
            errores.nombreDueno = "El nombre de usuario no puede estar vacio"
        }

        if(validator.isEmpty(phoneDueno)){
            errores.phoneDueno = "El teléfono de contacto no puede estar vacio"
        }else{
            if(!validator.isLength(phoneDueno, {min:10, max:10})){
                errores.phoneDueno = "ERROR. La teléfono debe tener 10 números";
            }
        }

        if(validator.isEmpty(ciudadCiudades)){
            errores.ciudadCiudades = "Debe seleccionar una ciudad"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        try {
            const response = await axios.post(CREAR_ENTRADA_ENDPOINT, {fecha, estatus, tipo, nombreMascota, raza, descripcion, direccion, nombreDueno, phoneDueno, ciudadCiudades});
            await dispatch(obetenerUsuarioEntradas());
            toast.info("Entrada creada con exito", {
                position: toast.POSITION.BOTTOM_CENTER,
                autoClose: 2000
            });
            history.push(`/entradas/${response.data.entradaId}`);
        } catch (error) {
            setErrores({
                nuevoEntrada:error.response.data.message
            });
        }
        
    }

    return (

        <Container className="margen-t margen-b">
            <div className="flex-container">
                <div classname="flex-container">
                    {errores.nuevoEntrada && <Alert variant="danger">{errores.nuevoEntrada}</Alert>}
                    <div className="flex-container">
                        <div id="title_2" className="flex-container">
                            <div id="title_in" className="flex-container col-12">
                                <h3 className="pt-2">CREAR ENTRADA</h3>
                            </div>
                        </div>
                    </div> 
                    <NuevoEntradaFormulario errores={errores} enviarCallback={crearEntrada} editar={false}></NuevoEntradaFormulario>
                </div>
            </div>
        </Container>
    )
}

