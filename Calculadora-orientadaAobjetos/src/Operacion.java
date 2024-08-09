public abstract class Operacion implements OperacionMatematica {
    protected String figura;
    protected double[] parametros;

    public Operacion(String figura, double... parametros) {
        this.figura = figura;
        this.parametros = parametros;
    }

    public String getFigura() {
        return figura;
    }
}
