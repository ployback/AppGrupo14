package pe.edu.cibertec.t2.retrofit.response

data class RecipeResponse(
    val recipes: List<Recipe>
)

data class Recipe(
    val id: Int,
    val name: String,
    val prepTimeMinutes: Int,
    val difficulty: String,
    val cuisine: String
)