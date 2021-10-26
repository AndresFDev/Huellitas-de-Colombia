import { Container, Image } from "react-bootstrap"
import "../css/main.css"
import head_img from "../img/logo_t_w.svg"

function Header() {

    return(
        <Container className="flex-container bg-head">
          <div className="left-head">
            <span><a className="hover-none text-center" href="/"><Image src={head_img} className="w-100"/></a></span>
          </div>
        </Container>
    )
}

export {Header}