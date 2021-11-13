import { Button, Form, FormControl, InputGroup } from 'react-bootstrap';
import "../assets/css/main.css";
import "../assets/css/profile.css";
import { useState } from 'react';

export default function DataUsuario({errores, usuario, enviarCallback, 
        uUserName="", uNombre="", uEmail="", uPhone="", editar}) {
    
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
                {!editar &&
                <div>
                    <InputGroup className="mb-2">
                    <InputGroup.Text className="bg-brown border-br col-6">Usuario</InputGroup.Text>
                    <FormControl
                        id="userName" 
                        type="text" 
                        value={userName}
                        onChange={e=>setUserName(e.target.value)}
                        required
                        placeholder="Usuario" 
                        className="border-br text-uppercase"
                    />
                    <Form.Control.Feedback type="invalid">
                        {errores.userName}
                    </Form.Control.Feedback>
                    </InputGroup>
                    <InputGroup className="mb-2">
                    <InputGroup.Text className="bg-brown border-br col-6">Nombre</InputGroup.Text>
                    <FormControl 
                        id="nombre" 
                        type="text" 
                        value={nombre}
                        onChange={e=>setNombre(e.target.value)}
                        required
                        placeholder="Nombre" 
                        className="border-br text-uppercase"
                    />
                    <Form.Control.Feedback type="invalid">
                        {errores.nombre}
                    </Form.Control.Feedback>
                    </InputGroup>
                    </div>
                }
                {editar &&
    
                <div>
                <InputGroup className="mb-2">
                <InputGroup.Text className="bg-brown border-br col-6">Usuario</InputGroup.Text>
                <FormControl
                    id="userName" 
                    type="text" 
                    value={userName}
                    onChange={e=>setUserName(e.target.value)}
                    required
                    placeholder="Usuario" 
                    className="border-br text-uppercase"
                />
                <Form.Control.Feedback type="invalid">
                    {errores.userName}
                </Form.Control.Feedback>
                </InputGroup>
                <InputGroup className="mb-2">
                <InputGroup.Text className="bg-brown border-br col-6">Nombre</InputGroup.Text>
                <FormControl 
                    id="nombre" 
                    type="text" 
                    value={nombre}
                    onChange={e=>setNombre(e.target.value)}
                    required
                    placeholder="Nombre" 
                    className="border-br text-uppercase"
                />
                <Form.Control.Feedback type="invalid">
                    {errores.nombre}
                </Form.Control.Feedback>
                </InputGroup>
                    <InputGroup className="mb-2">
                    <InputGroup.Text className="bg-brown border-br col-6">Email</InputGroup.Text>
                    <FormControl 
                        id="email" 
                        type="text" 
                        value={email}
                        onChange={e=>setEmail(e.target.value)}
                        required
                        placeholder="email@email.com" 
                        className="border-br text-uppercase"
                    />
                    <Form.Control.Feedback type="invalid">
                        {errores.email}
                    </Form.Control.Feedback>
                    </InputGroup>
                    <InputGroup className="mb-2">
                    <InputGroup.Text className="bg-brown border-br col-6">Teléfono</InputGroup.Text>
                    <FormControl 
                        id="phone" 
                        type="text" 
                        value={phone}
                        onChange={e=>setPhone(e.target.value)}
                        required
                        placeholder="Teléfono" 
                        className="border-br text-uppercase"
                    />
                    <Form.Control.Feedback type="invalid">
                        {errores.phone}
                    </Form.Control.Feedback>
                    </InputGroup>
                    </div>
                }
                <Button variant="primary" type="submit" className="margen-t">
                    {!editar ? "Crear " : "Editar "}
                    usuario
                </Button>
            </Form>        
        )
    }

export  {DataUsuario}