import React from 'react';
import { Container, Image, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { useSelector, useDispatch } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { cerrarSesion } from '../connection/autenticacionAcciones';
import user_photo from '../img/ej.jpg';
import "../css/main.css";
import "../css/font.css";
import "../css/nav.css";
import '../js/bgChange';
import logo from '../img/logo_huella_w.svg';

export default function Navegation() {

    const conectado = useSelector(state=>state.auth.conectado);
    const usuario = useSelector(state=>state.auth.usuario);
    const dispatch = useDispatch();

    return (
        <Navbar bg="dark" variant="dark" expand="lg" className="d-flex rounded-bottom">
            <Container className="container-fluid">
                <Navbar.Brand as={NavLink} to={'/'}>
                    <Image src={logo} width="30" height="30" className="d-inline-block align-top" alt="Logo" />  
                </Navbar.Brand>
                <Navbar.Toggle className="navbar navbar-expand-lg" aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto align-left">
                        <Nav.Link as={NavLink} to={'/'}>INICIO</Nav.Link>
                        <Nav.Link as={NavLink} to={'/buscados'}>BUSCADOS</Nav.Link>
                        <Nav.Link as={NavLink} to={'/encontrados'}>ENCONTRADOS</Nav.Link>
                        <Nav.Link as={NavLink} to={'/adoptame'}>ADOPTAME</Nav.Link>
                        <Nav.Link as={NavLink} to={'/jornadas'}>JORNADAS</Nav.Link>
                        <Nav.Link as={NavLink} to={'/nosotros'}>NOSOTROS</Nav.Link>
                    </Nav>
                    <Nav className="me-auto">
                        {conectado && 
                            <Nav.Link as={NavLink} to={'/crearpartido'}>Crear partido</Nav.Link>
                        }                        
                    </Nav>
                    <Nav>
                        {!conectado ? (
                        <React.Fragment>
                            <Nav.Link id="main" as={NavLink} to={'/registro'}>REGISTRO</Nav.Link>
                            <Nav.Link as={NavLink} to={'/login'}>INICIAR SESION</Nav.Link>
                        </React.Fragment>
                        ):(
                            
                            <div className="flex-container">
                                <Navbar.Brand as={NavLink} to={'/'}>
                                    <div className="img-container-nav">
                                    <Image src={user_photo} className="d-inline-block align-top" alt="user_photo" />  
                                    </div>
                                </Navbar.Brand>
                                <NavDropdown title={usuario.sub} id="basic-nav-dropdown">
                                    <NavDropdown.Item as={NavLink} to={'/partidos'}>MI PERFIL</NavDropdown.Item>
                                    <NavDropdown.Item as={NavLink} to={'/perfil'}>Perfil</NavDropdown.Item>
                                    <NavDropdown.Item as={NavLink} to={'/editarperfil'}>Editar Perfil</NavDropdown.Item>
                                    <NavDropdown.Item as={NavLink} to={'/editarpartido'}>MODIFICAR PERFIL</NavDropdown.Item>
                                    <NavDropdown.Item as={NavLink} to={'/partidos/:id'}>MIS ENTRADAS</NavDropdown.Item>
                                    <NavDropdown.Item as={NavLink} to={'/crearpartido'}>MIS ENTRADAS2</NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    <NavDropdown.Item onClick={() => dispatch(cerrarSesion())}>CERRAR SESION</NavDropdown.Item>
                                </NavDropdown>  
                            </div>
                        )}
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}