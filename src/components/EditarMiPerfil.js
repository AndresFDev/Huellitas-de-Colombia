import React from 'react'
import imgprofile from '../img/ej.jpg';
import "../css/main.css";
import "../css/profile.css";
import { Button, Form, FormControl, Image, InputGroup } from 'react-bootstrap';
import { useSelector } from 'react-redux';

function EditarMiPerfil() {

    const usuario = useSelector(state=>state.auth.usuario)

    return (
        <div id="edit-profile" className="flex-container card round huella_edit p-2">
            <div class="d-flex flex-column text-center">
                <h4 className="">Usuaria</h4>
                <div className="d-flex flex-column flex-container">
                    <div className="flex-container">
                    <div className="box-img-profile W-100 m-2">
                        <Image src={imgprofile} className=""/>
                    </div>
                    </div>
                    <Form.Group controlId="formFile-sm" className="mb-3">
                        <Form.Label>Foto de perfil</Form.Label>
                        <Form.Control className="form-control form-control-sm border-br" type="file" size="sm" />
                    </Form.Group>
                </div>
                <div>
                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Usuario</InputGroup.Text>
                        <FormControl id="userName" type="text" value={usuario.sub} placeholder="userName" className="border-br text-uppercase"/>
                    </InputGroup>

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Nombre</InputGroup.Text>
                        <FormControl id="nombre" type="text" value={usuario.sub} placeholder="name" className="border-br text-uppercase"/>
                    </InputGroup>

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
                                    checked
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

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Correo</InputGroup.Text>
                        <FormControl id="email" type="email" value={usuario.sub} placeholder="email" className="border-br text-lowercase"/>
                    </InputGroup>

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Telefono</InputGroup.Text>
                        <FormControl id="telefono" type="phone" value={usuario.sub} placeholder="555555555" className="border-br"/>
                    </InputGroup>

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Contraseña</InputGroup.Text>
                        <FormControl id="password" type="password" value={usuario.sub} placeholder="123456789" className="border-br"/>
                    </InputGroup>

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Nueva contraseña</InputGroup.Text>
                        <FormControl id="password" type="password" value={usuario.sub} placeholder="123456789" className="border-br"/>
                    </InputGroup>

                    <InputGroup className="mb-2">
                        <InputGroup.Text className="bg-brown border-br col-6">Confirmar contraseña</InputGroup.Text>
                        <FormControl id="password" type="password" value={usuario.sub} placeholder="123456789" className="border-br"/>
                    </InputGroup>

                    <div className="d-grid gap-2 rounded hover-brown mt-3">
                        <Button variant="primary" size="lg">Guardar cambios</Button>{' '}
                    </div>
                </div>
            </div>
        </div>
    )
}

export {EditarMiPerfil}