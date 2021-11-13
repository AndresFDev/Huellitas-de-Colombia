import React, {useState, useEffect} from 'react'
import { Row, Spinner } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { toast } from 'react-toastify';
import { obetenerUsuarioEntradas } from '../acciones/entradaAcciones';
import Entrada from '../components/entradas/Entrada';
import DatosVacio from '../components/utils/DatosVacio';

export default function EntradasUsuario() {

    const [fetching, setFetching] = useState(false);
    const fetched = useSelector(state=>state.entradas.fetched);
    const entradas = useSelector(state=>state.entradas.entradas);
    const dispatch= useDispatch();

    useEffect(()=>{

        async function fetchedEntradas(){
            if(!fetched){
                try {
                    setFetching(true);
                    await dispatch(obetenerUsuarioEntradas());
                    setFetching(false);
                } catch (error) {
                    toast.error(
                        error.response.data.message, 
                        {position: toast.POSITION.BOTTOM_CENTER, autoClose:2000}
                    );
                }
            }
        }

        fetchedEntradas();

    }, [dispatch, fetched]);

    return (
        <div className="flex-container">
            <div>
            <div className="flex-container pb-2">
                <div id="title_2" className="flex-container">
                    <div id="title_in" className="flex-container">
                        <h3 className="pt-3">MIS ENTRADAS</h3>
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
                        {entradas.map(entrada => <Entrada key={entrada.entradaId} entrada={entrada} controlesRender={true}></Entrada>)}
                    </Row>
                </div>
            </div>    
        </div>
    )
}