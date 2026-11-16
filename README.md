# Regresión Lineal Simple por Mínimos Cuadrados

Práctica de la Unidad 5 de **Métodos Numéricos**.
Implementa la regresión lineal simple con el método de mínimos cuadrados, el coeficiente de correlación de Pearson (r) y el coeficiente de determinación (r²).

## Acerca del tema

La **regresión lineal simple** es una técnica estadística que modela la relación entre dos variables: una variable independiente **X** (la que se conoce o se controla) y una variable dependiente **Y** (la que se quiere explicar o predecir). El modelo asume que esa relación se puede representar con una recta:

```
Y = β0 + β1·X
```

donde **β0** es la ordenada al origen (el valor de Y cuando X = 0) y **β1** es la pendiente (cuánto cambia Y por cada unidad que aumenta X).

El **método de mínimos cuadrados** calcula los valores de β0 y β1 que producen la recta que mejor se ajusta a los datos. Lo hace minimizando la suma de los cuadrados de los errores, es decir, de las diferencias entre los valores reales de Y y los valores estimados por la recta.

Para saber qué tan bueno es el ajuste se usan dos indicadores:

- **Coeficiente de correlación de Pearson (r):** mide la fuerza y el sentido de la relación lineal entre X y Y. Va de −1 a 1. Un valor cercano a 1 indica una relación positiva fuerte (si X aumenta, Y aumenta), cercano a −1 indica una relación negativa fuerte, y cercano a 0 indica que casi no hay relación lineal.
- **Coeficiente de determinación (r²):** es el cuadrado de r y representa el porcentaje de la variación de Y que explica el modelo. Por ejemplo, un r² de 0.95 significa que el modelo explica el 95 % de la variación de Y.

Una vez obtenido el modelo, se puede usar para **predecir** el valor de Y a partir de un valor nuevo de X.

En este proyecto se aplica a un caso sencillo: relacionar las **horas de estudio (X)** con la **calificación obtenida (Y)**.

## Contenido

```
Regresion-Lineal/
└── Unidad05y06/
    └── RegresionLineal/
        ├── RegresionLineal.java   # Cálculo de β0, β1, r y r²
        └── Main.java              # Datos de prueba y salida en consola
```

## Requisitos

- [Git](https://git-scm.com/)
- JDK 8 o superior (comprueba con `java -version` y `javac -version`)

## 1. Clonar el repositorio

```bash
git clone https://github.com/Lalis-707/Regresion-Lineal.git
cd Regresion-Lineal
```

## 2. Compilar

Desde la raíz del repositorio:

```bash
javac -d out Unidad05y06/RegresionLineal/RegresionLineal.java Unidad05y06/RegresionLineal/Main.java
```

Los `.class` se generan en la carpeta `out`.

## 3. Ejecutar

```bash
java -cp out Ecuaciones_Lineales.Unidad05y06.RegresionLineal.Main
```

## Ejecutar desde IntelliJ IDEA

1. Abre el proyecto (`File > Open`).
2. Abre `Main.java`.
3. Presiona el botón verde **Run** junto al método `main`.

## Datos de prueba

X = horas de estudio, Y = calificación obtenida.

| X | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---|---|---|---|---|---|---|---|---|---|----|
| Y | 52 | 55 | 61 | 64 | 70 | 72 | 78 | 83 | 85 | 91 |

## Resultados esperados

| Indicador | Valor |
|---|---|
| Pendiente (β1) | 4.3333 |
| Ordenada al origen (β0) | 47.2667 |
| Coeficiente de Pearson (r) | 0.9975 |
| Coeficiente de determinación (r²) | 0.9950 |

**Modelo obtenido:** `Y = 47.2667 + 4.3333X`

El modelo explica el 99.50 % de la variación de Y (correlación muy fuerte positiva).
Predicción para X = 12 horas: **Y = 99.2667**.

## Fórmulas utilizadas

- β1 = (n·ΣXY − ΣX·ΣY) / (n·ΣX² − (ΣX)²)
- β0 = (ΣY − β1·ΣX) / n
- r = (n·ΣXY − ΣX·ΣY) / √[(n·ΣX² − (ΣX)²)·(n·ΣY² − (ΣY)²)]
- r² = r · r

## Autor
~ Lalis-707 ^.^ — 257O01401
~ Instituto Tecnológico Superior de Xalapa, Ingeniería en Sistemas Computacionales. ~
