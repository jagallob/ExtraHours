import { createContext, useState, useContext, useEffect } from "react";
import PropTypes from "prop-types";
import { useNavigate } from "react-router-dom";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const navigate = useNavigate();
  const [auth, setAuth] = useState(() => {
    const token = localStorage.getItem("token");
    const role = localStorage.getItem("role");
    return token && role ? { token, role } : null;
  });

  useEffect(() => {
    const token = localStorage.getItem("token");
    const role = localStorage.getItem("role");
    if (token && role) {
      setAuth({ token, role });
    }
  }, []);

  const login = ({ token, role }) => {
    setAuth({ token, role });
    localStorage.setItem("token", token);
    localStorage.setItem("role", role);
  };

  const logout = () => {
    setAuth(null);
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    navigate("/");
  };

  return (
    <AuthContext.Provider value={{ auth, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

AuthProvider.propTypes = {
  children: PropTypes.node.isRequired,
};

// Hook para usar el contexto de autenticación
export const useAuth = () => {
  return useContext(AuthContext);
};
