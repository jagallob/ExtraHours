import axios from "axios";
import jwtDecode from "jwt-decode";

const getManagerIdFromToken = () => {
  try {
    const token = localStorage.getItem("token");
    if (!token) {
      throw new Error("Token no encontrado en localStorage.");
    }
    const decoded = jwtDecode(token);
    if (!decoded.manager_id) {
      throw new Error("El token no contiene el campo manager_id.");
    }
    return decoded.manager_id;
  } catch (error) {
    console.error("Error al decodificar el token:", error.message);
    throw error;
  }
};

export const fetchEmployeesByManager = async () => {
  try {
    const managerId = getManagerIdFromToken();
    const response = await axios.get(
      `http://localhost:8080/api/employee/manager/${managerId}`
    );
    return response.data; // Devuelve la lista de empleados
  } catch (error) {
    console.error("Error al obtener los empleados:", error.message);
    throw error;
  }
};

(async () => {
  try {
    const managerId = getManagerIdFromToken();
    const employees = await fetchEmployeesByManager(managerId);
    console.log("Empleados gestionados por el manager:", employees);
  } catch (error) {
    console.error("Error general al obtener los empleados:", error.message);
  }
})();
