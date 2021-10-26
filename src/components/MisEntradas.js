import React from 'react'
import { Button, Image } from 'react-bootstrap';
// import { useSelector } from 'react-redux';
import "../css/main.css";
import "../css/mypost.css";

function MisEntradas() {

    // const usuario = useSelector(state=>state.auth.usuario)

    return (
        <div id="mypost" className="flex-container card-group">
            <div className="flex-container card round border-green dashed col-4 p-2">
                <div class="box-img-post flex-container flex-column position-relative">
                    <div class="card-img-top img-container-card-h mt-2">
                        <Image src="../img/p_e_2.jpg" alt="..." />
                    </div>
                    <span class="tag-red tag position-absolute">Buscado</span>
                </div>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase">nombre</h5>
                    <p class="small text-muted">25 de septiembre de 2021</p>
                </div>
                <div className="d-grid gap-2 rounded hover-brown">
                    <Button variant="primary" size="lg">Perfil</Button>{' '}
                </div>
            </div>

            <div class="card round border-green dashed col-4 p-2">
                <div class="box-img-post flex-container flex-column position-relative">
                    <div class="card-img-top flex-container img-container-card-v mt-2">
                        <Image src="../img/g_e.jpg" alt="..." />
                    </div>
                    <span class="tag-green tag position-absolute">Encontrado</span>
                </div>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase">nombre</h5>
                    <p class="small text-muted">25 de septiembre de 2021</p>
                </div>
                <div className="d-grid gap-2 rounded hover-brown">
                    <Button variant="primary" size="lg">Perfil</Button>{' '}
                </div>
            </div>

            <div class="card round border-green dashed col-4 p-2">
                <div class="box-img-post position-relative">
                    <div class="card-img-top d-flex flex-column justify-content-center img-container-card-v mt-2">
                        <Image src="../img/pe1.jpg" alt="..." />
                    </div>
                    <span class="tag-red tag position-absolute">Buscado</span>
                </div>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase">nombre</h5>
                    <p class="small text-muted">25 de septiembre de 2021</p>
                </div>
                <div className="d-grid gap-2 rounded hover-brown">
                    <Button variant="primary" size="lg">Perfil</Button>{' '}
                </div>
            </div>
        </div>

    )
}

export {MisEntradas}