import React, {useState, useEffect} from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { toast } from 'react-toastify';
import { obetenerUsuarioPartidos } from '../acciones/partidoAcciones';
import Partido from '../components/partidos/Partido';
import PartidosVacio from '../components/utils/PartidosVacio';
import Placeholder from '../components/utils/Placeholder';

export default function DataUsuarios() {

    const [fetching, setFetching] = useState(false);
    const fetched = useSelector(state=>state.data.fetched);
    const data = useSelector(state=>state.data.data);
    const dispatch= useDispatch();

    useEffect(()=>{

        async function fetchedData(){
            if(!fetched){
                try {
                    setFetching(true);
                    await dispatch(obetenerUsuarioData());
                    setFetching(false);
                } catch (error) {
                    toast.error(
                        error.response.data.message, 
                        {position: toast.POSITION.BOTTOM_CENTER, autoClose:2000}
                    );
                }
            }
        }

        fetchedData();

    }, [dispatch, fetched]);

    return (
        <div>
            <div className="margen-t">
                <h1 className="mi-jumbotron">Mis partidos</h1>        
            </div>
            {fetching && <Placeholder></Placeholder>}  
            {!fetching && data.length === 0 &&
                <PartidosVacio texto="No hay partidos disponibles"></PartidosVacio>
            }          
            <div>
                {data.map(data => <Partido key={data.userId} data={data} controlesRender={true}></Partido>)}
            </div>
        </div>
    )
}

