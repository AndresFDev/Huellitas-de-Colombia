import React, { Fragment, useEffect, useState } from 'react'
import axios from 'axios';
import { Container, Spinner } from 'react-bootstrap';
import { Usuario } from '../components/Usuario';
import {  PROFILE_ENDPOINT } from '../helpers/endpoints';
import DatosVacio from '../components/utils/DatosVacio';
import "../assets/css/main.css";
import "../assets/css/titles.css";
import "../assets/css/profile.css";
import "../assets/img/separador_br_v.svg";

export default function Perfil() {

    const [usuarios, setUsuarios] = useState([]);
    const [fetching, setFeching] = useState(true);

    useEffect(()=>{
        axios.get(PROFILE_ENDPOINT).then(response => {
            setUsuarios([response.data]);
            setFeching(false);
        }).catch(e => {
            console.error(e);
            setFeching(false);
        })
    }, []);

return (
    <Container className="mt-3">
        <Fragment>
            <div className="flex-container">
                <div id="title" className="flex-container">
                    <div id="title_in" className="flex-container col-12">
                        <h3 className="pt-3">Mi Perfil</h3>
                    </div>
                </div>
            </div>
            <div className="flex-container rounded"> 
                <div>
                    {fetching && <Spinner animation="grow" variant="dark" />}  
                    {!fetching && usuarios.length === 0 &&
                        <DatosVacio texto="ERROR"></DatosVacio>
                    } 
                </div>
                <div>
                {usuarios.map(usuario => <Usuario key={usuario.userId} usuario={usuario} controlesRender={false}></Usuario>)}
                </div>
            </div>
        </Fragment>
    </Container>
)}