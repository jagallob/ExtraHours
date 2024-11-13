export const deleteExtraHour = async (registry) => {
  try {
    const options = {
      method: "DELETE",
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
        `Error al eliminar la hora extra: ${response.statusText}`
      );
    }

    return response.json();
  } catch (error) {
    console.error("Error al eliminar las horas extra:", error);
    throw error;
  }
};
