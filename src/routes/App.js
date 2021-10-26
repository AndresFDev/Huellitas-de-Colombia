import '../css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Header } from '../layouts/Header';
import Navegation from '../layouts/Navegation';
import { BrowserRouter , Switch, Route} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Partidos from '../pages/Partidos';
import SignIn from '../pages/SignIn';
import { SignUp } from '../pages/SignUp';
import PartidoDetalles from '../pages/PartidoDetalles';
import PartidosUsuario from '../pages/PartidosUsuario';
import NuevopPartido from '../pages/NuevoPartido';
import EditarPartido from '../pages/EditarPartido';
import RoutePrivate from './RoutePrivate';
import { Provider } from 'react-redux';
import store from '../store'
import moment from 'moment'
import 'moment/locale/es'
import comprobarToken from '../connection/helpers/comprobarToken'
import { Perfil } from '../pages/Perfil';
import { EditarPerfil } from '../pages/EditarPerfil';
import { Footer } from '../layouts/Footer';
import '../css/main.css'
import '../css/nav.css'
import '../js/nav'
import { Fragment } from 'react';

moment.locale('es');

comprobarToken();

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <div id="bg" className="bg-main">
          <div className="banner-header">
            <Header />
          </div>
          <div id="navbar">
            <Navegation />
          </div>
          <Container>
            <Switch>
              <Route exact path="/" component={Partidos}></Route>
              <Route exact path="/login" component={SignIn}></Route>
              <Route exact path="/registro" component={SignUp}></Route>
              <Route exact path="/partidos/:id" component={PartidoDetalles}></Route>
              <Route exact path="/perfil" component={Perfil}></Route>
              <Route exact path="/editarperfil" component={EditarPerfil}></Route>
              <RoutePrivate exact path="/partidos" component={PartidosUsuario}></RoutePrivate>
              <RoutePrivate exact path="/crearpartido" component={NuevopPartido}></RoutePrivate>
              <RoutePrivate exact path="/editarpartido/:id" component={EditarPartido}></RoutePrivate>
            </Switch>
          </Container>
          <div>
            {/* <Image src="../img/ej.jpg" fluid /> */}
          </div>
          <div className="mt-3">
            <Footer />
          </div>
        </div>
        <Fragment>

        </Fragment>        
      </BrowserRouter>
    </Provider>
  );
}

export default App;
