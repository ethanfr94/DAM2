

@Dao
interface AnimalDao {

    // Insertar un animal
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimal(animal: Animal)

    // Obtener todos los animales
    @Query("SELECT * FROM animales")
    suspend fun getAllAnimales(): List<Animal>

    // Buscar animal por ID
    @Query("SELECT * FROM animales WHERE id = :animalId")
    suspend fun getAnimalById(animalId: Int): Animal?

    // Actualizar un animal
    @Update
    suspend fun updateAnimal(animal: Animal)

    //Actualización personalizada
    @Query("UPDATE animales SET familia_id = :nuevoFamiliaId WHERE id = :animalId")
    suspend fun updateFamiliaIdInAnimal(animalId: Int, nuevoFamiliaId: Int)

    // Eliminar un animal
    @Delete
    suspend fun deleteAnimal(animal: Animal)
}