import React from 'react'
import imgprofile from '../img/ej.jpg';
import "../css/main.css";
import "../css/profile.css";
import { Image } from 'react-bootstrap';
import { useSelector } from 'react-redux';

function MiPerfil() {

    const usuario = useSelector(state=>state.auth.usuario)

    return (
        <div id="profile" className="border-box">
            <div class="d-flex flex-column text-center">
                <h3 title={usuario.sub} class="mt-3 text-uppercase">fgdfgx</h3>
                <div className="flex-container">
                    <div className="box-img-profile W-100 m-2">
                        <Image src={imgprofile} className=""/>
                    </div>
                </div>
                <div>
                    <p>Usuaria</p>
                    <p>Kenedy, Bogotá</p>
                    <p>555-555-5555</p>
                    <p>email@email.com</p>
                </div>
            </div>
        </div>
    )
}

export {MiPerfil}
