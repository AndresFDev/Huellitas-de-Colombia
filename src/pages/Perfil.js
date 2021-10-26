import React, { Fragment } from 'react'
import { Container } from 'react-bootstrap';
import { MiPerfil } from '../components/MiPerfil';
import { MisEntradas } from '../components/MisEntradas';
import "../css/main.css";
import "../css/profile.css";
import "../img/separador_br_v.svg";

function Perfil() {

return (
    <Container className="mt-3">
        <Fragment>
            <div className="flex-container">
            <h3 className="pt-3">Mi Perfil</h3>
            </div>
            <div className="flex-container rounded"> 
                <MiPerfil id="profile"/>
            </div>
        </Fragment>
        <Fragment>
            <div className="flex-container">
            <h3 className="pt-3">Mis Entradas</h3>
            </div>
            <div className="flex-container rounded"> 
                <MisEntradas/>
            </div>
        </Fragment>
    </Container>
)}


/* 
<main class="d-flex flex-column bg-main">
    <h3 class="d-flex justify-content-center p-3">Mi Perfil</h3>
    <div id="profile" class="d-flex justify-content-center">
        <iframe src="../components/miPerfil.html" frameborder="0" width="400vh" height="540vh"></iframe>
    </div>
    <h3 class="d-flex justify-content-center p-3">Mis Entradas</h3>
    <div class="d-flex justify-content-center pb-3">
        <iframe src="../components/misEntradas.html" frameborder="0" width="85%" height="440vh"></iframe>
    </div> 
</main>
*/

export {Perfil}