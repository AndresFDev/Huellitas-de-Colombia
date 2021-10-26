import React from 'react'
import { Badge, Button, Card} from 'react-bootstrap'
import { Link, NavLink } from 'react-router-dom'
import { EliminarPartidoButton} from './EliminarPartidoButton'
import moment from 'moment'

function PartidoCard({partido, controlRender}) {
    return (
        <Card className="mt-3 mb-3">
            <Card.Header className="mi-card">
                <div>
                    {partido.jugado ?
                        <Badge className="mi-badge-jugado">
                            Jugado
                        </Badge>
                        :
                        <Badge className="mi-badge-pendiente">
                            Pendiente
                        </Badge>
                    }
                </div>
                {controlRender &&
                    <div>
                        <Button variant="primary" size="sm" className="me-2" as={NavLink} to={`editarpartido/${partido.partidoId}`}
                        >
                            Editar
                        </Button>
                        <EliminarPartidoButton partidoId={partido.partidoId} local={partido.equipoRestModelLocal.nombre} visitante={partido.equipoRestModelVisitante.nombre}/>
                    </div>
                }
            </Card.Header>
            <Card.Body>
                <Card.Title>
                    <Link to={`/partidos/${partido.partidoId}`}>
                    {partido.equipoRestModelLocal.nombre} vs. {partido.equipoRestModelVisitante.nombre}
                    </Link>
                </Card.Title>
                <Card.Text>
                    Fecha: {moment(partido.fecha).format('D[/]MM[/]YYYY')}
                </Card.Text>
                <Card.Text>
                    Creado por {partido.usuarioRestModel.nombre}, {moment(partido.createdAt).fromNow()}
                </Card.Text>
            </Card.Body>
        </Card>
    )
}

export {PartidoCard}
