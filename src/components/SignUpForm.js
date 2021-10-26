import React, { useState } from 'react'
import { Form, Button } from 'react-bootstrap'
import '../css/main.css'
import '../css/signup.css'

function SignUpForm({errores, enviarCallback}) {
    
    const [userName, setUserName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [nombre, setNombre] = useState("");
    const [telefono, setTelefono] = useState("");

    const enviarFormulario = (e)=> {
        e.preventDefault();
        enviarCallback({userName, email, password, nombre, telefono});

    }
    
    return (
        <div className="flex-container">  
            <div className="flex-container"> 
                <Form onSubmit={enviarFormulario}>
                    <Form.Group className="d-flex flex-column mb-3" controlId="userName">
                        <Form.Label>Usuario</Form.Label>
                        <Form.Control 
                            type="text" 
                            placeholder="Ingrese su usuario"
                            value={userName}
                            onChange={e=>setUserName(e.target.value)}
                            isInvalid={errores.userName}
                            className="form-control border-br"
                        />
                        <Form.Control.Feedback type="invalid">
                            {errores.userName}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="d-flex flex-column mb-3" controlId="nombre">
                        <Form.Label>Nombre</Form.Label>
                        <Form.Control 
                            type="text" 
                            placeholder="Ingrese su nombre"
                            value={nombre}
                            onChange={e=>setNombre(e.target.value)}
                            isInvalid={errores.nombre}
                            className="form-control border-br"
                        />
                        <Form.Control.Feedback type="invalid">
                            {errores.nombre}
                        </Form.Control.Feedback>
                    </Form.Group>

                    {/* <Form.Group className="d-flex flex-column mb-3" controlId="apellido">
                        <Form.Label>Apellido</Form.Label>
                        <Form.Control 
                            type="text" 
                            placeholder="Ingrese su apellido"
                            value={nombre}
                            onChange={e=>setNombre(e.target.value)}
                            isInvalid={errores.nombre}
                            className="form-control border-br"
                        />
                        <Form.Control.Feedback type="invalid">
                            {errores.nombre}
                        </Form.Control.Feedback>
                    </Form.Group> */}

                    {/* <Form.Group className="d-flex flex-column mb-3" controlId="nombre">
                        <Form.Label>Ciudad</Form.Label>
                        <Form.Select>
                            <option>Default select</option>
                        </Form.Select>
                    </Form.Group> */}

                    <Form.Group className="mb-3" controlId="email">
                        <Form.Label>Correo</Form.Label>
                        <Form.Control 
                            type="email" 
                            placeholder="Ingrese su correo"
                            value={email}
                            onChange={e=>setEmail(e.target.value)}
                            isInvalid={errores.email}
                            className="form-control border-br"
                        />
                        <Form.Control.Feedback type="invalid">
                            {errores.email}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="telefono">
                        <Form.Label>Telefono</Form.Label>
                        <Form.Control 
                            type="phone" 
                            placeholder="Ingrese su telefono"
                            value={telefono}
                            onChange={e=>setTelefono(e.target.value)}
                            isInvalid={errores.telefono}
                            className="form-control border-br"
                        />
                        <Form.Control.Feedback type="invalid">
                            {errores.telefono}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group controlId="foto" className="mb-3">
                        <Form.Label>Imágen o foto de perfil</Form.Label>
                        <Form.Control 
                            type="file"
                            size="sm"
                            // value={foto}
                            // onChange={e=>setFoto(e.target.value)}
                            // isInvalid={errores.foto}
                            className="form-control border-br"
                        />
                        {/* <Form.Control.Feedback type="invalid">
                            {errores.foto}
                        </Form.Control.Feedback> */}
                    </Form.Group>

                    <Form.Group controlId="genero" className="mb-3">
                        <Form.Label>Género</Form.Label>
                        <Form>
                            {['radio'].map((type) => (
                                <div key={`inline-${type}`} className="mb-3">
                                <Form.Check
                                    inline
                                    label="Masculino"
                                    name="group1"
                                    type={type}
                                    id={`inline-${type}-1`}
                                />
                                <Form.Check
                                    inline
                                    label="Femenino"
                                    name="group1"
                                    type={type}
                                    id={`inline-${type}-2`}
                                />
                                <Form.Check
                                    inline
                                    name="group1"
                                    label="No específico"
                                    type={type}
                                    id={`inline-${type}-3`}
                                />
                                </div>
                            ))}
                        </Form>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="password">
                        <Form.Label>Contraseña</Form.Label>
                        <Form.Control 
                            type="password" 
                            placeholder="Ingrese su contraseña"
                            value={password}
                            onChange={e=>setPassword(e.target.value)}
                            isInvalid={errores.password}
                        />

                        <Form.Control.Feedback type="invalid">
                            {errores.password}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Button variant="primary" type="submit">
                        Registrarse
                    </Button>
                </Form>
            </div>
        </div>
    )
}

export {SignUpForm}