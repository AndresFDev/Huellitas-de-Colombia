import React, { useEffect, useState } from 'react'
import { Alert, Card, Col, Container, Image, Row } from 'react-bootstrap'
import { Link, useHistory } from 'react-router-dom'
import SignInForm from '../components/SignInForm'
import validator from 'validator'
import { useDispatch, useSelector } from 'react-redux'
import { loginUsuario } from '../connection/autenticacionAcciones'
import { isObjetoVacio } from '../connection/helpers/isObjetoVacio'
import img_logo from '../img/logo_t_w.svg'
import '../css/main.css'
import '../css/signin.css'

export default function SignIn() {

    const [errores, setErrores] = useState({});

    const dispatch = useDispatch();

    const conectado = useSelector(state => state.auth.conectado);

    const history = useHistory();

    useEffect(() => {
        if(conectado){
            history.push("/");
        }
    });

    const login = ({userName, password}) => {

        const errores={}
        setErrores(errores)

        if(validator.isEmpty(userName)){
            errores.userName = "ERROR. El usuario no puede estar vacio"
        }

        if(validator.isEmpty(password)){
            errores.password = "ERROR. La contraseña no puede estar vacia"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        // console.log({email, password})

        dispatch(loginUsuario({userName, password}))
            .then(response => {

            })
            .catch(error => {
                setErrores({auth:"No se puede iniciar sesion con los datos suministrados"});
            });
    }

    return (
        <div className="flex-container w-100 mt-3"> 
            <div className="flex-container mb-3">
                <Container >
                    <Row>
                        <Col>
                            <Card body id="signin" className="flex-container border-br bg-brown mt-3">
                                {errores.auth && <Alert variant="danger">{errores.auth}</Alert>}
                                <div className="flex-container">
                                    <Image src={img_logo} width="350hv" className=""/>
                                </div>
                                <h3 className="text-center mt-3">Iniciar Sesion</h3>
                                <SignInForm errores={errores} enviarCallback={login}></SignInForm>
                                <div className="mt-3">
                                    <Link to={'/registro'}>¿No tienes una cuenta? Registrate aquí</Link>
                                </div>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
        </div>
    )
}
