import React, { useEffect, useState } from 'react'
import { Alert, Card, Col, Container, Row } from 'react-bootstrap'
import { useHistory, useParams } from 'react-router-dom'
import validator from 'validator'
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import axios from 'axios';
import { ACTUALIZAR_USUARIOS_ENDPOINT, USUARIOS_DETALLES_ENDPOINT } from '../helpers/endpoints';
import { toast } from 'react-toastify';
import { useDispatch } from 'react-redux';
import NuevoPartidoFormulario from '../components/formularios/NuevoPartidoFormulario';


export default function EditarUsuario() {

    const {id} = useParams();
    const [errores, setErrores]= useState({});
    const [usuario, setUsuario]= useState(null);
    const history=useHistory();
    const dispatch= useDispatch();

    useEffect(() =>{
        axios.get(`${USUARIOS_DETALLES_ENDPOINT}/${id}`).then(response=>{
            setUsuario(response.data);
        }).catch(error =>{
            history.push('/')
        })        
    }, [id, history]);

    const editarUsuario = async({nombre, userName, email, phone}) => {
        const errores={};
        setErrores(errores);

        if(validator.isEmpty(nombre)){
            errores.nombre= "Los goles del equipo local no puede estar vacio"
        }

        if(validator.isEmpty(userName)){
            errores.userName= "Los goles del equipo local no puede estar vacio"
        }

        if(validator.isEmpty(email)){
            errores.email= "Los goles del equipo local no puede estar vacio"
        }

        if(validator.isEmpty(phone)){
            errores.phone = "Los goles del equipo visitante no puede estar vacio"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        try {
            const response = await axios.put(`${ACTUALIZAR_USUARIOS_ENDPOINT}/${usuario.userId}`, {nombre, userName, email, phone});
            
            await dispatch(obetenerUsuarioUsuarios());
            toast.info("Partido actualizado con exito", {
                position: toast.POSITION.BOTTOM_CENTER,
                autoClose: 2000
            });
            history.push(`/usuarios/${response.data.userId}`);
        } catch (error) {
            setErrores({
                editarUsuario:error.response.data.message
            });
        }
        
    }

    return (

        <Container className="margen-t margen-b">
            <Row>
                <Col sm="12" lg={{span:10, offset:1}} >
                    <Card body>
                        {errores.editarUsuario && <Alert variant="danger">{errores.editarUsuario}</Alert>}
                        <h3>Editar partido</h3>
                        { usuario && 
                            <NuevoPartidoFormulario 
                                errores={errores} 
                                enviarCallback={editarUsuario}
                                uNombre={usuario.nombre}
                                uUserName={usuario.userName}
                                uEmail={usuario.email}
                                uPhone={usuario.phone}
                                editar={true}
                            ></NuevoPartidoFormulario>    
                        }                    
                    </Card>
                </Col>
            </Row>
        </Container>
    )
}