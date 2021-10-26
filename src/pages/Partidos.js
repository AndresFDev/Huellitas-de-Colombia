import axios from 'axios';
import React, {useState, useEffect} from 'react'
import { Spinner } from 'react-bootstrap';
import Partido from '../components/partidos/Partido';
import PartidosVacio from '../components/utils/PartidosVacio';
import { PARTIDOS_CREADOS_ENDPOINT } from '../connection/helpers/endpoints';

export default function Partidos() {

    const [partidos, setPartidos] = useState([]);
    const [fetching, setFeching] = useState(true);

    useEffect(()=>{
        axios.get(PARTIDOS_CREADOS_ENDPOINT).then(response => {
            setPartidos(response.data);
            setFeching(false);
        }).catch(e => {
            console.error(e);
            setFeching(false);
        })
    }, []);

    return (
        <div className="mt-3">
            <div className="flex-container margen-t mb-3">
                <h1 className="mi-jumbotron">Entradas</h1>        
            </div>
            {fetching && <Spinner animation="grow" variant="dark" />}  
            {!fetching && partidos.length === 0 &&
                <PartidosVacio texto="No hay entradas disponibles"></PartidosVacio>
            }          
            <div>
                {partidos.map(partido => <Partido key={partido.partidoId} partido={partido} controlesRender={false}></Partido>)}
            </div>
        </div>
    )
}

