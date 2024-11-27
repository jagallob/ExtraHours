import { useNavigate, Outlet, useLocation } from "react-router-dom";
import { Link } from "react-router-dom";
import logoamadeus from "../../assets/images/logoamadeus.png";
import "./SettingsPage.scss";
import Parametros from "../../assets/images/Parametros.png";
import Eliminar from "../../assets/images/Eliminar.png";
import Regresar from "../../assets/images/Regresar.png";
import Agregar from "../../assets/images/Agregar.png";

const SettingsPage = () => {
  const navigate = useNavigate();
  const location = useLocation();

  // Verificar si estamos en una subpágina
  const isSubPage = location.pathname !== "/settings";

  return (
    <div>
      <header className="page__header">
        <Link to="/menu">
          <img className="logoamadeus" src={logoamadeus} alt="Logo Amadeus" />
        </Link>
      </header>
      <div className="settingsMenu">
        <h1>Configuraciones</h1>
        {isSubPage ? (
          <div className="mini-icons">
            <div onClick={() => navigate("/settings")}>
              <img className="regresar" src={Regresar} alt="Inicio" />
              <p>Regresar</p>
            </div>
          </div>
        ) : (
          // Mostrar el menú principal si no estamos en una subpágina
          <div className="grid">
            <div
              className="menu-item"
              onClick={() => navigate("/settings/ExtraHoursSettings")}
            >
              <div id="imgagregar">
                <img src={Parametros} alt="Engranage" />
              </div>
              <p>Parámetros Horas Extra</p>
            </div>
            <div
              className="menu-item"
              onClick={() => navigate("/settings/PersonalSettings")}
            >
              <img src={Agregar} alt="Ícono de perfil con engranage" />
              <p>Agregar Empleado</p>
            </div>
            <div
              className="menu-item"
              onClick={() => navigate("/settings/UpdateDeletePersonal")}
            >
              <img src={Eliminar} alt="ïcono de más (+)" />
              <p>Actualizar ó Eliminar Personal</p>
            </div>
          </div>
        )}
        <Outlet />
      </div>
    </div>
  );
};

export default SettingsPage;
