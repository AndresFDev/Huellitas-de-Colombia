import React, { useEffect, useState } from 'react'
import { Alert, Col, Container, Row } from 'react-bootstrap'
import { useHistory, useParams } from 'react-router-dom'
import validator from 'validator'
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import axios from 'axios';
import { ACTUALIZAR_ENTRADA_ENDPOINT, ENTRADA_DETALLES_ENDPOINT } from '../helpers/endpoints';
import { toast } from 'react-toastify';
import { useDispatch } from 'react-redux';
import NuevoEntradaFormulario from '../components/formularios/NuevoEntradaFormulario';
import { obetenerUsuarioEntradas } from '../acciones/entradaAcciones';

export default function EditarEntrada() {

    const {id} = useParams();
    const [errores, setErrores]= useState({});
    const [entrada, setEntrada]= useState(null);
    const history=useHistory();
    const dispatch= useDispatch();

    useEffect(() =>{
        axios.get(`${ENTRADA_DETALLES_ENDPOINT}/${id}`).then(response=>{
            setEntrada(response.data);
        }).catch(error =>{
            history.push('/')
        })        
    }, [id, history]);

    const editarEntrada = async({estatus, nombreMascota, descripcion, raza, direccion, nombreDueno, phoneDueno}) => {
        const errores={};
        setErrores(errores);

        if(validator.isEmpty(nombreDueno)){
            errores.nombreDueno= "El nombre de la persona no puede estar vacio"
        }

        if(validator.isEmpty(nombreMascota)){
            errores.nombreMascota= "El nombre de la mascota no puede estar vacio"
        }

        if(validator.isEmpty(direccion)){
            errores.direccion= "Debe suministrar la dirección del evento"
        }

        if(validator.isEmpty(phoneDueno)){
            errores.phoneDueno= "El teléfono de contacto no puede estar vacio"
        }else{
            if(!validator.isLength(phoneDueno, {min:10, max:10})){
                errores.phoneDueno = "ERROR. El telefono debe tener 10 números";
            }
        }

        if(validator.isEmpty(descripcion)){
            errores.descripcion= "La descripción no puede estar vacia"
        }

        if(validator.isEmpty(estatus)){
            errores.estatus= "Debe seleccionar un estado"
        }

        if(validator.isEmpty(raza)){
            errores.raza = "La raza no puede estar vacia"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        try {
            const response = await axios.put(`${ACTUALIZAR_ENTRADA_ENDPOINT}/${entrada.entradaId}`, {estatus, nombreMascota, descripcion, raza, direccion, nombreDueno, phoneDueno});
            
            await dispatch(obetenerUsuarioEntradas());
            toast.info("Entrada actualizada con exito", {
                position: toast.POSITION.BOTTOM_CENTER,
                autoClose: 2000
            });
            history.push(`/entradas/${response.data.entradaId}`);
        } catch (error) {
            setErrores({
                editarEntrada:error.response.data.message
            });
        }
        
    }

    return (

        <Container className="margen-t margen-b">
            <Row>
                <Col sm="12" lg={{span:10, offset:1}} >
                    <div >
                        {errores.editarEntrada && <Alert variant="danger">{errores.editarEntrada}</Alert>}
                        
                        <div className="flex-container">
                            <div id="title_2" className="flex-container">
                                <div id="title_in" className="flex-container col-12">
                                    <h3 className="pt-3">EDITAR ENTRADA</h3>
                                </div>
                            </div>
                        </div>
                        { entrada && 
                        <div className="flex-container">
                            <NuevoEntradaFormulario 
                                errores={errores} 
                                enviarCallback={editarEntrada}
                                eFecha={entrada.createdAt}
                                eNombreCiudades={entrada.ciudadRestModelCiudades.nombre}
                                eIdCiudad={entrada.ciudadRestModelCiudades.id}
                                eNombreDueno={entrada.nombreDueno}
                                eNombreMascota={entrada.nombreMascota}
                                eDireccion={entrada.direccion}
                                ePhoneDueno={entrada.phoneDueno}
                                eDescripcion={entrada.descripcion}
                                eEstatus={entrada.estatus}
                                eTipo={entrada.tipo}
                                eRaza={entrada.raza}
                                editar={true}
                            ></NuevoEntradaFormulario>
                        </div>    
                        }
                    </div>                    
                </Col>
            </Row>
        </Container>
    )
}