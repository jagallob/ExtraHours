// export const findExtraHourByDateRange = async (startDate, endDate) => {
//   try {
//     const url = `http://localhost:8080/api/extra-hour?startDate=${startDate}&endDate=${endDate}`;
//     const response = await fetch(url);
//     const data = await response.json();

//     return data;
//   } catch (error) {
//     console.error(error);
//     throw error;
//   }
// };

export const findExtraHourByDateRange = async (startDate, endDate) => {
  try {
    const token = localStorage.getItem("token");
    const response = await fetch(
<<<<<<< Updated upstream
      `http://localhost:8080/api/extra-hour?startDate=${startDate}&endDate=${endDate}`,
=======
      `http://localhost:8080/api/extra-hour/date-range-with-employee?startDate=${startDate}&endDate=${endDate}`,
>>>>>>> Stashed changes
      {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
      }
    );

    if (!response.ok) {
      throw new Error("Error al obtener la información de rango de fechas");
    }

    const data = await response.json();

    return data.map((record) => ({
      ...record.extraHour,
      ...record.employee,
    }));
  } catch (error) {
    console.error("Error al buscar fecha:", error);

    throw error;
  }
};
