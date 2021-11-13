import React, { Fragment, useEffect, useState } from 'react'
import { Alert, Container } from 'react-bootstrap';
import { EditarMiPerfil } from '../components/EditarMiPerfil';
import "../assets/css/main.css";
import "../assets/css/profile.css";
import "../assets/img/separador_br_v.svg";
import { ACTUALIZAR_PROFILE_ENDPOINT, PROFILE_ENDPOINT } from '../helpers/endpoints';
import axios from 'axios';
import validator from 'validator'
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router';
import { obetenerUsuario } from '../acciones/usuarioAcciones';
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import { toast } from 'react-toastify';

function EditarPerfil() {

    const [errores, setErrores]= useState({});
    const [usuarios, setUsuarios] = useState([]);
    const history = useHistory();
    const dispatch= useDispatch();


    useEffect(() =>{
        axios.get(`${PROFILE_ENDPOINT}`).then(response=>{
            setUsuarios([response.data]);
        }).catch(error =>{
            history.push('/')
        })        
    }, [history]);

    const obtenerDatos = async({userName, nombre, email, phone}) => {
        const errores={};
        setErrores(errores);

        if(validator.isEmpty(userName)){
            errores.userName= "El usuario no puede estar vacio"
        }

        if(validator.isEmpty(nombre)){
            errores.nombre = "El Nombre no puede estar vacio"
        }

        if(validator.isEmpty(email)){
            errores.email = "El correo no puede estar vacio"
        }

        if(validator.isEmpty(phone)){
            errores.phone = "El teléfono no puede estar vacio"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        try {
            const response = await axios.put(`${ACTUALIZAR_PROFILE_ENDPOINT}`, {userName, nombre, email, phone});
            
            await dispatch(obetenerUsuario());
            toast.info("Usuario actualizado con exito", {
                position: toast.POSITION.BOTTOM_CENTER,
                autoClose: 2000
            });
            history.push(`${response.data.userName}`);
        } catch (error) {
            setErrores({
                editarUsuario:error.response.data.message
            });
        }
        
    }

    return (
        <Container className="mt-2">
            <Fragment>
                <div className="flex-container">
                    <h3 className="pt-3 pb-3">Editar Perfil</h3>
                </div>
                <div className="flex-container"> 
                    {errores.editarUsuario && <Alert variant="danger">{errores.editarUsuario}</Alert>}
                    {usuarios.map(usuario => 
                            <EditarMiPerfil 
                                key={usuario.userId} 
                                usuario={usuario} 
                                controlesRender={false}
                                errores={errores} 
                                enviarCallback={obtenerDatos}
                                editar={true}
                            />)}
                            {/* {usuarios && 
                                <EditarMiPerfil 
                                
                                    errores={errores} 
                                    enviarCallback={obtenerDatos}
                                    uUserName={usuarios.userName}
                                    uNombre={usuarios.nombre}
                                    uEmail={usuarios.email}
                                    uPhone={usuarios.phone}
                                    editar={true}
                                />  
                            }                     */}
                </div>
            </Fragment>

        </Container>
    )
}

export {EditarPerfil}