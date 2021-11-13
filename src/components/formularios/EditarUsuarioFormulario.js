import React, {useState} from 'react'
import {Form, Button, Image, InputGroup, FormControl} from "react-bootstrap"
import imgprofile from '../../assets/img/ej.jpg';
import "../../assets/css/main.css";
import "../../assets/css/profile.css";


export default function EditarUsuarioFormulario({errores, enviarCallback, 
    uNombre="", uUserName="", uEmail="", editar}) {

    const [nombre, setNombre]=useState(uNombre);
    const [userName, setUserName]=useState(uUserName);
    const [email, setEmail]=useState(uEmail);
 

    const enviarFormulario = (e) => {
        e.preventDefault();
        !editar ? enviarCallback({nombre, userName, email}) : enviarCallback({nombre, userName, email})
    }

    return (
        <Form onSubmit={enviarFormulario}>        

            {!editar &&
                <div id="edit-profile" className="flex-container card round huella_edit p-2">
                <div class="d-flex flex-column text-center">
                    <h4>Usuario</h4>
                    <div className="d-flex flex-column flex-container">
                        <div className="flex-container">
                        <div className="box-img-profile W-100 m-2">
                            <Image src={imgprofile} className=""/>
                        </div>
                        </div>
                            <InputGroup className="mb-2">
                            <InputGroup.Text className="bg-brown border-br col-6">Usuario</InputGroup.Text>
                            <FormControl 
                                type="text" 
                                value={userName}
                                onChange={e=>setUserName(e.target.value)}
                                placeholder="userName" 
                                className="border-br"
                            />
                            <Form.Control.Feedback type="invalid">
                                {errores.userName}
                            </Form.Control.Feedback>
                            </InputGroup>

                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Nombre</InputGroup.Text>
                                <FormControl
                                    type="text" 
                                    value={nombre}
                                    onChange={e=>setNombre(e.target.value)}
                                    placeholder="Nombre" 
                                    className="border-br"
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errores.nombre}
                                </Form.Control.Feedback>
                            </InputGroup>

                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Correo</InputGroup.Text>
                                <FormControl
                                    type="text" 
                                    value={email}
                                    onChange={e=>setEmail(e.target.value)}
                                    placeholder="Correo" 
                                    className="border-br"
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errores.email}
                                </Form.Control.Feedback>
                            </InputGroup>

                        </div>
                    </div>
                </div>
            }
            {editar &&
                <div className="margen-t margen-b">
                    <p> {nombre} vs {userName} vs. {email} </p>
                </div>
            }
            <Button variant="primary" type="submit" className="margen-t">
                {!editar ? "Crear " : "Editar "}
                partido
            </Button>
        </Form>        
    )
}

