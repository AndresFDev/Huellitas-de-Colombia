import React, {useState, useEffect} from 'react'
import DatosVacio from '../components/utils/DatosVacio';
import { Container, Row, Spinner } from 'react-bootstrap';
import { ENTRADAS_CREADOS_ENDPOINT } from '../helpers/endpoints';
import axios from 'axios';
import Entrada from '../components/entradas/Entrada';

export default function Entradas() {

    const [entradas, setEntradas] = useState([]);
    const [fetching, setFeching] = useState(true);

    useEffect(()=>{
        axios.get(ENTRADAS_CREADOS_ENDPOINT).then(response => {
            setEntradas(response.data);
            setFeching(false);
        }).catch(e => {
            console.error(e);
            setFeching(false);
        })
    }, []);

    return (
        <Container>
            <div className="flex-container">
                <div>
                    <div className="flex-container pb-2">
                        <div id="title" className="flex-container">
                            <div id="title_in" className="flex-container">
                                <h3 className="p-1 pt-2">ÚLTIMAS ENTRADAS</h3>
                            </div>
                        </div>
                    </div>
                    <div className="flex-container">
                        {fetching && <Spinner animation="grow" variant="dark" />}  
                        {!fetching && entradas.length === 0 &&
                            <DatosVacio texto="No hay entradas disponibles"></DatosVacio>
                        }
                    </div>
                    <div className="container flex-container">  
                        <Row>   
                            {entradas.map(entrada => <Entrada key={entrada.entradaId} entrada={entrada} controlesRender={false}></Entrada>)}
                        </Row>
                    </div>
                </div>
            </div>
        </Container>
    )
}