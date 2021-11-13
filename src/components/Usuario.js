import { Button, Image } from 'react-bootstrap';
import imgprofile from '../assets/img/img_profile_1.svg';
import "../assets/css/main.css";
import "../assets/css/profile.css";
import { NavLink, } from 'react-router-dom';

export default function Usuario({usuario}) {
    return (

        <div id="profile" className="border-box text-uppercase">
            <div className="d-flex flex-column text-center">
                <h3 className="mt-3">{usuario.userName}</h3>
                <div className="flex-container">
                    <div className="box-img-profile shadow m-2">
                        <Image src={imgprofile} className=""/>
                    </div>
                </div>
                <div id="dataUser">
                    <h5 className="bg-brown" >Usuario</h5>
                    <h6>Nombre</h6><p>{usuario.nombre}</p>
                    <h6>Teléfono</h6><p>{usuario.phone}</p>
                    <h6>Correo</h6><p className="text-lowercase">{usuario.email}</p>
                </div>
                <div className="d-grid gap-2 btn-primary">
                    <Button className="btn-primary" as={NavLink} to={`editarperfil/`}>Editar Perfil</Button>
                </div>
            </div>
        </div>
    )
}

export {Usuario}