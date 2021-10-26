import React, { Fragment } from 'react'
import { Container } from 'react-bootstrap';
import { EditarMiPerfil } from '../components/EditarMiPerfil';
import "../css/main.css";
import "../css/profile.css";
import "../img/separador_br_v.svg";

function EditarPerfil() {

return (
    <Container className="mt-3">
        <Fragment>
            <div className="flex-container">
            <h3 className="pt-3">Editar Mi Perfil</h3>
            </div>
            <div className="flex-container rounded"> 
                <EditarMiPerfil id="edit-profile"/>
            </div>
        </Fragment>
    </Container>
)}

export {EditarPerfil}