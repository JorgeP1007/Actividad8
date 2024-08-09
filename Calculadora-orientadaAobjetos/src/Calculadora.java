import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    private List<String> resultados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            try {
                System.out.println("\nCalculadora de Operaciones Matemáticas");
                System.out.println("\n1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Mostrar resultados");
                System.out.println("7. Salir");
                System.out.print("\nElige una figura: ");
                int figuraSeleccionada = scanner.nextInt();

                if (figuraSeleccionada == 7) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                if (figuraSeleccionada == 6) {
                    mostrarResultados();
                    continue;
                }

                String figura = obtenerNombreFigura(figuraSeleccionada);

                System.out.println("1. Calcular Área");
                System.out.println("2. Calcular Perímetro");
                System.out.println("3. Calcular Potencia");
                System.out.print("Elige una operación: ");
                int operacionSeleccionada = scanner.nextInt();

                OperacionMatematica operacion = null;

                switch (operacionSeleccionada) {
                    case 1:
                        operacion = new OperacionArea(figura, obtenerParametrosArea(figura));
                        break;
                    case 2:
                        operacion = new OperacionPerimetro(figura, obtenerParametrosPerimetro(figura));
                        break;
                    case 3:
                        operacion = new OperacionPotencia(figura, obtenerBase(), obtenerExponente());
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        continue;
                }

                double resultado = operacion.calcular();
                String resultadoTexto = "El resultado de " + figura + " es: " + resultado;
                resultados.add(resultadoTexto);
                System.out.println(resultadoTexto);

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un valor numérico.");
                scanner.next(); // Limpiar el buffer del scanner
            }

            System.out.println();
        }

        scanner.close();
    }

    private String obtenerNombreFigura(int figuraSeleccionada) {
        switch (figuraSeleccionada) {
            case 1: return "Círculo";
            case 2: return "Cuadrado";
            case 3: return "Triángulo";
            case 4: return "Rectángulo";
            case 5: return "Pentágono";
            default: throw new IllegalArgumentException("Figura no válida");
        }
    }

    private double[] obtenerParametrosArea(String figura) {
        switch (figura.toLowerCase()) {
            case "círculo":
            case "cuadrado":
                return new double[]{obtenerValor("lado/radio")};
            case "triángulo":
            case "rectángulo":
            case "pentágono":
                return new double[]{obtenerValor("base/lado"), obtenerValor("altura/apotema")};
            default:
                throw new UnsupportedOperationException("Figura no soportada para área");
        }
    }

    private double[] obtenerParametrosPerimetro(String figura) {
        switch (figura.toLowerCase()) {
            case "círculo":
                return new double[]{obtenerValor("radio")};
            case "cuadrado":
                return new double[]{obtenerValor("lado")};
            case "triángulo":
                return new double[]{obtenerValor("lado 1"), obtenerValor("lado 2"), obtenerValor("lado 3")};
            case "rectángulo":
                return new double[]{obtenerValor("longitud"), obtenerValor("ancho")};
            case "pentágono":
                return new double[]{obtenerValor("lado")};
            default:
                throw new UnsupportedOperationException("Figura no soportada para perímetro");
        }
    }

    private double obtenerBase() {
        return obtenerValor("base para la potencia");
    }

    private int obtenerExponente() {
        System.out.print("Ingresa el exponente: ");
        return scanner.nextInt();
    }

    private double obtenerValor(String parametro) {
        System.out.print("Ingresa el valor de " + parametro + ": ");
        return scanner.nextDouble();
    }

    private void mostrarResultados() {
        System.out.println("Resultados almacenados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.iniciar();
    }
}
