public class OperacionArea extends Operacion {

    public OperacionArea(String figura, double... parametros) {
        super(figura, parametros);
    }

    @Override
    public double calcular() {
        switch (figura.toLowerCase()) {
            case "círculo":
                return Math.PI * Math.pow(parametros[0], 2);
            case "cuadrado":
                return Math.pow(parametros[0], 2);
            case "triángulo":
                return (parametros[0] * parametros[1]) / 2;
            case "rectángulo":
                return parametros[0] * parametros[1];
            case "pentágono":
                return (5 * parametros[0] * parametros[1]) / 2;
            default:
                throw new UnsupportedOperationException("Figura no soportada para área");
        }
    }
}
