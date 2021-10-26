import React, {useState, useEffect} from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { toast } from 'react-toastify';
import { obetenerUsuarioPartidos } from '../connection/partidoAcciones';
import Partido from '../components/partidos/Partido';
import PartidosVacio from '../components/utils/PartidosVacio';
import { Spinner } from 'react-bootstrap';

export default function PartidosUsuario() {

    const [fetching, setFetching] = useState(false);
    const fetched = useSelector(state=>state.partidos.fetched);
    const partidos = useSelector(state=>state.partidos.partidos);
    const dispatch= useDispatch();

    useEffect(()=>{

        async function fetchedPartidos(){
            if(!fetched){
                try {
                    setFetching(true);
                    await dispatch(obetenerUsuarioPartidos());
                    setFetching(false);
                } catch (error) {
                    toast.error(
                        error.response.data.message, 
                        {position: toast.POSITION.BOTTOM_CENTER, autoClose:2000}
                    );
                }
            }
        }

        fetchedPartidos();

    }, [dispatch, fetched]);

    return (
        <div>
            <div className="margen-t">
                <h1 className="mi-jumbotron">Mis Entradas</h1>        
            </div>
            {fetching && <Spinner animation="grow" variant="dark" />}  
            {!fetching && partidos.length === 0 &&
                <PartidosVacio texto="No hay entradas disponibles"></PartidosVacio>
            }          
            <div>
                {partidos.map(partido => <Partido key={partido.partidoId} partido={partido} controlesRender={true}></Partido>)}
            </div>
        </div>
    )
}

