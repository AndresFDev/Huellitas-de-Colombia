import moment from 'moment'
import React from 'react'
import { Badge, Button, Card } from 'react-bootstrap'
import { Link, NavLink } from 'react-router-dom'
import EliminarPartidoButton from './botones/EliminarUsuarioButton'

export default function Usuario({usuario, controlesRender}) {
    return (
        <Card className="margen-t margen-b">
            <Card.Header className="mi-card">
                <div>
                    {usuario.jugado ?                             
                        <Badge className="mi-badge-jugado">
                            Jugado
                        </Badge> 
                        :
                        <Badge className="mi-badge-pendiente">
                            Pendiente
                        </Badge>                            
                    }
                </div>
            {controlesRender &&
                <div>
                    <Button 
                        variant="primary" size="sm" className="margen-e"
                        as={NavLink} to={`editarusuario/${usuario.userId}`}
                    >
                        Editar
                    </Button>
                    <EliminarUsuarioButton userId={usuario.userId} nombre={usuario.nombre} userName={usuario.userName} email={usuario.email} phone={usuario.phone}></EliminarUsuarioButton>
                </div>
            }
            </Card.Header>
            <Card.Body>
                <Card.Title>
                    <Link to={`/usuarios/${usuario.userId}`}> {usuario.nombre} vs {usuario.userName} </Link>
                </Card.Title>                    
                <Card.Text>
                    Creado por {usuario.email}, {usuario.phone}
                </Card.Text>            
            </Card.Body>
        </Card>
    )
}