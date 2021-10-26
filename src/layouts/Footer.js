import React from 'react';
import { Col, Container, Image, Row } from 'react-bootstrap';
import "../css/main.css";
import "../css/font.css";
import "../css/nav.css";
import "../css/footer.css";
import logo from "../img/logo_only_t_w.svg"


function Footer() {

    return (

        <Container id="footer" className="padding-64 text-center p-3">
            <Row>
                <Col />
                <Col>
                <div className="xlarge padding-32 size-25">
                    <a href="https://es-la.facebook.com/huellitasdecolombia/" ><i className="fa fa-facebook text-white hover-rs m-1"></i></a>
                    <a href="https://www.instagram.com/huellitasofficial/" ><i className="fa fa-instagram text-white hover-rs m-1"></i></a>
                    <a href="https://twitter.com/huellitasdecolombia/" ><i className="fa fa-twitter text-white hover-rs m-1"></i></a>
                    <a href="https://www.youtube.com/channel/UC6yW44UGJJBvYTlfC7CRg2Q"><i className="fa fa-youtube text-white hover-rs m-1"></i></a>
                    <a href="https://mx.pinterest.com/huellitasdecolombia/" ><i className="fa fa-pinterest-p text-white hover-rs m-1"></i></a>
                    <a href="https://es.linkedin.com/company/huellitasdecolombia/"><i className="fa fa-linkedin text-white hover-rs m-1"></i></a><br />
                </div>
                <div>
                    <a href="https://www.huellitasdecolombia.co/nosotros.html" className="hover-none"> <Image src={logo} className="w-75" /></a>
                    <p className="small text-white">© 2021 <a className="hover-rs text-white pb-3" href="../pages/nosotros.html">Huellitas de Colombia</a></p>
                </div>
                </Col>
                <Col/>
            </Row>
        </ Container>
    )
}

export {Footer}