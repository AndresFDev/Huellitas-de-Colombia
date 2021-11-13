import { Container, Image } from "react-bootstrap"
import "../assets/css/nosotros.css"
import ped_1 from "../assets/img/ped_1.jpg"
import ped_2 from "../assets/img/ped_2.jpg"

function Nosotros() {

    return (
        <Container id="nosotros" className="contenedor">
            <div className="flex-container pb-2">
                    <div id="title" className="flex-container">
                        <div id="title_in" className="flex-container">
                            <h3 className="p-1 pt-2">NOSOTROS</h3>
                        </div>
                    </div>
                </div>
            <div className="row-p_me p-64_me container_me border-n-b gb-c-b mt-2">
                <div className="d-flex content_me">
                    <div className="d-flex flex-column twothird_me">
                        <h1>Problemática</h1>
                        <h5 className="p p-32_me">
                            Diariamente, se calcula que se extravían aproximadamente entre 10 y 20 animales de compañía, 
                            entre perros y gatos, solamente en Bogotá. Sin embargo, se estima que esta cifra puede ser mayor, 
                            no solo al contabilizar el resto de las ciudades de Colombia, sino también porque muchas personas no saben cómo o dónde pueden reportar la pérdida o extravío de su mascota.
                            Por fortuna, y también por ausencia de reportes, estas cifras no llegan a ser tan alarmantes como las de México, Perú o
                            España en donde el número de perros y gatos perdidos se encuentra entre los 200.000 y los 500.000 cada año.
                            Las personas deben adoptar mascotas por dos razones principales: la primera es darle una segunda oportunidad a los animales que
                            han sufrido por diferentes situaciones y la segunda es porque en el país “las leyes para los criaderos y tiendas de mascotas
                            son mínimas, entonces la gran mayoría son lugares en donde se comercia con la vida”.
                        </h5>
                        {/* <p className="p text-grey">
                            En nuestra sección de historia te conduciremos a través de nuestros muchos y épicos triunfos, de nuestras horas más oscuras –superadas pero nunca olvidadas– y te narraremos las historias que se esconden detrás de muchas leyendas individuales y conjuntos talentosos, que sirvieron a este gran club con honor y distinción desde su fundación en 1878.
                        </p> */}
                    </div>
                    <div className="d-flex align-content-center flex-wrap third_me center_me">
                        <i className="fa p-64_me">
                            <div className="card-img-top img-container-card-v shadow m-5">
                                <Image src={ped_1} alt="..." />
                            </div>
                        </i>
                    </div>
                </div>
            </div>
            <div className="row-p_me p-64_me container_me border-n-g gb-c-bl mt-5">
                <div className="d-flex content_me">
                    <div className="d-flex flex-column align-content-center flex-wrap third_me center_me">
                        <i className="fa p-64_me">
                            <div className="card-img-top img-container-card-h shadow m-5">
                                <Image src={ped_2} alt="..." />
                            </div>
                        </i>
                    </div>
                    <div className="d-flex flex-column twothird_me">
                        <h1 className="text-r">¿Porqué nació Huellitas de Colombia?</h1>
                        <h5 className="p p-32_me">
                            Existen pocos lugares donde atienden requerimientos de perdida de mascotas a nivel nacional, generalmente, la única
                            forma de dar relevancia al extravío de una mascota son las redes sociales, las cuales no son una fuente fiable de consulta
                            o de reporte de este problema. Además, las jornadas de vacunación o recreación para nuestras mascotas en general pasan
                            desapercibidas ante la falta de exposición de las mismas. También, la adopción animal se fragmenta en diversas
                            fundaciones y no existe un lugar donde se pueda encontrar esta información de manera unificada
                        </h5>
                        {/* <p className="p text-grey">
                            Entre sus 66 importantes trofeos figura un récord de 20 títulos de la máxima categoría, y nosotros fuimos el primer club inglés en ganar la Copa Europea en 1968. 
                            Puedes leer toda la información sobre nuestros trofeos –desde el título de la primera división en 1908 hasta la Europa League de 2017– en las páginas de abajo.
                        </p> */}
                    </div>
                </div>
            </div>
        </Container>
    )
   
}

export {Nosotros}