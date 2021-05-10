package compilador;

import compilador.Token.Tipos;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pedro Gumzán
 */
public class Helper {

    public static int continuarPos = 0;

    /**
     *
     * @param codigo
     * @return String
     */
    public static String quitarComentariosDelCodigo(String codigo) {

        String codigoSinComentario = "";

        // Separamos el codigo por lineas
        String lineas[] = codigo.split("\n");

        for (String linea : lineas) {

            // Si no es comentario
            if (!esComentario(linea)) {

                codigoSinComentario = codigoSinComentario + linea + "\n";

            }

        }

        return codigoSinComentario;

    }

    /**
     * @param lineaCodigo
     * @return boolean
     */
    public static boolean esComentario(String lineaCodigo) {

        Pattern pat = Pattern.compile("^[\\s]*[#].*");
        Matcher mat = pat.matcher(lineaCodigo);

        if (mat.matches()) {
            return true;
        }

        return false;
    }

    /**
     *
     * @param tokens
     * @param pos
     * @return boolean
     */
    public static boolean declaracionDeVariable(ArrayList<Token> tokens, int pos) {

        try {

            if (tokens.get(pos + 1).getTipo() == Tipos.IDENTIFICADOR
                    && tokens.get(pos + 2).getTipo() == Tipos.PUNTO_Y_COMA) {

                continuarPos = pos + 2;
                return true;

            } else if (tokens.get(pos + 1).getTipo() == Tipos.IDENTIFICADOR
                    && tokens.get(pos + 2).getTipo() == Tipos.IGUAL
                    && (tokens.get(pos + 3).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 3).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 3).getTipo() == Tipos.TEXTO)
                    && tokens.get(pos + 4).getTipo() == Tipos.PUNTO_Y_COMA) {

                continuarPos = pos + 4;
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;

    }

    /**
     *
     * @param tokens
     * @param pos
     * @return
     */
    public static boolean asignacionDeVariable(ArrayList<Token> tokens, int pos) {

        try {

            if (tokens.get(pos + 1).getTipo() == Tipos.IGUAL
                    && (tokens.get(pos + 2).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 2).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 2).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 2).getTipo() == Tipos.IDENTIFICADOR)
                    && tokens.get(pos + 3).getTipo() == Tipos.PUNTO_Y_COMA) {

                continuarPos = pos + 3;
                return true;

            } else if (tokens.get(pos + 1).getTipo() == Tipos.IGUAL
                    && (tokens.get(pos + 2).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 2).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 2).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 2).getTipo() == Tipos.IDENTIFICADOR)
                    && tokens.get(pos + 3).getTipo() == Tipos.OPERADORACION_ARITM
                    && (tokens.get(pos + 4).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 4).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 4).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 4).getTipo() == Tipos.IDENTIFICADOR)
                    && tokens.get(pos + 5).getTipo() == Tipos.PUNTO_Y_COMA) {

                continuarPos = pos + 5;
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;

    }

    /**
     *
     * @param tokens
     * @param pos
     * @return
     */
    public static boolean condicionalOrCiclo(ArrayList<Token> tokens, int pos) {

        try {

            // Verificamos que la condicion sea correcta
            if (tokens.get(pos + 1).getTipo() == Tipos.PARENTESIS_APERTURA
                    && (tokens.get(pos + 2).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 2).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 2).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 2).getTipo() == Tipos.IDENTIFICADOR)
                    && (tokens.get(pos + 3).getTipo() == Tipos.IGUALDAD
                    || tokens.get(pos + 3).getTipo() == Tipos.MAYOR_QUE
                    || tokens.get(pos + 3).getTipo() == Tipos.MENOR_QUE)
                    && (tokens.get(pos + 4).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 4).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 4).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 4).getTipo() == Tipos.IDENTIFICADOR)
                    && tokens.get(pos + 5).getTipo() == Tipos.PARENTESIS_CIERRE
                    && tokens.get(pos + 6).getTipo() == Tipos.CORCHETE_APERTURA) {

                continuarPos = pos + 6;
                return true;

            }

        } catch (Exception e) {
            return false;
        }

        return false;

    }

    /**
     *
     * @param tokens
     * @param pos
     * @return
     */
    public static boolean verificarEstructuraSINO(ArrayList<Token> tokens, int pos) {

        int corchetePorCerrar = 0;

        try {

            if (tokens.get(pos - 1).getTipo() == Tipos.CORCHETE_CIERRE
                    && tokens.get(pos + 1).getTipo() == Tipos.CORCHETE_APERTURA) {

                int i = pos - 1;
                while (i > 0) {

                    if (tokens.get(i).getTipo() == Tipos.CORCHETE_CIERRE) {
                        corchetePorCerrar++;
                    } else if (tokens.get(i).getTipo() == Tipos.CORCHETE_APERTURA) {
                        corchetePorCerrar--;
                    }

                    if (corchetePorCerrar == 0) {
                        if (tokens.get(i - 1).getTipo() == Tipos.PARENTESIS_CIERRE
                                && (tokens.get(i - 2).getTipo() == Tipos.NUMERO_DECIMAL
                                || tokens.get(i - 2).getTipo() == Tipos.NUMERO_ENTERO
                                || tokens.get(i - 2).getTipo() == Tipos.TEXTO
                                || tokens.get(i - 2).getTipo() == Tipos.IDENTIFICADOR)
                                && (tokens.get(i - 3).getTipo() == Tipos.IGUALDAD
                                || tokens.get(i - 3).getTipo() == Tipos.MAYOR_QUE
                                || tokens.get(i - 3).getTipo() == Tipos.MENOR_QUE)
                                && (tokens.get(i - 4).getTipo() == Tipos.NUMERO_DECIMAL
                                || tokens.get(i - 4).getTipo() == Tipos.NUMERO_ENTERO
                                || tokens.get(i - 4).getTipo() == Tipos.TEXTO
                                || tokens.get(i - 4).getTipo() == Tipos.IDENTIFICADOR)
                                && tokens.get(i - 5).getTipo() == Tipos.PARENTESIS_APERTURA
                                && (tokens.get(i - 6).getTipo() == Tipos.PALABRA_RESERVADA_SI
                                || tokens.get(i - 4).getTipo() == Tipos.PALABRA_RESERVADA_CICLO)) {
                            return true;
                        }
                    }

                    i--;

                }

            }

        } catch (Exception e) {
        }
        return false;
    }

    /**
     *
     * @param tokens
     * @param pos
     * @return
     */
    public static boolean verificarCorcheteApertura(ArrayList<Token> tokens, int pos) {

        if (tokens.get(pos - 1).getTipo() == Tipos.PALABRA_RESERVADA_SINO) {
            return true;
        } else if (tokens.get(pos - 1).getTipo() == Tipos.PARENTESIS_CIERRE
                && (tokens.get(pos - 2).getTipo() == Tipos.NUMERO_DECIMAL
                || tokens.get(pos - 2).getTipo() == Tipos.NUMERO_ENTERO
                || tokens.get(pos - 2).getTipo() == Tipos.TEXTO
                || tokens.get(pos - 2).getTipo() == Tipos.IDENTIFICADOR)
                && (tokens.get(pos - 3).getTipo() == Tipos.IGUALDAD
                || tokens.get(pos - 3).getTipo() == Tipos.MAYOR_QUE
                || tokens.get(pos - 3).getTipo() == Tipos.MENOR_QUE)
                && (tokens.get(pos - 4).getTipo() == Tipos.NUMERO_DECIMAL
                || tokens.get(pos - 4).getTipo() == Tipos.NUMERO_ENTERO
                || tokens.get(pos - 4).getTipo() == Tipos.TEXTO
                || tokens.get(pos - 4).getTipo() == Tipos.IDENTIFICADOR)
                && tokens.get(pos - 5).getTipo() == Tipos.PARENTESIS_APERTURA
                && (tokens.get(pos - 6).getTipo() == Tipos.PALABRA_RESERVADA_SI
                || tokens.get(pos - 4).getTipo() == Tipos.PALABRA_RESERVADA_CICLO)) {
            return true;
        }

        return false;
    }

}
