import React, { useState } from 'react'
import imgprofile from '../assets/img/img_profile_1.svg';
import "../assets/css/main.css";
import "../assets/css/profile.css";
import { Button, Form, FormControl, Image, InputGroup } from 'react-bootstrap';
// import { useSelector } from 'react-redux';

function EditarMiPerfil({errores, usuario, enviarCallback, editar}) {

    const [userName, setUserName] = useState(usuario.userName);
    const [nombre, setNombre] = useState(usuario.nombre);
    const [email, setEmail] = useState(usuario.email);
    const [phone, setPhone] = useState(usuario.phone);
     
    
    const enviarFormulario = (e) => {
        e.preventDefault();
        !editar ? enviarCallback({userName, nombre, email, phone}) : enviarCallback({userName, nombre, email, phone})
    }

    return (
        <Form onSubmit={enviarFormulario}> 
            {editar &&
                <div id="edit-profile" className="card round huella_edit p-2">
                    <div class="d-flex flex-column text-center col-12">
                        <h4>Usuario</h4>
                        <div className="d-flex flex-column flex-container mb-2">
                            <div className="flex-container">
                                <div className="box-img-profile shadow m-2">
                                    <Image src={imgprofile} className=""/>
                                </div>
                            </div>
                        </div>
                        
                        <div>
                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Usuario</InputGroup.Text>
                                <FormControl id="userName" type="text" value={userName} onChange={e=>setUserName(e.target.value)} placeholder="userName" className="border-br text-uppercase" required/>
                                <Form.Control.Feedback type="invalid">
                                    {errores.userName}
                                </Form.Control.Feedback>
                            </InputGroup>

                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Nombre</InputGroup.Text>
                                <FormControl id="nombre" type="text" value={nombre} onChange={e=>setNombre(e.target.value)} placeholder="name" className="border-br text-uppercase" required/>
                                <Form.Control.Feedback type="invalid">
                                    {errores.nombre}
                                </Form.Control.Feedback>
                            </InputGroup>

                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Correo</InputGroup.Text>
                                <FormControl id="email" type="email" value={email} onChange={e=>setEmail(e.target.value)} placeholder="email@email.com" className="border-br text-lowercase" required/>
                                <Form.Control.Feedback type="invalid">
                                    {errores.email}
                                </Form.Control.Feedback>
                            </InputGroup>

                            <InputGroup className="mb-2">
                                <InputGroup.Text className="bg-brown border-br col-6">Telefono</InputGroup.Text>
                                <FormControl id="telefono" type="phone" value={phone} onChange={e=>setPhone(e.target.value)} placeholder="555555555" className="border-br" required/>
                                <Form.Control.Feedback type="invalid">
                                    {errores.phone}
                                </Form.Control.Feedback>
                            </InputGroup>  
                            
                        </div>
                        
                        <div className="d-grid gap-2 rounded hover-brown mt-3">
                            <Button variant="primary" size="lg">{!editar ? "Crear " : "Editar "}
                                    usuario</Button>{' '}
                        </div>
                    </div>
                </div>
            }
        </Form> 
                
    )
}

export {EditarMiPerfil}