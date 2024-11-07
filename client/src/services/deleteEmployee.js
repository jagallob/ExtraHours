export const deleteEmployee = async (id) => {
  try {
    const response = await fetch(`http://localhost:8080/api/employee${id}`, {
      method: "DELETE",
    });
    if (!response.ok) throw new Error("Error al eliminar empleado");
    return await response.json();
  } catch (error) {
    console.error(error);
    throw error;
  }
};
