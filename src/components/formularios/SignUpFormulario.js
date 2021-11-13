import React, {useState} from 'react'
import {Form, Button} from "react-bootstrap"
import '../../assets/css/main.css'
import '../../assets/css/signup.css'


export default function SignUpFormulario({errores, enviarCallback}) {

    const [nombre, setNombre] = useState("");
    const [email, setEmail] = useState("");
    const [userName, setUserName] = useState("");
    const [phone, setPhone] = useState("");
    const [password, setPassword] = useState("");
    const [confirmarPassword, setConfirmarPassword] = useState("");
    const [ciudadCiudades, setCiudadCiudades] = useState("0");

    const enviarFormulario = (e) => {
        e.preventDefault();
        enviarCallback({userName, password, confirmarPassword, nombre, email, phone, ciudadCiudades});
    }

    return (

        <Form id="signup" className="p-3" onSubmit={enviarFormulario}>
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

                <Form.Group className="d-flex flex-column mb-3" controlId="email">
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

                <Form.Group className="d-flex flex-column mb-3" controlId="phone">
                    <Form.Label>Teléfono</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Ingrese su télefono"
                        value={phone}
                        onChange={e=>setPhone(e.target.value)}
                        isInvalid={errores.phone}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.phone}
                    </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="d-flex flex-column mb-3" controlId="ciudadCiudades">
                    <Form.Label>Ciudad</Form.Label>
                    <Form.Control
                        as="select" 
                        type="select"
                        value={ciudadCiudades}
                        onChange={e=>setCiudadCiudades(e.target.value)}
                        isInvalid={errores.ciudadCiudades}
                        required
                        className="border-br "
                    >
                        <option value="">Seleccione una ciudad</option>
                        <option value="1">Armenia</option>
                        <option value="2">Barranquilla</option>
                        <option value="3">Bello</option>
                        <option value="4">Bogotá</option>
                        <option value="5">Bucaramanga</option>
                        <option value="6">Cali</option>
                        <option value="7">Cartagena</option>
                        <option value="8">Cúcuta</option>
                        <option value="9">Ibagué</option>
                        <option value="10">Manizales</option>
                        <option value="11">Medellín</option>
                        <option value="12">Montería</option>
                        <option value="13">Neiva</option>
                        <option value="14">Pasto</option>
                        <option value="15">Pereira</option>
                        <option value="16">Santa Marta</option>
                        <option value="17">Soacha</option>
                        <option value="18">Soledad</option>
                        <option value="19">Valledupar</option>
                        <option value="20">Villavicencio</option>
                        
                    </Form.Control>

                    <Form.Control.Feedback type="invalid">
                        {errores.ciudadCiudades}
                    </Form.Control.Feedback>
                </Form.Group>

                {/* <Form.Group controlId="file" className="d-flex flex-column mb-3">
                        <Form.Label>Imágen o foto de perfil</Form.Label>
                        <Form.Control 
                            type="file"
                            size="sm"
                            value={file}
                            onChange={e=>setFile(e.target.files[0])}
                            className="form-control border-br"
                        />
                </Form.Group> */}

                <Form.Group className="d-flex flex-column mb-3" controlId="password">
                    <Form.Label>Contraseña</Form.Label>
                    <Form.Control 
                        type="password" 
                        placeholder="Ingrese su contraseña" 
                        value={password}
                        onChange={e=>setPassword(e.target.value)}
                        isInvalid={errores.password}
                        className="form-control border-br"
                    />
                    <Form.Control.Feedback type="invalid">
                        {errores.password}
                    </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="d-flex flex-column mb-3" controlId="confirmarPassword">
                    <Form.Label>Confirmar contraseña</Form.Label>
                    <Form.Control 
                        type="password" 
                        placeholder="Ingrese nuevamente su contraseña" 
                        value={confirmarPassword}
                        onChange={e=>setConfirmarPassword(e.target.value)}
                        isInvalid={errores.confirmarPassword}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.confirmarPassword}
                    </Form.Control.Feedback>
                </Form.Group>

                <Button type="submit" variant="primary" className="margen-t">
                    Crear usuario
                </Button>
        </Form>        
    )
}