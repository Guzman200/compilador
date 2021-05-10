package compilador;

import static compilador.Helper.continuarPos;
import compilador.Token.Tipos;
import java.util.ArrayList;

/**
 *
 * @author Pedro Guzmán
 */
public class HelperSemanctico {

    public static int continuarPos;

    /**
     *
     * @param tokens
     * @param hastaPos
     * @param nombreVariable
     * @return
     */
    public static boolean laVariableYaHaSidoDeclarada(ArrayList<Token> tokens, int hastaPos, String nombreVariable) {

        for (int i = 0; i < hastaPos; i++) {

            if (tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_ENTERO
                    || tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_DECIMAL
                    || tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_TEXTO) {

                if (tokens.get(i + 1).getValor().equals(nombreVariable)) {
                    return true;
                }

            }

        }

        return false;

    }

    public static boolean laVariableDeclaradaEsInicializadaCorrectamente(ArrayList<Token> tokens, int pos) {

        try {

            // Si la declaración no es inicializada
            if (tokens.get(pos + 1).getTipo() == Tipos.IDENTIFICADOR
                    && tokens.get(pos + 2).getTipo() == Tipos.PUNTO_Y_COMA) {

                HelperSemanctico.continuarPos = pos + 2;
                return true;

                // Si es inicializada
            } else if (tokens.get(pos + 1).getTipo() == Tipos.IDENTIFICADOR
                    && tokens.get(pos + 2).getTipo() == Tipos.IGUAL
                    && (tokens.get(pos + 3).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 3).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 3).getTipo() == Tipos.TEXTO)
                    && tokens.get(pos + 4).getTipo() == Tipos.PUNTO_Y_COMA) {

                HelperSemanctico.continuarPos = pos + 4;

                /// Si la declaración es de tipo entero
                if (tokens.get(pos).getTipo() == Tipos.PALABRA_RESERVADA_ENTERO) {

                    return tokens.get(pos + 3).getTipo() == Tipos.NUMERO_ENTERO;

                } else if (tokens.get(pos).getTipo() == Tipos.PALABRA_RESERVADA_DECIMAL) {

                    return tokens.get(pos + 3).getTipo() == Tipos.NUMERO_DECIMAL;

                } else if (tokens.get(pos).getTipo() == Tipos.PALABRA_RESERVADA_TEXTO) {

                    return tokens.get(pos + 3).getTipo() == Tipos.TEXTO;

                }

            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static boolean laAsignacionDeUnaVariableEsCorrecta(ArrayList<Token> tokens, int pos) {
        
        try {

            if (tokens.get(pos + 1).getTipo() == Tipos.IGUAL
                    && (tokens.get(pos + 2).getTipo() == Tipos.NUMERO_DECIMAL
                    || tokens.get(pos + 2).getTipo() == Tipos.NUMERO_ENTERO
                    || tokens.get(pos + 2).getTipo() == Tipos.TEXTO
                    || tokens.get(pos + 2).getTipo() == Tipos.IDENTIFICADOR)
                    && tokens.get(pos + 3).getTipo() == Tipos.PUNTO_Y_COMA) {

                System.out.println("ENTRO!!");

                //  ejemplo de asignacion :  $numero = $other;
                Token variableIdentificador = tokens.get(pos);
                Tipos tipoDatoVariable = obtenerTipoDeDatoDeUnIdentificador(tokens, variableIdentificador.getValor());

                Tipos tipoDato = tokens.get(pos + 2).getTipo();

                if (tipoDato == Tipos.IDENTIFICADOR) {

                    tipoDato = obtenerTipoDeDatoDeUnIdentificador(tokens, tokens.get(pos + 2).getValor());

                }

                HelperSemanctico.continuarPos = pos + 3;
                return tipoDatoVariable == tipoDato;

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

                //  ejemplo de asignacion :  $numero = $other + 21;
                
                Token variableIdentificador = tokens.get(pos);
                Tipos tipoDatoVariable = obtenerTipoDeDatoDeUnIdentificador(tokens, variableIdentificador.getValor());
                
                Tipos tipoDato1 = tokens.get(pos + 2).getTipo();
                Tipos tipoDato2 = tokens.get(pos + 4).getTipo();
                

                if (tipoDato1 == Tipos.IDENTIFICADOR) {
                    tipoDato1 = obtenerTipoDeDatoDeUnIdentificador(tokens, tokens.get(pos + 2).getValor());
                }
                
                if (tipoDato2 == Tipos.IDENTIFICADOR) {
                    tipoDato2 = obtenerTipoDeDatoDeUnIdentificador(tokens, tokens.get(pos + 4).getValor());
                }

                HelperSemanctico.continuarPos = pos + 5;
                return tipoDatoVariable == tipoDato1 && tipoDatoVariable == tipoDato2;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static Tipos obtenerTipoDeDatoDeUnIdentificador(ArrayList<Token> tokens, String valor) {

        for (int i = 0; i < tokens.size(); i++) {

            if (tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_ENTERO && tokens.get(i + 1).getValor().equals(valor)) {

                return Tipos.NUMERO_ENTERO;

            } else if (tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_DECIMAL && tokens.get(i + 1).getValor().equals(valor)) {

                return Tipos.NUMERO_DECIMAL;

            } else if (tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_TEXTO && tokens.get(i + 1).getValor().equals(valor)) {

                return Tipos.TEXTO;

            }

        }

        return null;

    }

    
    public static boolean lasVariablesDeUnCicloOCondicionYaFueronDeclaradas(ArrayList<Token> tokens, int pos){
        
        
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
                
                 
                Tipos tipoDato1 = tokens.get(pos + 2).getTipo();
                Tipos tipoDato2 = tokens.get(pos + 4).getTipo();
                
                System.out.println("tipo de dato 2 -> "+tipoDato2);

                if (tipoDato1 == Tipos.IDENTIFICADOR) {
                    
                    // verificamos que la variable ya ha este declarada
                    boolean haSidoDeclarada =  laVariableYaHaSidoDeclarada(tokens, pos+2, tokens.get(pos + 2).getValor());
                    
                    if(!haSidoDeclarada){
                        return false;
                    }
                    
                }
                
                if (tipoDato2 == Tipos.IDENTIFICADOR) {
                 
                    // verificamos que la variable ya ha este declarada
                    boolean haSidoDeclarada =  laVariableYaHaSidoDeclarada(tokens, pos+4, tokens.get(pos + 4).getValor());
                    
                    if(!haSidoDeclarada){
                        return false;
                    }
                    
                }

                HelperSemanctico.continuarPos = pos + 6;
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
        
    }
    
    
    public static boolean lasVariablesDeUnCicloOCondicionSonDelMismoTipo(ArrayList<Token> tokens, int pos){
        
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
                
                 
                Tipos tipoDato1 = tokens.get(pos + 2).getTipo();
                Tipos tipoDato2 = tokens.get(pos + 4).getTipo();
                

                if (tipoDato1 == Tipos.IDENTIFICADOR) {
                    tipoDato1 = obtenerTipoDeDatoDeUnIdentificador(tokens, tokens.get(pos + 2).getValor());
                }
                
                if (tipoDato2 == Tipos.IDENTIFICADOR) {
                    tipoDato2 = obtenerTipoDeDatoDeUnIdentificador(tokens, tokens.get(pos + 4).getValor());
                }

                
                
                
                HelperSemanctico.continuarPos = pos + 6;
                return tipoDato1 == tipoDato2;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
        
    }
    
}
