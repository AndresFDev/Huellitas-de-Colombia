import moment from 'moment'
import React from 'react'
import { Button, Col, Container, Image } from 'react-bootstrap'
import { NavLink } from 'react-router-dom'
import EliminarEntradaButton from './botones/EliminarEntradaButton'
import img_1 from "../../assets/img/mascota_img.svg"
import img_2 from "../../assets/img/mascota_img_2.svg"
import "../../assets/css/main.css";
import "../../assets/css/mypost.css";

export default function Entrada({entrada, controlesRender }) {
    return (
        <Col xs={12} sm={12} md={12} lg={6} xl={4}>  
            <Container className="flex-container mb-4">                 
                <div id="mypost" className="flex-container card round border-green dashed p-2 m-2">
                        {controlesRender &&
                        <div className="flex-container border-bottom border-g">
                            <div className="flex-container m-1">
                                <Button 
                                    variant="primary" size="sm" className="btn m-1"
                                    as={NavLink} to={`editarentrada/${entrada.entradaId}`}
                                >
                                    EDITAR
                                </Button>
                                <EliminarEntradaButton entradaId={entrada.entradaId} nombreMascota={entrada.nombreMascota}></EliminarEntradaButton>
                            </div>
                        </div>
                        }
                    
                    <div class="box-img-post flex-container flex-column position-relative">
                        <div class="card-img-top img-container-card-v shadow mt-2">
                            {entrada.tipo === "Perro" ? (                           
                                    <Image src={img_1} alt="..." /> 
                                ) : ( 
                                    <Image src={img_2} alt="..." />                          
                            )}
                        </div>
                        <div>
                            {entrada.estatus === "Encontrado" ? (                           
                                <span class="tag-green tag position-absolute">
                                    <h7>
                                        ENCONTRADO
                                    </h7>
                                </span> 
                            ) : ( 
                                <span class="tag-red tag position-absolute">   
                                    <h7>
                                        BUSCADO
                                    </h7>
                                </span>                            
                            )}
                        </div>
                    </div>
                    <div class="card-body text-center">
                        <h5 class="card-title text-uppercase">{entrada.nombreMascota}</h5>
                        <p class="small text-muted">
                            {entrada.estatus} desde el<br />
                            {moment(entrada.fecha).format('D[ de ]MMMM[ de ]YYYY')}, {moment(entrada.createdAt).fromNow()}
                        </p>
                        <h6>{entrada.ciudadRestModelCiudades.nombre}</h6>
                        </div>
                    <div className="d-grid gap-2">
                        <Button as={NavLink} to={`/entradas/${entrada.entradaId}`} variant="primary" size="lg">DETALLES</Button>{' '}
                    </div>
                </div>
            </Container>
        </Col>                     
    )
}