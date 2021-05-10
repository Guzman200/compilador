package compilador;

/**
 *
 * @author Pedro Guzmán
 */
public class Token {

    private Tipos tipo;
    private String valor;

    public enum Tipos {
        
        NUMERO_ENTERO("^[0-9]+$"),
        //NUMERO_DECIMAL("[0-9]+[.]{1}[0-9]+"),
        NUMERO_DECIMAL("^[0-9]+[.]{1}[0-9]+$"),
        TEXTO("^[\"]{1}(.*)[\"]{1}$"),
        IDENTIFICADOR("[$]{1}[a-zA-Z_]+([a-zA-Z_]+|[0-9]+)*"),
        IGUAL("^=$"),
        IGUALDAD("^:$"),
        MAYOR_QUE("^>$"),
        MENOR_QUE("^<$"),
        PUNTO_Y_COMA("^;$"),
        COMILLAS("^\"$"),
        PARENTESIS_CIERRE("^\\)$"),
        PARENTESIS_APERTURA("^\\($"),
        OPERADORACION_ARITM("[*|/|+|-]"),
        PALABRA_RESERVADA_ENTERO("^entero$"),
        PALABRA_RESERVADA_DECIMAL("^decimal$"),
        PALABRA_RESERVADA_TEXTO("^texto$"),
        PALABRA_RESERVADA_INICIAR("^INICIAR$"),
        PALABRA_RESERVADA_TERMINAR("^TERMINAR$"),
        PALABRA_RESERVADA_CICLO("^CICLO$"),
        PALABRA_RESERVADA_SI("^SI$"),
        CORCHETE_APERTURA("^\\{$"),
        CORCHETE_CIERRE("^\\}$");

        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
