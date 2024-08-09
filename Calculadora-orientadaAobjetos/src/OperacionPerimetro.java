public class OperacionPerimetro extends Operacion {

    public OperacionPerimetro(String figura, double... parametros) {
        super(figura, parametros);
    }

    @Override
    public double calcular() {
        switch (figura.toLowerCase()) {
            case "círculo":
                return 2 * Math.PI * parametros[0];
            case "cuadrado":
                return 4 * parametros[0];
            case "triángulo":
                return parametros[0] + parametros[1] + parametros[2];
            case "rectángulo":
                return 2 * (parametros[0] + parametros[1]);
            case "pentágono":
                return 5 * parametros[0];
            default:
                throw new UnsupportedOperationException("Figura no soportada para perímetro");
        }
    }
}
