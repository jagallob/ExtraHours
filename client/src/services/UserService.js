import axios from "axios";

export const UserService = {
  login: async (email, password) => {
    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });
      if (!response.ok) {
        throw new Error(`Error ${response.status}: ${response.statusText}`);
      }

      const data = await response.json();
      return data;
    } catch (error) {
      console.error("Login error:", error);
      throw error;
    }
  },

  changePassword: async (id, newPassword) => {
    try {
      const token = localStorage.getItem("token");
      const response = await fetch(
        "http://localhost:8080/auth/change-password",
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
          body: JSON.stringify({ id, newPassword }),
        }
      );

      if (!response.ok) {
        throw new Error(`Error ${response.status}: ${response.statusText}`);
      }

      return await response.text();
    } catch (error) {
      console.error("Change password error:", error);
      throw error;
    }
  },
};

export const logout = async () => {
  try {
    const token = localStorage.getItem("token");
    const response = await axios.post(
      "http://localhost:8080/api/logout",
      {},
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }
    );
    localStorage.removeItem("token"); // Eliminar token del almacenamiento local
    return response.data;
  } catch (error) {
    console.error("Logout error:", error);
    throw error;
  }
};
