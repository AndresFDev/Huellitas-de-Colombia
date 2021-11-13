import React, { useEffect, useState } from 'react'
import { Alert, Card, Container, Image } from 'react-bootstrap'
import { useDispatch, useSelector } from 'react-redux';
import { Link, useHistory } from 'react-router-dom'
import validator from 'validator'
import { isObjetoVacio } from '../helpers/isObjetoVacio';
import { registroUsuario, loginUsuario } from '../acciones/autenticacionAcciones';
import SignUpFormulario from '../components/formularios/SignUpFormulario';
import img_logo from '../assets/img/logo_t_w.svg'
import '../assets/css/main.css'
import '../assets/css/signup.css'

export default function SignUp() {

    const [errores, setErrores] = useState({});
    const dispatch = useDispatch();
    const conectado = useSelector(state=>state.auth.conectado);
    const history = useHistory();

    useEffect(() => {
        if(conectado) {
            history.push("/");
        }
    });

    const registro = ({userName, email, password, confirmarPassword, nombre, phone, ciudadCiudades })=> {

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

        if(validator.isEmpty(confirmarPassword)){
            errores.confirmarPassword = "ERROR. Ingrese la contraseña nuevamente para confirmar";
        }else{
            if(!validator.equals(confirmarPassword, password)){
                errores.confirmarPassword = "ERROR. Las contraseñas no coinciden";
            }
        }

        if(validator.isEmpty(nombre)){
            errores.nombre = "ERROR. El nombre no puede estar vacio";
        }

        if(validator.isEmpty(phone)){
            errores.phone = "ERROR. El telefono no puede estar vacio";
        }else{
            if(!validator.isLength(phone, {min:10, max:10})){
                errores.phone = "ERROR. El telefono debe tener 10 numeros";
            }
        }

        if(validator.isEmpty(ciudadCiudades)){
            errores.ciudadCiudades = "Debe seleccionar una ciudad"
        }

        if(!isObjetoVacio(errores)){
            setErrores(errores);
            return;
        }

        dispatch(registroUsuario({userName, password, nombre, email, phone, ciudadCiudades}))
        .then(response=>{
            dispatch(loginUsuario({userName, password}));
        })
        .catch(err=>{
            setErrores({ registroErr: err.response.data.message });
        });
    }

    return (

        <Container>
            <div className="flex-container mt-3"> 
                <div className="flex-container mb-3">
                    <Card id="signup" className="flex-container border-br bg-brown">
                        <div className="flex-container mt-3">
                            <Image src={img_logo} width="450hv" className=""/>
                        </div>
                            {errores.registroErr && <Alert variant="danger">{errores.registroErr}</Alert>}
                            <h3 className="text-center mt-3">Registro</h3>
                            <SignUpFormulario errores={errores} enviarCallback={registro}></SignUpFormulario>
                        <div className="flex-container mb-3">
                            <Link to={'/login'}>¿Ya tienes una cuenta? Iniciar sesion aqui</Link>
                        </div>
                    </Card>
                </div>
            </div>
        </Container>
    )
}


