package compilador;

import compilador.Token.Tipos;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pedro Guzmán
 */
public class Lexer {

    public ArrayList<String> tokensNoValidos = new ArrayList<>();

    public boolean ERROR_LEXICO = false;

    public ArrayList<Token> lex(String input) {

        // En este array almacenamos los tokens validos
        ArrayList<Token> tokens = new ArrayList<Token>();

        StringTokenizer st = new StringTokenizer(input, "\"|:|>|<|=|(|)|+|-|/|*|;|{|}|\n", true);

        // Mientras alla tokens
        while (st.hasMoreTokens()) {

            String palabra = st.nextToken(); // obtenemos el token
            palabra = palabra.trim(); // quitamos los espacion
            boolean matched = false;

            //Si el token comienza con comillas 
            if (palabra.startsWith("\"")) {
                try {
                    palabra = palabra + st.nextToken(); // Lo que esta despues de las comillas
                    palabra = palabra + st.nextToken(); // La comilla de cierre
                } catch (Exception e) {
                    this.ERROR_LEXICO = true;
                    break;
                }
            }else if( palabra.indexOf(" ") != -1 ){ // Si el token contiene espacios
               
                ArrayList<Token> tokens2 = this.obtenerTokensSeparadosPorEspacio(palabra);
               
                for(Token token2 : tokens2){
                    tokens.add(token2);
                }
                continue;
            }
            
            // Si el token no esta vacio
            if (!palabra.equals("")) {
                for (Tipos tokenTipo : Tipos.values()) {
                    
                    Pattern patron = Pattern.compile(tokenTipo.patron);
                    Matcher matcher = patron.matcher(palabra);

                    if (matcher.find()) {
                        Token tk = new Token();
                        tk.setTipo(tokenTipo);
                        tk.setValor(palabra);
                        tokens.add(tk);
                        matched = true;
                    }
                }

                // Si no se encontro el token
                if (!matched) {
                    this.tokensNoValidos.add(palabra); // Los agregamos a la lista de tokens no validos
                }
            }
            
        } // fin while

        return tokens;
    }
    
    /**
     * 
     * @param codigo
     * @return 
     */
    public ArrayList<Token> obtenerTokensSeparadosPorEspacio(String codigo){
        
         ArrayList<Token> tokens = new ArrayList<Token>();

        // Indicamos como separamos los tokens
        StringTokenizer st = new StringTokenizer(codigo, " ", true);

        // Mientras alla tokens
        while (st.hasMoreTokens()) {

            String token = st.nextToken();
            token = token.trim();
            boolean matched = false;

            // Si el token no esta vacio
            if (!token.equals("")) {

                for (Tipos tokenTipo : Tipos.values()) {

                    Pattern patron = Pattern.compile(tokenTipo.patron);
                    Matcher matcher = patron.matcher(token);

                    if (matcher.find()) {
                        Token tk = new Token();
                        tk.setTipo(tokenTipo);
                        tk.setValor(token);
                        tokens.add(tk);
                        matched = true;
                    }
                }

                if (!matched) {
                    this.tokensNoValidos.add(token);
                }
            }
            
        } // fin while

        return tokens;
    }

}
