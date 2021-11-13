import axios from 'axios';
import moment from 'moment';
import React, { Fragment, useEffect, useState } from 'react'
import { useHistory, useParams } from 'react-router-dom'
import { ENTRADA_DETALLES_ENDPOINT } from '../helpers/endpoints';
import { Container, Form, Image } from 'react-bootstrap';
import img_1 from '../assets/img/mascota_img.svg'
import img_2 from "../assets/img/mascota_img_2.svg"
import '../assets/css/main.css'
import '../assets/css/postdetails.css';

export default function EntradaDetalles() {

    const {id} = useParams();
    const [entrada, setEntrada] = useState(null);
    const history = useHistory();

    useEffect(()=>{
        axios.get(`${ENTRADA_DETALLES_ENDPOINT}/${id}`).then(response => {
            setEntrada(response.data);
        }).catch(e => {
            history.push('/');
        })
    }, [id, history]);

    return (
        <Container className="mt-3">
            {entrada && (
                <Fragment>
                    <div className="flex-container">
                        <div id="title" className="flex-container">
                            <div id="title_in" className="flex-container col-12">
                                <h3 className="pt-2">Mascota</h3>
                            </div>
                        </div>
                    </div>
                    <div className="flex-container rounded"> 
                        <div>
                        
                            <div id="postdetails" className="border-box border-green text-uppercase col-12 p-2">
                                <div className="d-flex flex-column text-center">
                                    <h3 className="mt-2">{entrada.nombreMascota}</h3>
                                    <div className="flex-container">
                                        <div className="box-img-profile shadow m-2">
                                        {entrada.tipo === "Perro" ? (                           
                                            <Image src={img_1} alt="..." /> 
                                            ) : ( 
                                            <Image src={img_2} alt="..." />                          
                                        )}
                                        </div>
                                    </div>
                                    <div id="dataUser">
                                    <h5 class="card-title text-uppercase mt-2">{entrada.estatus} </h5>
                                            <p className="small text-muted">
                                                {moment(entrada.fecha).format('D[ de ]MMMM[ de ]YYYY')}
                                            </p>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-6">
                                                        <div className="flex-container bg-green pt-2"> 
                                                            <h6>Raza</h6>
                                                        </div>
                                                    </div> 
                                                    <div className="col-6 pt-2">
                                                        {entrada.raza}
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-12">
                                                    <div className="flex-container bg-green pt-2">
                                                            <h6>Descripcion</h6>
                                                        </div>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded mb-2">
                                                    <div className="col-12">
                                                    <div className="text-left">
                                                    <Form.Control id="info" disabled value={entrada.descripcion} as="textarea" rows={5} />
                                                    </div>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-6">
                                                        <div className="flex-container bg-green pt-2">
                                                            <h6>Ciudad</h6>
                                                        </div>
                                                    </div> 
                                                    <div className="col-6 pt-2">
                                                        {entrada.ciudadRestModelCiudades.nombre}
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-6">
                                                        <div className="flex-container bg-green pt-2">
                                                        <h6>Última ubicación</h6>
                                                        </div>
                                                    </div> 
                                                    <div className="col-6 pt-2">
                                                        {entrada.direccion}
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-6">
                                                        <div className="flex-container bg-green pt-2">
                                                        <h6>Usuario</h6>
                                                        </div>
                                                    </div> 
                                                    <div className="col-6 pt-2">
                                                        {entrada.nombreDueno}
                                                    </div> 
                                                </div>
                                            </div>
                                            <div className="flex-container rounded">
                                                <div id="info" className="flex-container text-center rounded m-2">
                                                    <div className="col-6">
                                                        <div className="flex-container bg-green pt-2"> 
                                                        <h6>Teléfono de contacto</h6>
                                                        </div>
                                                    </div> 
                                                    <div className="col-6 pt-2">
                                                        {entrada.phoneDueno}
                                                    </div> 
                                                </div>
                                            </div>
                                            <p className="pt-2">Creado por {entrada.usuarioRestModel.userName}, {moment(entrada.createdAt).fromNow()} </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </Fragment>
            )}
        </Container>
    )
}

