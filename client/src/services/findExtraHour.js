// export const findExtraHour = async (identifier, type = "registry") => {
//   try {
//     const url =
//       type === "id"
//         ? `http://localhost:8080/api/extra-hour/id/${identifier}`
//         : `http://localhost:8080/api/extra-hour/registry/${identifier}`;

//     const token = localStorage.getItem("token");

//     const response = await fetch(url, {
//       method: "GET",
//       headers: {
//         "Content-Type": "application/json",
//         Authorization: `Bearer ${token}`,
//       },
//     });

//     if (!response.ok) {
//       throw new Error(`Error HTTP! Status: ${response.status}`);
//     }

//     const data = await response.json();
//     return data;
//   } catch (error) {
//     console.error("Error en findExtraHour:", error);
//     throw error;
//   }
// };

export const findExtraHour = async (employeeId) => {
  try {
    const token = localStorage.getItem("token");
    if (!token) {
      console.error("Token no encontrado en localStorage");
      return;
    }

    const response = await fetch(
      `http://localhost:8080/api/extra-hour/id/${employeeId}`,
      {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
      }
    );

    if (!response.ok) {
      throw new Error("Error al obtener la información de horas extras por id");
    }

    const data = await response.json();

    return data;
  } catch (error) {
    console.error("Error al buscar id:", error);

    throw error;
  }
};
