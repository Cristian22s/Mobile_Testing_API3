package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun `Dado un listado de productos, validar que la informacion se pueda mostrar en pantalla`() {
        // Preparar datos de prueba
        val activity = MainActivity()
        val productos = listOf(
            Product(
                id = 1,
                name = "Product A",
                description = "This is a sample product.",
                price = 10.99,
                currency = "USD",
                in_stock = true
            ),
            Product(
                id = 2,
                name = "Product B",
                description = "Another sample product with a longer description.",
                price = 25.50,
                currency = "EUR",
                in_stock = false
            )
        )

        // Ejecutar método
        val resultado = activity.obtenerListadoProductos(productos)

        // Validar resultados
        assertEquals(
            """
            ID: 1, Nombre: Product A
            ID: 2, Nombre: Product B
            """.trimIndent(),
            resultado
        )
    }

    @Test
    fun `Cuando el listado este vacio, validar que no se pueda mostrar informacion en pantalla`() {
        // Preparar datos de prueba
        val activity = MainActivity()
        val productos = emptyList<Product>()

        // Ejecutar método
        val resultado = activity.obtenerListadoProductos(productos)

        // Validar resultados
        assertEquals("No hay productos disponibles", resultado)
    }
}