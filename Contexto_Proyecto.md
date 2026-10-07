# Contexto del Proyecto: AppFragmentsRestApi

## 1. Configuración del Proyecto y Gradle
* **Lenguaje:** Kotlin
* **Namespace (Application ID):** `pe.edu.cibertec.appfragmentsrestapi`
* **Versiones de SDK:** `minSdk = 24`, `targetSdk = 37`, `compileSdk = 37`
* **Compatibilidad Java:** Java 11.
* **ViewBinding:** Habilitado (`viewBinding { enable=true }`) a nivel de aplicación.

## 2. Dependencias y Librerías Principales
El proyecto tiene configuradas las siguientes tecnologías clave:
* **UI y Layouts:** `ConstraintLayout`, `RecyclerView`, `Material Components`.
* **Navegación:** Jetpack Navigation Component (manejo de Fragments y `BottomNavigationView`).
* **Consumo de API REST:**
  * Retrofit 3.0.0
  * Convertidor GSON 3.0.0
  * Cliente OkHttp configurado con Timeouts (1 minuto de connect, 30 segundos de read/write).
* **Carga de Imágenes:** Glide 5.0.9.

## 3. Estructura de Paquetes (`pe.edu.cibertec.appfragmentsrestapi`)
* **Raíz:** Contiene el `MainActivity` y los cuatro Fragments de la navegación (`HomeFragment`, `RegistroFragment`, `PersonajesFragment`, `UsuariosFragment`).
* **`adapter/`:** Contiene `PersonajeAdapter.kt` y `UsuarioAdapter.kt` para poblar los RecyclerViews.
* **`retrofit/`:**
  * Clientes generadores de Retrofit: `ClientePersonajeRetrofit` (apunta a *https://rickandmortyapi.com/api/*) y `ClientePlaceholderRetrofit`.
  * **`api/`:** Interfaces con endpoints (`IPersonajeService` para `GET "character"`, y `IUsuarioService`).
  * **`response/`:** Modelos de datos para Gson (`Personaje`, `ResultPersonaje`).

## 4. Estado Actual de la Interfaz de Usuario
* **`MainActivity` y Navegación:** Emplea `ActivityMainBinding`. Tiene un contenedor de navegación (`NavHostFragment`) y un menú inferior (`BottomNavigationView`) enlazado dinámicamente con el grafo de navegación. Soporta diseño "Edge-to-Edge" (pantalla completa ajustada a los insets del sistema).
* **`PersonajesFragment`:** Ya implementa ViewBinding (`FragmentPersonajesBinding`). Su diseño consta de un `ConstraintLayout` con un `RecyclerView` listo para listar personajes.
* **`RegistroFragment` (Ideal para tus próximos cambios):** Su clase Kotlin aún está generada por defecto y no utiliza ViewBinding (usa el `inflater` clásico). Su archivo `fragment_registro.xml` tiene la etiqueta raíz `ConstraintLayout`, pero actualmente está vacío en su interior.

## 5. Observaciones Importantes (Riesgos detectados)
* **Permiso de Internet Faltante:** En tu `AndroidManifest.xml` no se ha declarado explícitamente el permiso de conexión. Cuando intentes ejecutar las llamadas con Retrofit, la app arrojará un error de seguridad (SecurityException). Debemos agregar `<uses-permission android:name="android.permission.INTERNET" />`.
* **ViewBinding a medias:** Algunos fragmentos (como `PersonajesFragment`) ya aprovechan ViewBinding correctamente mediante `_binding` y `binding.root`, pero otros (como `RegistroFragment`) están pendientes de migración.
