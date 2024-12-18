export const deleteExtraHour = async (registry) => {
  try {
    const response = await fetch(
      `http://localhost:8080/api/extra-hour/${registry}/delete`,
      {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
      }
    );

    if (!response.ok) {
      throw new Error(`Error al eliminar el registro: ${response.statusText}`);
    }
  } catch (error) {
    console.error("Error al eliminar el registro:", error);
    throw error;
  }
};
