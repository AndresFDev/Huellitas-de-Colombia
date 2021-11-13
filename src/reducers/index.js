
import { combineReducers } from 'redux';
import autenticacionReducer from './autenticacionReducer'
import usuarioEntradaReducer from "./usuarioEntradaReducer";
import usuarioReducer from './usuarioReducer';

export default combineReducers({
    auth: autenticacionReducer,
    entradas: usuarioEntradaReducer,
    usuarios: usuarioReducer
});