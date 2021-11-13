import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { Provider } from 'react-redux';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Navegacion from './layouts/Navegacion';
import Signin from './pages/Signin';
import store from "./store";
import comprobarToken from './helpers/comprobarToken';
import RutaPrivada from './utils/RutaPrivada';
import Signup from './pages/Signup';
import { ToastContainer } from "react-toastify";
import moment from "moment";
import { EditarPerfil } from './pages/EditarPerfil';
import { Header } from './layouts/Header';
import { Footer } from './layouts/Footer';
import { Nosotros } from './pages/Nosotros';
import Perfil from './pages/Perfil';
import { Fragment } from 'react';
import EntradaDetalles from './pages/EntradaDetalles';
import EntradasUsuario from './pages/EntradasUsuario';
import Entradas from './pages/Entradas';
import 'react-toastify/dist/ReactToastify.min.css';
import "react-confirm-alert/src/react-confirm-alert.css";
import 'moment/locale/es'
import './assets/css/main.css'
import './assets/css/nav.css'
import EditarEntrada from './pages/EditarEntrada';
import NuevoeEntrada from './pages/NuevoEntrada';
// import './assets/js/nav'

moment.locale('es')

comprobarToken();

function App() {
  return (
    <Provider store={store}>
       <BrowserRouter>
        <div className="bg-main">
          <div className="banner-header">
            <Header />
          </div>
          <Fragment>
            <div id="navbar">
            <Navegacion/>
          </div>
          </Fragment>
          <Container>
          <ToastContainer/>
            <Switch>
                <Route exact path="/" component={Entradas}></Route>
                <Route exact path="/login" component={Signin}></Route>
                <Route exact path="/nosotros" component={Nosotros}></Route>
                <RutaPrivada exact path="/nosotros" component={Nosotros}></RutaPrivada>
                <Route exact path="/registro" component={Signup}></Route>
                <Route exact path="/entradas/:id" component={EntradaDetalles}></Route>
                <RutaPrivada exact path="/entradas" component={EntradasUsuario}></RutaPrivada>
                <RutaPrivada exact path="/crearentrada" component={NuevoeEntrada}></RutaPrivada>
                <RutaPrivada exact path="/editarentrada/:id" component={EditarEntrada}></RutaPrivada>
                <RutaPrivada exact path="/perfil" component={Perfil}></RutaPrivada>
                <RutaPrivada exact path="/editarperfil" component={EditarPerfil}></RutaPrivada>
              </Switch>
          </Container>
          <div className="mt-3">
            <Footer />
          </div>
        </div>
      </BrowserRouter>
    </Provider>    
  );
}

export default App;
