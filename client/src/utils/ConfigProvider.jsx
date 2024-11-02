import { createContext, useContext, useEffect, useState } from "react";
import PropTypes from "prop-types";

/**
 * ConfigContext proporciona el estado de configuración para el cálculo de horas extra
 * en la aplicación. Incluye multiplicadores y horarios de trabajo.
 */

const ConfigContext = createContext();

/**
 * ConfigProvider es un componente que envuelve a su hijo y proporciona acceso
 * al contexto de configuración a través de su valor.
 */

export const ConfigProvider = ({ children }) => {
  const [config, setConfig] = useState({
    diurnalMultiplier: 1.25,
    nocturnalMultiplier: 1.75,
    diurnalHolidayMultiplier: 2,
    nocturnalHolidayMultiplier: 2.5,
    diurnalStart: "06:00",
    diurnalEnd: "21:00",
  });
  useEffect(() => {
    const fetchConfig = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/config");
        const data = await response.json();
        setConfig(data);
      } catch (error) {
        console.error("Error fetching configuration:", error);
      }
    };
    fetchConfig();
  }, []);

  return (
    <ConfigContext.Provider value={{ config, setConfig }}>
      {children}
    </ConfigContext.Provider>
  );
};

ConfigProvider.propTypes = {
  children: PropTypes.node.isRequired,
};

export const useConfig = () => useContext(ConfigContext);
