import React from 'react'
import imgdatosvacio from '../../assets//img/logo_c.svg'

export default function DatosVacio({texto}) {
    return (
        <div className="img-partidos-vacio">
            <div>
                <object type="image/svg+xml" data={imgdatosvacio}>
                    Error al cargar svg
                </object>
                <p>{texto}</p>
            </div>
        </div>
    )
}


