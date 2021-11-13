import React, {useState} from 'react'
import {Form, Button, Image} from "react-bootstrap"
import moment from 'moment';
import "../../assets/css/main.css"
import "../../assets/css/post.css"
import ped_1 from"../../assets/img/bg_signin.jpg"


export default function NuevoEntradaFormulario({errores, enviarCallback, 
    eFecha="", eEstatus="Buscado", eTipo="Perro", eNombreMascota="", eRaza="", eDescripcion="", eDireccion="", eNombreDueno="", ePhoneDueno="", eCiudadCiudades="0", editar}) {

    const [fecha, setFecha] = useState(eFecha);
    const [estatus, setEstatus] = useState(eEstatus);
    const [tipo, setTipo] = useState(eTipo);
    const [nombreMascota, setNombreMascota] = useState(eNombreMascota);
    const [raza, setRaza] = useState(eRaza); 
    const [descripcion, setDescripcion] = useState(eDescripcion);
    const [direccion, setDireccion] = useState(eDireccion);
    const [nombreDueno, setNombreDueno] = useState(eNombreDueno);
    const [phoneDueno, setPhoneDueno] = useState(ePhoneDueno);
    const [ciudadCiudades, setCiudadCiudades] = useState(eCiudadCiudades);

    const enviarFormulario = (e) => {
        e.preventDefault();
        !editar ? enviarCallback({fecha, estatus, tipo, nombreMascota, raza, descripcion, direccion, nombreDueno, phoneDueno, ciudadCiudades }) : enviarCallback({estatus, nombreMascota, raza, descripcion, direccion, nombreDueno, phoneDueno})
    }

    return (
        
        <Form id="post" className="bg-brown p-3" onSubmit={enviarFormulario}>
            {!editar &&
                <Form.Group className="mb-3" controlId="estatus">
                    <Form.Label>Estado de la mascota</Form.Label>
                        <div className="mb-3">
                        <Form.Check
                            inline
                            label="Buscado"
                            name="estatus"
                            type="radio"
                            value="Buscado"
                            id="Buscado"
                            checked={estatus === "Buscado" ? true : false }
                            isInvalid={errores.estatus}
                            onChange={e=>setEstatus(e.target.value)}
                        />
                        <Form.Check
                            inline
                            label="Encontrado"
                            name="estatus"
                            type="radio"
                            value="Encontrado"
                            id="Encontrado"
                            checked={estatus === "Encontrado" ? true : false }
                            isInvalid={errores.estatus}
                            onChange={e=>setEstatus(e.target.value)}
                        />
                        </div>
                    <Form.Control.Feedback type="invalid">
                        {errores.estatus}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="mb-3" controlId="fecha">              
                    <Form.Label>Fecha de perdida o encuentro</Form.Label>
                    <Form.Control 
                        type="date" 
                        value={moment(fecha).format('yyyy-MM-DD')}
                        // min={moment().format('yyyy-MM-DD')}
                        onChange={e=>setFecha(e.target.value)}
                        isInvalid={errores.fecha}                      
                    >                        
                    </Form.Control>  

                    <Form.Control.Feedback type="invalid">
                        {errores.fecha}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="mb-3" controlId="idCiudadCiudades">
                    <Form.Label>Ciudad</Form.Label>
                    <Form.Control 
                        as="select" 
                        type="select"
                        value={ciudadCiudades}
                        onChange={e=>setCiudadCiudades(e.target.value)}
                        isInvalid={errores.ciudadCiudades}
                        required
                    >
                        <option value="">Seleccione la ciudad</option>
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
            }
            {!editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="direccion">
                    <Form.Label>Dirección del evento</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Dirección"
                        value={direccion}
                        onChange={e=>setDireccion(e.target.value)}
                        isInvalid={errores.direccion}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.direccion}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="nombreMascota">
                    <Form.Label>Nombre de la mascota</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Nombre mascota"
                        value={nombreMascota}
                        onChange={e=>setNombreMascota(e.target.value)}
                        isInvalid={errores.nombreMascota}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.nombreMascota}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="mb-3" controlId="tipo">
                    <Form.Label>Tipo de mascota</Form.Label>
                        <div className="mb-3">
                        <Form.Check
                            inline
                            label="Perro"
                            name="tipo"
                            type="radio"
                            value="Perro"
                            id="Perro"
                            checked={tipo === "Perro" ? true : false }
                            isInvalid={errores.tipo}
                            onChange={e=>setTipo(e.target.value)}
                        />
                        <Form.Check
                            inline
                            label="Gato"
                            name="tipo"
                            type="radio"
                            value="Gato"
                            id="Gato"
                            checked={tipo === "Gato" ? true : false }
                            isInvalid={errores.tipo}
                            onChange={e=>setTipo(e.target.value)}
                        />
                        </div>
                    <Form.Control.Feedback type="invalid">
                        {errores.tipo}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="raza">
                    <Form.Label>Raza</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Raza"
                        value={raza}
                        onChange={e=>setRaza(e.target.value)}
                        isInvalid={errores.raza}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.raza}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="mb-3" controlId="descripcion">
                    <Form.Label>Descripción de la mascota</Form.Label>
                    <Form.Control 
                        as="textarea" 
                        rows={5} 
                        value={descripcion}
                        onChange={e=>setDescripcion(e.target.value)}
                        isInvalid={errores.descripcion}
                        className="form-control border-br p"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.descripcion}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="nombreDueno">
                    <Form.Label>Nombre del contacto</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Ingrese su nombre"
                        value={nombreDueno}
                        onChange={e=>setNombreDueno(e.target.value)}
                        isInvalid={errores.nombreDueno}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.nombreDueno}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {!editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="phoneDueno">
                    <Form.Label>Teléfono para contacto</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Ingrese su télefono"
                        value={phoneDueno}
                        onChange={e=>setPhoneDueno(e.target.value)}
                        isInvalid={errores.phoneDueno}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.phoneDueno}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <div className="flex-container mb-3">
                    <div className="card-img-top img-container-card-h shadow">
                        <Image src={ped_1} alt="..." />
                    </div>
                </div>
            }
            {editar &&
                <Form.Group className="mb-3" controlId="estatus">
                    <Form.Label>Estado de la mascota</Form.Label>
                    <div className="mb-3">
                        <Form.Check
                            inline
                            label="Buscado"
                            name="estatus"
                            type="radio"
                            value="Buscado"
                            id="Buscado"
                            checked={estatus === "Buscado" ? true : false }
                            onChange={e=>setEstatus(e.target.value)}
                        />
                        <Form.Check
                            inline
                            label="Encontrado"
                            name="estatus"
                            type="radio"
                            value="Encontrado"
                            id="Encontrado"
                            checked={estatus === "Encontrado" ? true : false }
                            onChange={e=>setEstatus(e.target.value)}
                        />
                    </div>
                    <Form.Control.Feedback type="invalid">
                        {errores.estatus}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="direccion">
                    <Form.Label>Dirección del evento</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Dirección"
                        value={direccion}
                        onChange={e=>setDireccion(e.target.value)}
                        isInvalid={errores.direccion}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.direccion}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="nombreMascota">
                    <Form.Label>Nombre de la mascota</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Nombre mascota"
                        value={nombreMascota}
                        onChange={e=>setNombreMascota(e.target.value)}
                        isInvalid={errores.nombreMascota}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.nombreMascota}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="raza">
                    <Form.Label>Raza</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Raza o tipo"
                        value={raza}
                        onChange={e=>setRaza(e.target.value)}
                        isInvalid={errores.raza}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.raza}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="mb-3" controlId="descripcion">
                    <Form.Label>Descripcion de la mascota</Form.Label>
                    <Form.Control 
                        as="textarea" 
                        rows={5} 
                        value={descripcion}
                        onChange={e=>setDescripcion(e.target.value)}
                        isInvalid={errores.descripcion}
                        className="form-control border-br p"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.descripcion}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="nombreDueno">
                    <Form.Label>Nombre del usuario</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Ingrese su nombre"
                        value={nombreDueno}
                        onChange={e=>setNombreDueno(e.target.value)}
                        isInvalid={errores.nombreDueno}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.nombreDueno}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            {editar &&
                <Form.Group className="d-flex flex-column mb-3" controlId="phoneDueno">
                    <Form.Label>Teléfono para contacto</Form.Label>
                    <Form.Control 
                        type="text"
                        placeholder="Ingrese su télefono"
                        value={phoneDueno}
                        onChange={e=>setPhoneDueno(e.target.value)}
                        isInvalid={errores.phoneDueno}
                        className="form-control border-br"
                    />

                    <Form.Control.Feedback type="invalid">
                        {errores.phoneDueno}
                    </Form.Control.Feedback>
                </Form.Group>
            }
            <Button variant="primary" type="submit" className="margen-t">
                {!editar ? "CREAR " : "EDITAR "}
                ENTRADA
            </Button>
        </Form>     
    )
}