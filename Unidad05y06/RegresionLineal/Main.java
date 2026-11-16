package Ecuaciones_Lineales.Unidad05y06.RegresionLineal;
/**
 * Clase principal para probar la Regresion Lineal con un conjunto de datos.
 * X = horas de estudio, Y = calificacion obtenida.
 */
public class Main {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] y = {52, 55, 61, 64, 70, 72, 78, 83, 85, 91};

        // Tabla con los datos de prueba
        String linea = "+------+------------+------------+";
        System.out.println();
        System.out.println("  DATOS DE PRUEBA");
        System.out.println(linea);
        System.out.printf("| %-4s | %10s | %10s |%n", "No.", "X (horas)", "Y (calif.)");
        System.out.println(linea);
        for (int i = 0; i < x.length; i++) {
            System.out.printf("| %-4d | %10.1f | %10.1f |%n", i + 1, x[i], y[i]);
        }
        System.out.println(linea);

        double[] resultado = RegresionLineal.calcularMinimosCuadrados(x, y);

        // Tabla comparando Y real contra Y estimado por el modelo
        String linea2 = "+------+------------+------------+------------+";
        System.out.println();
        System.out.println("  VALIDACION DEL MODELO (Y real vs Y estimado)");
        System.out.println(linea2);
        System.out.printf("| %-4s | %10s | %10s | %10s |%n", "No.", "Y real", "Y estimado", "Error");
        System.out.println(linea2);
        for (int i = 0; i < x.length; i++) {
            double yEst = RegresionLineal.predecir(resultado[0], resultado[1], x[i]);
            System.out.printf("| %-4d | %10.2f | %10.2f | %10.2f |%n", i + 1, y[i], yEst, y[i] - yEst);
        }
        System.out.println(linea2);

        // Prediccion con un valor nuevo
        double xNuevo = 12;
        double yEstimado = RegresionLineal.predecir(resultado[0], resultado[1], xNuevo);
        System.out.println();
        System.out.printf("  >> Prediccion para X = %.1f horas: Y = %.4f%n", xNuevo, yEstimado);
        System.out.println();
    }
}