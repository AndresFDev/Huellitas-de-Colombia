import React from 'react';
import { Container, Image, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { cerrarSesion } from '../acciones/autenticacionAcciones';
import user_photo from '../assets/img/img_profile_1.svg';
import "../assets/css/main.css";
import "../assets/css/font.css";
import "../assets/css/nav.css";
import logo from '../assets/img/logo_huella_w.svg';

export default function Navegacion({entrada}) {

    const conectado = useSelector(state=>state.auth.conectado);
    const usuario = useSelector(state=>state.auth.usuario);
    const dispatch = useDispatch();

    return (
        <Navbar collapseOnSelect stiky="top" bg="dark" variant="dark" expand="lg" className="d-flex rounded-bottom">
            <Container className="container-fluid">
                <Navbar.Brand as={NavLink} to={'/'}>
                    <Image src={logo} width="30" height="30" className="d-inline-block align-top" alt="Logo" />  
                </Navbar.Brand>
                <Navbar.Toggle className="navbar navbar-expand-lg" aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto align-left">
                        <Nav.Link as={NavLink} to={'/'}>INICIO</Nav.Link>
                        <Nav.Link as={NavLink} to={'/nosotros'}>NOSOTROS</Nav.Link>
                        {/* {conectado && 
                            <Nav.Link as={NavLink} to={'/crearentrada'}>CREAR ENTRADA</Nav.Link>
                        } */}
                    </Nav>
                    <Nav>
                        {!conectado ? (
                        <React.Fragment>
                            <Nav.Link as={NavLink} to={'/registro'}>REGISTRO</Nav.Link>
                            <Nav.Link as={NavLink} to={'/login'}>INICIAR SESION</Nav.Link>
                        </React.Fragment>
                        ):(
                            <React.Fragment>
                                <div className="flex-container flex-row align-items-center">
                                    <div id="plus-c" type="button">
                                        <div id="plus-c_in" className="text-center" as={NavLink} to={'/crearentrada'}>
                                            +
                                        </div>
                                    </div>
                                    <div id="ce">
                                        <div className="m-1">
                                            <Nav.Link as={NavLink} to={'/crearentrada'}>CREAR ENTRADA</Nav.Link>
                                        </div>
                                    </div>
                                </div>
                                <div className="flex-container align-items-center">
                                    <div className="img-container-nav shadow m-1" as={NavLink} to={'/perfil'}>
                                        <Image src={user_photo} className="d-inline-block align-middle" alt="user_photo" />  
                                    </div>
                                    <NavDropdown title={usuario.sub + ' '} id="basic-nav-dropdown" className="text-uppercase">
                                        <NavDropdown.Item as={NavLink} to={'/perfil'}>PERFIL</NavDropdown.Item>
                                        <NavDropdown.Item as={NavLink} to={'/editarperfil'}>EDITAR PERFIL</NavDropdown.Item>
                                        <NavDropdown.Item as={NavLink} to={'/entradas'}>MIS ENTRADAS</NavDropdown.Item>
                                        <NavDropdown.Item as={NavLink} to={'/crearentrada'}>CREAR ENTRADA</NavDropdown.Item>
                                        <NavDropdown.Divider />
                                        <NavDropdown.Item onClick={() => dispatch(cerrarSesion())}>CERRAR SESION</NavDropdown.Item>
                                    </NavDropdown>  
                                </div>
                            </React.Fragment>
                        )}
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}
