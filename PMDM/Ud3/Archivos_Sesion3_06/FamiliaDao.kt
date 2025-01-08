
@Dao
interface FamiliaDao {

    // Insertar una familia
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFamilia(familia: Familia): Long

    // Obtener todas las familias
    @Query("SELECT * FROM familias")
    suspend fun getAllFamilias(): List<Familia>

    // Buscar familia por ID
    @Query("SELECT * FROM familias WHERE id = :familiaId")
    suspend fun getFamiliaById(familiaId: Int): Familia?

    // Actualizar una familia
    @Update
    suspend fun updateFamilia(familia: Familia)

    // Eliminar una familia
    @Delete
    suspend fun deleteFamilia(familia: Familia)
}