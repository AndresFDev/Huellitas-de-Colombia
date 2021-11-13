import React, { useEffect, useState } from 'react'
import { Alert, Card, Col, Container, Image, Row } from 'react-bootstrap'
import { useDispatch, useSelector } from 'react-redux';
import { Link, useHistory } from 'react-router-dom'
import SigninFormulario from '../components/formularios/SigninFormulario';
import validator from 'validator'
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import { loginUsuario } from '../acciones/autenticacionAcciones';
import img_logo from '../assets/img/logo_t_w.svg'
import '../assets/css/main.css'
import '../assets/css/signin.css'

export default function Signin() {

    const [errores, setErrores]= useState({});
    const dispatch= useDispatch();
    const conectado=useSelector(state=>state.auth.conectado);
    const history=useHistory();

    useEffect(() => {
        if(conectado) {
            history.push("/");
        }
    });

    const login=({userName, password}) => {
        const errores={};
        setErrores(errores);

        if(validator.isEmpty(userName)){
            errores.userName = "El usuario no puede estar vacio";
        }

        if(validator.isEmpty(password)){
            errores.password = "La contraseña no puede estar vacia"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        dispatch(loginUsuario({userName, password}))
        .then(response=>{

        })
        .catch(error=>{
            setErrores({ auth: "No se puede iniciar sesion con esas credenciales" });
        });
    }

    return (
        
        <Container>
            <div className="flex-container w-100 mt-3"> 
                <div className="flex-container mb-3">
                    <Row>
                        <Col>
                            <Card body id="signin" className="flex-container border-br bg-brown mt-3">
                                <div className="flex-container">
                                    <Image src={img_logo} width="350hv" className=""/>
                                </div>
                                {errores.auth && <Alert variant="danger">{errores.auth}</Alert>}
                                <h3 className="text-center mt-3">Iniciar sesión</h3> 
                                <SigninFormulario errores={errores} enviarCallback={login}></SigninFormulario>
                                <div className="mt-3">
                                    <Link to={'/registro'}>¿No tienes una cuenta? Registrate aqui</Link>
                                </div>
                            </Card>
                        </Col>
                    </Row>
                </div>
            </div>
        </Container>

    )
}
