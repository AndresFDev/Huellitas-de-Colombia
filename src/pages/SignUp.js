import React, { Fragment, useEffect, useState } from 'react'
import { Alert, Card, Col, Container, Image, Row } from 'react-bootstrap'
import { SignUpForm } from '../components/SignUpForm'
import { useDispatch, useSelector } from 'react-redux'
import { Link, useHistory } from 'react-router-dom'
import validator from 'validator'
import {isObjetoVacio} from '../connection/helpers/isObjetoVacio'
import {registrarUsuario, loginUsuario} from '../connection/autenticacionAcciones'
import img_logo from '../img/logo_t_w.svg'
import '../css/main.css'
import '../css/signup.css'
import '../js/bgChange';

function SignUp() {

    const [errores, setErrores] = useState({});

    const dispatch = useDispatch();

    const conectado = useSelector(state => state.auth.conectado);

    const history = useHistory();

    useEffect(()=>{
        if(conectado){
            history.push("/");
        }
    });

    const registro = ({userName, email, password, nombre, telefono})=> {

        const errores={};
        setErrores(errores);

        if(validator.isEmpty(userName)){
            errores.userName = "ERROR. El usuario no puede estar vacio";
        }

        if(validator.isEmpty(email)){
            errores.email = "ERROR. El correo no puede estar vacio";
        }else{
            if(!validator.isEmail(email)){
                errores.email = "ERROR. El correo no es valido";
            }
        }

        if(validator.isEmpty(password)){
            errores.password = "ERROR. La contraseña no puede estar vacia";
        }else{
            if(!validator.isLength(password, {min:8, max:30})){
                errores.password = "ERROR. La contraseña debe tener entre 8 y 30 caracteres";
            }
        }

        if(validator.isEmpty(nombre)){
            errores.nombre = "ERROR. El nombre no puede estar vacio";
        }

        if(validator.isEmpty(telefono)){
            errores.telefono = "ERROR. El telefono no puede estar vacio";
        }else{
            if(!validator.isLength(telefono, {min:10, max:10})){
                errores.telefono = "ERROR. El telefono debe tener 10 numeros";
            }
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        // console.log({email, password})

        dispatch(registrarUsuario({userName, email, password, nombre, telefono}))
            .then(response => {
                dispatch(loginUsuario({userName, password}));

            })
            .catch(error =>{
                setErrores({registro: error.response.data.menssage})
            })
    }

    return (
        <div className="flex-container w-100 mt-3"> 
            <div className="flex-container mb-3">
                <Container>
                    <Row>
                        <Col>
                            <Card body id="signup" className="flex-container card round border-br bg-brown m-3">
                                <div className="flex-container">
                                    <Image src={img_logo} width="450hv" className=""/>
                                </div>
                                <div className="flex-container mt-3"> 
                                    {errores.registro && <Alert variant="danger">{errores.registro}</Alert>}
                                    <h3 className="text-center">Registro</h3>
                                </div>
                                <div className="flex-container">
                                <SignUpForm errores={errores} enviarCallback={registro}></SignUpForm>
                                </div>
                                <div className="flex-container mt-3">
                                    <Link to={'/login'}>¿Ya tienes una cuenta? Inicia sesion aquí</Link>
                                </div>
                            </Card>
                        </Col>
                    </Row>
                </Container>
                <Fragment>
                    {/* <BgChange /> */}
                </Fragment>
            </div>
        </div>
               
    )
}

export {SignUp}
