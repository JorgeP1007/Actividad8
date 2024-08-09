public class OperacionPotencia extends Operacion {

    private int exponente;

    public OperacionPotencia(String figura, double base, int exponente) {
        super(figura, base);
        this.exponente = exponente;
    }

    @Override
    public double calcular() {
        return calcularPotenciaRecursiva(parametros[0], exponente);
    }

    private double calcularPotenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            return base * calcularPotenciaRecursiva(base, exponente - 1);
        }
    }
}
