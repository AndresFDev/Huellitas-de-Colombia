import React, { useEffect, useState } from 'react'
import { Badge, Button, Image } from 'react-bootstrap';
import moment from 'moment'
import img from "../assets/img/pe1.jpg"
import img_1 from "../assets/img/g_e.jpg"
import img_2 from "../assets/img/p_e_2.jpg"
import "../assets/css/main.css";
import "../assets/css/mypost.css";
import EliminarEntradaButton from './entradas/botones/EliminarEntradaButton';
import { NavLink, useHistory, useParams } from 'react-router-dom';
import axios from 'axios';
import { ENTRADA_DETALLES_ENDPOINT } from '../helpers/endpoints';

export default function MisEntradas(controlesRender) {

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
        
        <div id="mygroup" className="flex-container card-group">
            {controlesRender &&
                <div>
                    <Button 
                        variant="primary" size="sm" className="margen-e"
                        as={NavLink} to={`editarentrada/`}
                    >
                        Editar
                    </Button>
                    <EliminarEntradaButton entradaId={entrada.entradaId} nombreMascota={entrada.nombreMascota}></EliminarEntradaButton>
                </div>
            }
            <div id="mypost" className="flex-container card round border-green dashed col-4 p-2">
                <div class="box-img-post flex-container flex-column position-relative">
                    <div class="card-img-top img-container-card-h mt-2">
                        <Image src={img_2} alt="..." />
                    </div>
                    <span class="tag-green tag position-absolute">
                        {/* {entrada.jugado ?                             
                            <h7 className="tag-green">
                                Encontrado
                            </h7> 
                            :
                            <h7 className="tag-red">
                                Buscado
                            </h7>                            
                        } */}
                    </span>
                </div>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase">{entrada.ciudadRestModelCiudades.nombre}</h5>
                    <p className="small text-muted">
                        {moment(entrada.fecha).format('D[ de ]MMMM[ de ]YYYY')}
                    </p>
                </div>
                <div className="d-grid gap-2 rounded hover-brown">
                    <Button variant="primary" size="lg" to={`/entradas/${entrada.entradaId}`}>Detalles</Button>{' '}
                </div>
            </div>

            <div id="mypost" class="flex-container card round border-green dashed col-4 p-2">
                <div class="box-img-post flex-container flex-column position-relative">
                    <div class="card-img-top img-container-card-v mt-2">
                        <Image src={img_1} alt="..." />
                    </div>
                    <span class="tag-green tag position-absolute">
                        {entrada.jugado ?                             
                            <h7 className="tag-green">
                                Encontrado
                            </h7> 
                            :
                            <h7 className="tag-red">
                                Buscado
                            </h7>                            
                        }
                    </span>
                </div>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase">{entrada.ciudadRestModelCiudades.nombre}</h5>
                    <p class="small text-muted">
                        {moment(entrada.fecha).format('D[ de ]MMMM[ de ]YYYY')}
                    </p>
                </div>
                <div className="d-grid gap-2">
                    <Button variant="primary" size="lg">Detalles</Button>{' '}
                </div>
            </div>

            <div id="mypost" class="flex-container card round border-green dashed col-4 p-2">
                <div class="box-img-post position-relative">
                    <div class="card-img-top img-container-card-v mt-2">
                        <Image src={img} alt="..." />
                    </div>
                    <span class="tag position-absolute">
                        {entrada.jugado ?                             
                            <h7 className="tag-green">
                                Encontrado
                            </h7> 
                            :
                            <h7 className="tag-red">
                                Buscado
                            </h7>                            
                        }
                    </span>
                </div>
                <div className="card-body text-center">
                    <h5 class="card-title text-uppercase">{entrada.ciudadRestModelCiudad.nombre}</h5>
                    <p className="small text-muted">
                    {moment(entrada.fecha).format('D[ de ]MMMM[ de ]YYYY')}
                    </p>
                </div>
                <div className="d-grid">
                    <Button variant="primary" size="lg">Detalles</Button>{' '}
                </div>
            </div>
        </div>
    )
}