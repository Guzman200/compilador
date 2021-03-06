package vistas;

import compilador.Helper;
import compilador.HelperSemanctico;
import compilador.Lexer;
import compilador.Token;
import compilador.Token.Tipos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Pedro Ignacio Ruiz Guzmán Y Pablo Cesar Gordillo Perez
 */
public class iniciar extends javax.swing.JFrame {
    
    public ArrayList<Token> tokens = new ArrayList<Token>();

    /**
     * Creates new form iniciar
     */
    public iniciar() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
        this.setTitle("COMPLEX-RGP");
        btnAnalisisSemantico.setEnabled(false);
        btnAnalisisSintactico.setEnabled(false);
        labelEtapa.setText("{Análisis léxico}");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSeleccionarArchivoTxt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtErroresLexico = new javax.swing.JTextArea();
        btnAnalisisSemantico = new javax.swing.JButton();
        btnAnalisisSintactico = new javax.swing.JButton();
        btnAnalisisLexico = new javax.swing.JButton();
        labelEtapa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLimpiarCodigo = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(4, 24, 38));

        btnSeleccionarArchivoTxt.setBackground(new java.awt.Color(16, 141, 64));
        btnSeleccionarArchivoTxt.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnSeleccionarArchivoTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarArchivoTxt.setText("SELECCIONAR ARHIVO DE TEXTO (*.TXT)");
        btnSeleccionarArchivoTxt.setPreferredSize(new java.awt.Dimension(313, 25));
        btnSeleccionarArchivoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoTxtActionPerformed(evt);
            }
        });

        txtCodigo.setBackground(new java.awt.Color(0, 0, 0));
        txtCodigo.setColumns(20);
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setRows(5);
        txtCodigo.setBorder(null);
        jScrollPane1.setViewportView(txtCodigo);

        txtErroresLexico.setBackground(new java.awt.Color(0, 0, 0));
        txtErroresLexico.setColumns(20);
        txtErroresLexico.setForeground(new java.awt.Color(255, 255, 255));
        txtErroresLexico.setRows(5);
        jScrollPane2.setViewportView(txtErroresLexico);

        btnAnalisisSemantico.setBackground(new java.awt.Color(16, 141, 64));
        btnAnalisisSemantico.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnAnalisisSemantico.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalisisSemantico.setText("Análisis Semántico(3)");
        btnAnalisisSemantico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisSemanticoActionPerformed(evt);
            }
        });

        btnAnalisisSintactico.setBackground(new java.awt.Color(16, 141, 64));
        btnAnalisisSintactico.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnAnalisisSintactico.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalisisSintactico.setText("Análisis Sintáctico(2)");
        btnAnalisisSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisSintacticoActionPerformed(evt);
            }
        });

        btnAnalisisLexico.setBackground(new java.awt.Color(16, 141, 64));
        btnAnalisisLexico.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnAnalisisLexico.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalisisLexico.setText("Análisis Léxico(1)");
        btnAnalisisLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisLexicoActionPerformed(evt);
            }
        });

        labelEtapa.setForeground(new java.awt.Color(255, 255, 255));
        labelEtapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEtapa.setText("{Analizar lexico}");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPLEX-RGP");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("{ ERRORES }");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("{ CÓDIGO }");

        jButton1.setBackground(new java.awt.Color(16, 141, 64));
        jButton1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reiniciar Análisis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpiarCodigo.setBackground(new java.awt.Color(16, 141, 64));
        btnLimpiarCodigo.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnLimpiarCodigo.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCodigo.setText("Limpiar pantalla { CÓDIGO }");
        btnLimpiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarCodigo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAnalisisSemantico, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSeleccionarArchivoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnalisisLexico))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(426, 426, 426)
                                .addComponent(labelEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(btnAnalisisSintactico)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelEtapa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionarArchivoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(btnLimpiarCodigo)
                            .addComponent(jButton1)
                            .addComponent(btnAnalisisSemantico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnalisisSintactico)
                            .addComponent(btnAnalisisLexico))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarArchivoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoTxtActionPerformed
        
        JFileChooser fs = new JFileChooser(FileSystemView.getFileSystemView());

        // Limpiamos el textarea
        txtCodigo.setText("");
        
        fs.setAcceptAllFileFilterUsed(false);

        // Establecemos el titulo del dialogo
        fs.setDialogTitle("Selecciona un archivo (*.txt)");

        // Unicamente archivos txt
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Solamente archivo de texto", "txt");
        fs.addChoosableFileFilter(restrict);

        // Mostramos la ventana  
        int r = fs.showOpenDialog(null);

        // Si el usuario selecciono un archivo
        if (r == JFileChooser.APPROVE_OPTION) {

            // Obtenemos la ruta del archivo seleccionado
            String ruta = fs.getSelectedFile().getAbsolutePath();
            BufferedReader b;
            
            try {
                // Leemos el archivo seleccionado
                b = new BufferedReader(new FileReader(ruta));
                
                String contenidoArchivo = "";
                String linea;

                // Leemos el archivo linea por linea
                while ((linea = b.readLine()) != null) {
                    // Mandamos a analizar la linea
                    contenidoArchivo = contenidoArchivo + linea + "\n";
                }
                b.close();
                txtCodigo.setText(contenidoArchivo);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(iniciar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(iniciar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            // Si el usuario cancelo la operación
            JOptionPane.showMessageDialog(this, "No se selecciono ningun archivo");
        }
        
        btnAnalisisLexico.setEnabled(true);
        btnAnalisisSintactico.setEnabled(false);
        btnAnalisisSemantico.setEnabled(false);
    }//GEN-LAST:event_btnSeleccionarArchivoTxtActionPerformed

    private void btnAnalisisLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisLexicoActionPerformed

        /* ANÁLISADOR LÉXICO */
        // Limpiamos los errores
        txtErroresLexico.setText("");

        // Obtenemos el código sin comentarios
        String codigo = Helper.quitarComentariosDelCodigo(txtCodigo.getText());

        // Instanciamos nuetro Lexer
        Lexer lexer = new Lexer();

        // Obtenemos los tokens 
        this.tokens = lexer.lex(codigo);
        
        String errores = "-------------------------------------->  TOKENS NO VALIDOS :'v  <------------------------------------\n\n";
        String tokensValidos = "\n\n\n---------------------------------------------> TOKENS VALIDOS :v <------------------------------------\n\n";
        
        for (Token token : this.tokens) {
            tokensValidos = tokensValidos + "{" + token.getValor() + "}" + " " + token.getTipo() + "\n";
        }
        
        boolean hayErrores = lexer.ERROR_LEXICO;
        
        if (hayErrores) {
            errores = errores + "ERROR EN EL ANALIZADOR LEXICO\n";
        } else {
            for (String tokenNoValido : lexer.tokensNoValidos) {
                hayErrores = true;
                errores = errores + "{" + tokenNoValido + "}" + " TOKEN NO RECONOCIDO! \n";
            }
        }
        
        txtErroresLexico.setText(errores);
        
        if (hayErrores) {
            txtErroresLexico.setBackground(Color.red);
        } else {
            txtErroresLexico.setBackground(Color.black);
            txtErroresLexico.append(tokensValidos);
            btnAnalisisLexico.setEnabled(false);
            btnAnalisisSintactico.setEnabled(true);
            labelEtapa.setText("{Análisis sintáctico}");
            JOptionPane.showMessageDialog(this, "Etapa de analsís lexico pasada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAnalisisLexicoActionPerformed

    private void btnAnalisisSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisSintacticoActionPerformed

        /* ANÁLISIS SINTÁCTICO */
        boolean esPrimerToken = true;
        boolean hayErrores = false;
        Token ultimoToken = new Token();
        String errores = "--------------------------------->  ERRORES SINTÁCTICOS  <--------------------------------\n\n";
        
        int numeroTokens = this.tokens.size();

        // numero de condiciones que se deben de cerrar
        int numeroDeCondicionesYCiclosPorCerrar = 0;

        // Recorremos todos los tokens
        for (int i = 0; i < this.tokens.size(); i++) {
            
            if (esPrimerToken) {
                
                if (!(this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_INICIAR)) {
                    errores += "No se ha encontrado la palabra reservada INICIAR \n";
                    hayErrores = true;
                    break;
                }
                esPrimerToken = false;
            } else {

                // Si es declaración de variable
                if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_ENTERO
                        || this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_DECIMAL
                        || this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_TEXTO) {
                    
                    boolean esCorrecto = Helper.declaracionDeVariable(tokens, i);
                    
                    if (!esCorrecto) {
                        errores += "Error al intentar declarar variable \n";
                        hayErrores = true;
                        break;
                    } else {
                        i = Helper.continuarPos;
                    }

                    // Si es asignacion de variable 
                } else if (this.tokens.get(i).getTipo() == Tipos.IDENTIFICADOR) {
                    boolean esCorrecto = Helper.asignacionDeVariable(tokens, i);
                    
                    if (!esCorrecto) {
                        errores += "Error al intentar asignar un valor a la variable " + this.tokens.get(i).getValor() + "\n";
                        hayErrores = true;
                        break;
                    } else {
                        i = Helper.continuarPos;
                    }

                    // Si es una condicional
                } else if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_SI) {
                    
                    numeroDeCondicionesYCiclosPorCerrar++; //

                    boolean esCorrecto = Helper.condicionalOrCiclo(tokens, i);
                    
                    if (!esCorrecto) {
                        errores += "Error en estructura condicional SI \n";
                        hayErrores = true;
                        break;
                    } else {
                        i = Helper.continuarPos;
                    }

                    // Si es un ciclo
                } else if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_CICLO) {
                    
                    numeroDeCondicionesYCiclosPorCerrar++; //

                    boolean esCorrecto = Helper.condicionalOrCiclo(tokens, i);
                    
                    if (!esCorrecto) {
                        errores += "Error en estructura CICLO \n";
                        hayErrores = true;
                        break;
                    } else {
                        i = Helper.continuarPos;
                    }
                    
                } else if (this.tokens.get(i).getTipo() == Tipos.CORCHETE_CIERRE) {
                    
                    numeroDeCondicionesYCiclosPorCerrar--;
                    if (numeroDeCondicionesYCiclosPorCerrar < 0) {
                        hayErrores = true;
                        errores += "Error sintáctico en cierre de condicional ó ciclo \n";
                        break;
                    }
                    
                } else if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_TERMINAR) {

                    // Si la palabra reservada TERMINAR no es el ultimo token
                    if (!(i == (numeroTokens - 1))) {
                        
                        hayErrores = true;
                        errores += "Error sintáctico con la palabra reservada TERMINAR. \n";
                        break;
                        
                    }
                    
                }else if(this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_SINO){
                  
                  
                    boolean esCorrecto = Helper.verificarEstructuraSINO(tokens, i);
                    
                    if(!esCorrecto){
                        hayErrores = true;
                        errores += "Error en la sintáctico en la estructura de control SINO \n";
                        break;
                    }
                    
                    System.out.println("SALIO DE SINO");
     
                    
                }else if(this.tokens.get(i).getTipo() == Tipos.CORCHETE_APERTURA){
                    
                    numeroDeCondicionesYCiclosPorCerrar++;
                    
                    boolean esCorrecto = Helper.verificarCorcheteApertura(tokens, i);
                    
                    if(!esCorrecto){
                        hayErrores = true;
                        errores += "Error en la sintáctico, la causa puede ser un: }  \n";
                        break;
                    }
                
                }else {
                    
                    hayErrores = true;
                    errores += "Error sintáctico lamentamos no poder darle una pista ;( \n";
                    break;
                    
                }
                
            }
            
        } // FIN FOR

        // Guardamos el valor del ultimo token del codigo
        ultimoToken.setTipo(this.tokens.get(numeroTokens - 1).getTipo());
        ultimoToken.setValor(this.tokens.get(numeroTokens - 1).getValor());

        // Si el ultimo token no es la palabra reservada terminar
        if (!(ultimoToken.getTipo() == Tipos.PALABRA_RESERVADA_TERMINAR)) {
            errores += "No se ha encontrado la palabra reservada TERMINAR \n";
            hayErrores = true;
        }
        
        if (!hayErrores) {
            // Si el numero de condicionales y ciclos por cerrar no es 0
            if (!(numeroDeCondicionesYCiclosPorCerrar == 0)) {
                errores += "Error en cierres de condicionales ó ciclo, verifique los corchetes de cierre y apertura \n";
                hayErrores = true;
            }
        }
        
        txtErroresLexico.setText(errores);
        
        if (hayErrores) {
            txtErroresLexico.setBackground(Color.red);
        } else {
            
            btnAnalisisSintactico.setEnabled(false);
            btnAnalisisSemantico.setEnabled(true);
            labelEtapa.setText("{Análisis semántico}");
            JOptionPane.showMessageDialog(this, "Etapa de analsís sintáctico pasada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        

    }//GEN-LAST:event_btnAnalisisSintacticoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        btnAnalisisLexico.setEnabled(true);
        btnAnalisisSintactico.setEnabled(false);
        btnAnalisisSemantico.setEnabled(false);
        
        txtErroresLexico.setBackground(Color.BLACK);
        labelEtapa.setText("{Análisis sintáctico}");
        txtErroresLexico.setText("");
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimpiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCodigoActionPerformed
        
        txtCodigo.setText("");

    }//GEN-LAST:event_btnLimpiarCodigoActionPerformed

    private void btnAnalisisSemanticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisSemanticoActionPerformed

        /* ANALISIS SEMÁNTICO */
        String errores = "--------------------------------->  ERRORES SEMÁNTICOS  <--------------------------------\n\n";
        
        boolean hayErrores = false;

        // Verificar si las variables ya han sido declaradas previamente
        for (int i = 0; i < this.tokens.size(); i++) {

            // Si es declaración de variable
            if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_ENTERO
                    || this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_DECIMAL
                    || this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_TEXTO) {
                
                boolean yaHaSidoDeclarada = HelperSemanctico.laVariableYaHaSidoDeclarada(tokens, i, this.tokens.get(i + 1).getValor());

                // Si la variable ya ha sido declarada antes
                if (yaHaSidoDeclarada) {
                    errores += "Error la variable " + this.tokens.get(i + 1).getValor() + " ya ha sido declarada  \n";
                    hayErrores = true;
                    break;
                }

                // Verificamos que al declarar la variable se esta inicializando con su mismo tipo de dato
                boolean haSidoDeclaradaCorrectamente = HelperSemanctico.laVariableDeclaradaEsInicializadaCorrectamente(tokens, i);
                
                if (!haSidoDeclaradaCorrectamente) {
                    errores += "Error en la inicialización de la variable " + this.tokens.get(i + 1).getValor() + "\n";
                    hayErrores = true;
                    break;
                }
                
                i = HelperSemanctico.continuarPos;

                // Si es asignacion de variable 
            } else if (this.tokens.get(i).getTipo() == Tipos.IDENTIFICADOR) {
                
                boolean yaHaSidoDeclarada = HelperSemanctico.laVariableYaHaSidoDeclarada(tokens, i, this.tokens.get(i).getValor());
                
                if (!yaHaSidoDeclarada) {
                    errores += "Error la variable " + this.tokens.get(i).getValor() + " no ha sido declarada  \n";
                    hayErrores = true;
                    break;
                }

                // Verificamos que las asignaciones sean del mismo tipo de dato
                boolean laAsignacionEsCorrecta = HelperSemanctico.laAsignacionDeUnaVariableEsCorrecta(this.tokens, i);
                
                if (!laAsignacionEsCorrecta) {
                    errores += "Error en la asignación de la variable " + this.tokens.get(i).getValor() + "\n";
                    hayErrores = true;
                    break;
                }
                
                i = HelperSemanctico.continuarPos;

                // Si es una condicional
            } else if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_SI) {
                
                boolean lasVariablesDelaCondicionYaFueronDeclaradas = HelperSemanctico.lasVariablesDeUnCicloOCondicionYaFueronDeclaradas(tokens, i);
                
                if (!lasVariablesDelaCondicionYaFueronDeclaradas) {
                    errores += "Error las variable(s) de una condición SI no estan declaradas\n";
                    hayErrores = true;
                    break;
                }
                
                boolean lasVariablesDeLaCondicionSonDelMismoTipo = HelperSemanctico.lasVariablesDeUnCicloOCondicionSonDelMismoTipo(tokens, i);
                
                if (!lasVariablesDeLaCondicionSonDelMismoTipo) {
                    errores += "Error las variable(s) de una condición SI no son del mismo tipo\n";
                    hayErrores = true;
                    break;
                }
                
                i = HelperSemanctico.continuarPos;

                // Si es un ciclo
            } else if (this.tokens.get(i).getTipo() == Tipos.PALABRA_RESERVADA_CICLO) {
                
                boolean lasVariablesDelaCondicionYaFueronDeclaradas = HelperSemanctico.lasVariablesDeUnCicloOCondicionYaFueronDeclaradas(tokens, i);
                
                if (!lasVariablesDelaCondicionYaFueronDeclaradas) {
                    errores += "Error las variable(s) de un CICLO no estan declaradas\n";
                    hayErrores = true;
                    break;
                }
                
                boolean lasVariablesDeLaCondicionSonDelMismoTipo = HelperSemanctico.lasVariablesDeUnCicloOCondicionSonDelMismoTipo(tokens, i);
                
                if (!lasVariablesDeLaCondicionSonDelMismoTipo) {
                    errores += "Error las variable(s) de un CICLO no son del mismo tipo\n";
                    hayErrores = true;
                    break;
                }
                
                i = HelperSemanctico.continuarPos;
            } else {
                /*
                hayErrores = true;
                errores += "Error sintáctico lamentamos no poder darle una pista ;( \n";
                break;
                 */
                
            }
            
        }
        
        if (hayErrores) {
            txtErroresLexico.setBackground(Color.red);
        } else {
            txtErroresLexico.setBackground(Color.BLACK);
            JOptionPane.showMessageDialog(this, "Etapa de analsís semánctico pasada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        
        txtErroresLexico.setText(errores);
        

    }//GEN-LAST:event_btnAnalisisSemanticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisisLexico;
    private javax.swing.JButton btnAnalisisSemantico;
    private javax.swing.JButton btnAnalisisSintactico;
    private javax.swing.JButton btnLimpiarCodigo;
    private javax.swing.JButton btnSeleccionarArchivoTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelEtapa;
    private javax.swing.JTextArea txtCodigo;
    private javax.swing.JTextArea txtErroresLexico;
    // End of variables declaration//GEN-END:variables
}
