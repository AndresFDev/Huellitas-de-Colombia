import React from 'react'
import imgpartidosvacio from '../../img/logo_c.svg'

export default function PartidosVacio({texto}) {
    return (
        <div className="flex-container img-partidos-vacio">
            <div>
                <object type="image/svg+xml" data={imgpartidosvacio}>
                    Error al cargar svg
                </object>
                <p>{texto}</p>
            </div>
        </div>
    )
}


