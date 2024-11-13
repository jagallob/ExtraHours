export const approveExtraHour = async (registry) => {
  try {
    const response = await fetch(
      `http://localhost:8080/api/extra-hour/${registry}/approve`,
      {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
      }
    );

    if (!response.ok) {
      throw new Error(`Error al aprobar el registro: ${response.statusText}`);
    }

    return response.json();
  } catch (error) {
    console.error("Error al aprobar el registro:", error);
    throw error;
  }
};
