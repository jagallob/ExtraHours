export const updateExtraHour = async (registry) => {
  try {
    const options = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    };

    const response = await fetch(
      `http://localhost:8080/extra-hour/${registry}`,
      options
    );

    if (!response.ok) {
      throw new Error(
        `Error al actualizar la hora extra: ${response.statusText}`
      );
    }

    return response.json();
  } catch (error) {
    console.error("Error al actualizar las horas extra:", error);
    throw error;
  }
};
