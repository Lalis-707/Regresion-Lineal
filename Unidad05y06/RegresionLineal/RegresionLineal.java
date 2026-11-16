package Ecuaciones_Lineales.Unidad05y06.RegresionLineal;
/**
 * Clase que implementa el calculo de Regresion Lineal Simple
 * utilizando el metodo de Minimos Cuadrados, incluyendo Pearson y R2.
 **/
public class RegresionLineal {

    /**
     * Calcula la regresion y retorna los coeficientes {beta0, beta1, r, r2}.
     *
     * @param x Arreglo con los valores independientes.
     * @param y Arreglo con los valores dependientes.
     * @return Arreglo double[] con los indicadores estadisticos.
     */
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            System.out.println("Error: Los arreglos deben tener el mismo tamano y no estar vacios.");
            return new double[]{0.0, 0.0, 0.0, 0.0};
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        // Acumulamos las sumatorias necesarias
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }

        // Formulas oficiales de Minimos Cuadrados
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - (sumX * sumX));
        double beta0 = (sumY - beta1 * sumX) / n;

        // ========================================================
        // TODO: Los alumnos deben implementar el calculo de Pearson (r)
        // y el coeficiente de determinacion (r2 = r * r) utilizando las sumatorias.
        // ========================================================
        // r = (n*SumXY - SumX*SumY) / sqrt[(n*SumX2 - SumX^2) * (n*SumY2 - SumY^2)]
        double numerador = n * sumXY - sumX * sumY;
        double denominador = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        double pearsonR = numerador / denominador;
        double r2 = pearsonR * pearsonR;

        // ---------------- SALIDA EN CONSOLA (formato de tablas) ----------------
        String linea = "+------------------------------------+---------------------+";
        String lineaTitulo = "+-----------------------------------------------------------+";

        System.out.println();
        System.out.println(lineaTitulo);
        System.out.printf("| %-57s |%n", "   RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION");
        System.out.println(lineaTitulo);

        // Tabla 1: Sumatorias
        System.out.println();
        System.out.println("  SUMATORIAS");
        System.out.println(linea);
        System.out.printf("| %-34s | %19s |%n", "Concepto", "Valor");
        System.out.println(linea);
        System.out.printf("| %-34s | %19d |%n", "n (numero de datos)", n);
        System.out.printf("| %-34s | %19.2f |%n", "Suma de X  (SumX)", sumX);
        System.out.printf("| %-34s | %19.2f |%n", "Suma de Y  (SumY)", sumY);
        System.out.printf("| %-34s | %19.2f |%n", "Suma de X^2  (SumX2)", sumX2);
        System.out.printf("| %-34s | %19.2f |%n", "Suma de Y^2  (SumY2)", sumY2);
        System.out.printf("| %-34s | %19.2f |%n", "Suma de X*Y  (SumXY)", sumXY);
        System.out.println(linea);

        // Tabla 2: Resultados
        System.out.println();
        System.out.println("  COEFICIENTES DEL MODELO");
        System.out.println(linea);
        System.out.printf("| %-34s | %19s |%n", "Indicador", "Valor");
        System.out.println(linea);
        System.out.printf("| %-34s | %19.4f |%n", "Pendiente (beta1)", beta1);
        System.out.printf("| %-34s | %19.4f |%n", "Ordenada al origen (beta0)", beta0);
        System.out.printf("| %-34s | %19.4f |%n", "Coeficiente de Pearson (r)", pearsonR);
        System.out.printf("| %-34s | %19.4f |%n", "Coeficiente de Determinacion (r2)", r2);
        System.out.println(linea);

        System.out.println();
        System.out.printf("  >> Modelo obtenido: Y = %.4f + %.4fX%n", beta0, beta1);
        System.out.printf("  >> Interpretacion: correlacion %s; el modelo explica el %.2f%% de la variacion de Y.%n",
                interpretarCorrelacion(pearsonR), r2 * 100);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    /**
     * Realiza una estimacion/prediccion evaluando el modelo con un valor de X.
     */
    public static double predecir(double beta0, double beta1, double xValor) {
        return beta0 + beta1 * xValor;
    }

    /**
     * Describe con palabras la fuerza y el sentido de la correlacion de Pearson.
     */
    private static String interpretarCorrelacion(double r) {
        double a = Math.abs(r);
        String fuerza;
        if (a >= 0.9) fuerza = "muy fuerte";
        else if (a >= 0.7) fuerza = "fuerte";
        else if (a >= 0.4) fuerza = "moderada";
        else if (a >= 0.2) fuerza = "debil";
        else fuerza = "muy debil o nula";
        String sentido = r > 0 ? "positiva" : (r < 0 ? "negativa" : "");
        return (fuerza + " " + sentido).trim();
    }
}