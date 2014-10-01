package juego;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Iliana y Ricardo
 */
public class Juego extends JFrame implements Runnable, KeyListener{
    
    //Variables para la animacion de la bomba
    private Animacion aniAnim;
    private long lTiempoActual;
    private long lTiempoInicial;
    int iPosX;
    int iPosY;
    
    //Objetos del tipo Objeto (personajes)
    private Objeto objPersonaje;
    private Objeto objBarra;
    private Objeto objBomba;
    private Objeto objUP1;
    private Objeto objUP2;
    
    //Declaro variables
    private Image imaImagenApplet;
    private Graphics graGraficaApplet;
    private SoundClip sndSonidoMenu;
    private SoundClip sndSonidoJuego;
    
    //Declaracion de imagenes
    private Image imgPaused; //Variable para la imagen de pausa
    private Image imgMenu; //Variable para la imagen del menu
    private Image imgInst; //Variable para la imagen de instrucciones
    private Image imgGame; //Fondo para el juego
    private Image imgBarra;
    private Image imgWhite;
    private Image imgGus;
    private Image imgMike;
    private Image imgJesse;
    private Image imgHeisenberg;
    private Image imgPerdiste;
    private Image imgGanaste;
    private Image imgBomb1;
    private Image imgBomb2;
    private Image imgBomb3;
    private Image imgBomb4;
    private Image imgBomb5;
    private Image imgBomb6;
    private Image imgBomb7;
    private Image imgBomb8;
    private Image imgBomb9;
    private Image imgBomb10;
    private Image imgBomb11;
    private Image imgBomb12;
    private Image imgUp1;
    private Image imgUp2;
    private Image imgPGif;
    private Image imgPGif2;
    private Image imgWGif;
    private Image imgWGif2;
    private Image imgIGif;
    
    
    //Declaracion de Booleanas
    private Boolean bMenu; //Variable para ver si se esta mostrando el menu
    private Boolean bStart; //Variable para ver si ya se inicio el juego
    private Boolean bInst; //Variable para ver si se tienen que mostrar las instrucciones
    private Boolean bPausa; //Variable para manejar la pausa del juego
    private Boolean bBomba; //Variable para ver si ya se solto la bomba
    private Boolean bPerdiste; //Variable para ver si el jugador perdio
    private Boolean bGanaste; //Variable para ver si el jugador gano
    private Boolean bUp1;
    private Boolean bUp2;
    
    //Declaracion de integers
    private int iDireccion;
    private int iScore;
    private int iVelocidad;
    private int iMoveX;
    private int iMoveY;
    private int iXBarra;
    private int iYBarra;
    private int iXBomb;
    private int iYBomb;
    private int iXPer;
    private int iYPer;
    private int iVidas;
    private int iCont;
    private int iContP;
    private int iNivel;
    
    //Declaro mi arreglo para guardar objetos del tipo Objeto (Mr.White)
    private Objeto [] objPersonajes;
    
    
    public Juego(){
        init();
        start();
    }
    
    public void init(){
        //Hago el applet de un tamaño 1000 x 625
        setSize(1000, 625);
        
        //Inicializo las Imagenes
        imgPaused = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("pausa.png"));
        imgMenu = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("breakingBadMenu.jpg"));
        imgInst = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("instructions.jpg"));
        imgGame = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("game.jpg"));
        imgBarra = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("barra.png"));
        imgWhite = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("White.png"));
        imgGus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Gus.png"));
        imgJesse = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Jesse.png"));
        imgMike = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mike.png"));
        imgHeisenberg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Heisenberg.png"));
        imgPerdiste = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("perdiste.jpg"));
        imgGanaste = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ganaste.jpg"));
        imgUp1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("crystal.png"));
        imgUp2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("potion.png"));
        imgPGif = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("throwing.gif"));
        imgWGif = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("win.gif"));
        imgPGif2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bullshit.gif"));
        imgWGif2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("iwon.gif"));
        imgIGif = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("blocks.gif"));
        
        
        //Imagenes para la animacion de la bomba
        imgBomb1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb1.png"));
        imgBomb2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb2.png"));
        imgBomb3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb3.png"));
        imgBomb4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb4.png"));
        imgBomb5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb5.png"));
        imgBomb6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb6.png"));
        imgBomb7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb7.png"));
        imgBomb8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb8.png"));
        imgBomb9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb9.png"));
        imgBomb10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb10.png"));
        imgBomb11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb11.png"));
        imgBomb12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bomb12.png"));
        
        //Cancion para el menu
        sndSonidoMenu = new SoundClip("BreakingBadTheme.wav");
        
        //Cancion para el juego
        sndSonidoJuego = new SoundClip("SmokingPot.wav");
        
        //Inicializo en falso el perder y ganar
        bGanaste = false;
        bPerdiste = false;
        
        
        
        //Score inicial
        iScore = 0;
        iNivel = 1;
        
        //Llamo al metodo reiniciar variables, en la que se declaran los valores iniciales
        reiniciarVariables();
        
        //Implemento el Key Listener
        addKeyListener(this);
    }
    
    public void start(){
        //Declara un hilo
        Thread th = new Thread(this);
        //Empieza el hilo
        th.start();
    }
    
    public void run() {
        
        //Pongo la musica
        sndSonidoMenu.play();
        sndSonidoMenu.setLooping(true);
        
        while(iVidas > 0){
           
            
            //Si no has perdido el juego
            if(!bPerdiste){
                 
                //Si no esta la pausa habilitada
                if(!bPausa){
                    //Si no se esta mostrando el menu y ya se inicio el juego
                    if(!bInst && bStart){
                        actualiza();
                        //Si ya se solto la bomba
                        if(bBomba){
                            checaColision();
                        }
                    }
                }
            }
            //Vuelvo a pintar
            repaint();

            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError)	{
                System.out.println("Hubo un error en el juego " + 
                    iexError.toString());
            }
        }
        
        //Variable de la animacion
        lTiempoActual = System.currentTimeMillis();
    }
    
    public void actualiza(){
        
        
        //Variables de la animacion
        long lTiempoTranscurrido = System.currentTimeMillis() - lTiempoActual;
        aniAnim.actualiza(lTiempoTranscurrido);
        
        //Switch que maneja la direccion de la barra
        switch(iDireccion){
            case 1:{ //Si se mueve a la izquierda
                objBarra.setX(objBarra.getX() - iVelocidad);
                break;
            }
            case 2:{ //Si se mueve a la derecha
                objBarra.setX(objBarra.getX() + iVelocidad);
                break;
            }
        }
        
        //Switch que maneja la direccion de la bomba
        if(!bBomba){
            switch(iDireccion){
                case 1:{ //Si se mueve a la izquierda
                    objBomba.setX(objBomba.getX() - iVelocidad);
                    break;
                }
                case 2:{ //Si se mueve a la derecha
                    objBomba.setX(objBomba.getX() + iVelocidad);
                    break;
                }
            }
        }
        
        //Si ya se solto la bomba
        if(bBomba){
            
            //Actualizo la posicion de la bomba en X
            iXBomb = objBomba.getX() + iMoveX;
            objBomba.setX(iXBomb);
            
            //Actualizo la posicion de la bomba en Y
            iYBomb = objBomba.getY() + iMoveY;
            objBomba.setY(iYBomb);
            
            //Si la bomba choca con la pared izquierda o derecha, se cambia el sentido
            if(objBomba.getX() <= 0 || objBomba.getX() + objBomba.getAncho() >= getWidth()){
                iMoveX = -iMoveX;
            }
            //Si la bomba choca con el techo, se cambia el sentido
            if(objBomba.getY() <= 0) {// ////////////////|| bally + Ball.height >= 250
                iMoveY = -iMoveY;
            }
            //Si la bomba toca el piso, se pierde una vida
            if(objBomba.getY() >= getHeight() - objBomba.getAlto()){
                iVidas--;
                iMoveY = -iMoveY;
                
                //Si ya perdio todas las vidas se acaba el juego
                if(iVidas == 1){
                    bPerdiste = true;
                    reiniciarVariables();
                }
            }
        }
        
        /*
        //Intento fallido de los upgrades
        /
        if(bUp1){
            objUP1.setY(objUP1.getY() + 3);
        }
        
        if(bUp2){
            objUP2.setY(objUP2.getY() + 3);
        }
        */
    }
    
    public void checaColision(){
        
        
        //Para que la barra no se salga de la pantalla
        if(objBarra.getX() >= getWidth() - 150){
            iDireccion = 0;
        }
        else if(objBarra.getX() <= 0){
            iDireccion = 0;
        }
        
        //Si la bomba colisiona con la barra
        if(objBomba.colisiona(objBarra)){
            //Rebota con la barra y cambia la direccion de Y
            iMoveY = -iMoveY;
        }
        
        /*
        /Intento fallido de upgrades
        if(bUp1 || bUp2){
            //Si los upgrades colisionan con la barra
            if(objUP1.colisiona(objBarra)){
                iScore+=600;
            }
            if(objUP2.colisiona(objBarra)){
                iScore+=300;
            }
            bUp2 = false;
            bUp1 = false;
        }
                */
        
        //Para checar las colisiones con cualquier elemento Personaje
        for(int iI = 0; iI < objPersonajes.length; iI++){
            if(objPersonajes[iI]!= null){
                objPersonaje = objPersonajes[iI];
                
                //Si la bomba colisiona con el personaje
                if(objBomba.colisiona(objPersonaje)){
                    /*
                    //Intento fallido de crear upgrades
                    //
                    int iUp = 30;
                    if (!bUp1 && iUp < 30) {
                        bUp1 = true;
                        objUP1 = new Objeto(objPersonaje.getX() + objPersonaje.getAncho() / 2, objPersonaje.getY() 
                                + objPersonaje.getAlto() / 2, imgUp1);
                    }
                    else if (!bUp2 && iUp >= 50 && iUp <= 51) {
                        bUp2 = true;
                        objUP2 = new Objeto(objPersonaje.getX() + objPersonaje.getAncho() / 2, objPersonaje.getY() 
                        + objPersonaje.getAlto() / 2, imgUp2);
                    }
                    */
                    
                    if(objBomba.getX() + objBomba.getAncho() >= objPersonaje.getX()){
                        iMoveX = -iMoveX;
                    }
                    else if(objBomba.getX() <= objPersonaje.getX() + objPersonaje.getAncho()){
                        iMoveX = -iMoveX;
                    }
                    else if(objBomba.getY() >= objPersonaje.getY()){
                        iMoveY = -iMoveY;
                    }
                    else if(objBomba.getY() <= objPersonaje.getY() + objPersonaje.getAlto()){
                        iMoveY = -iMoveY;
                    }

                    iScore+=100;
                    objPersonajes[iI] = null;
                    iContP++;
                    
                    
                }
            }
            
            
            
        }
        
        
        
        if(iContP == 36){
            bGanaste = true;
            //iNivel++;
            //reiniciarVariables();
        }
    }
    
    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent keyEvent) {
        //Mover la barra a la izquierda
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && objBarra.getX() >= 0){
            iDireccion = 1;
        }
        //Mover la barra a la derecha
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && objBarra.getX() + objBarra.getAncho() <= getWidth()){
            iDireccion = 2;
        }
        //Al hacer click en la barra, se suelta la pelota
        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
            //Se suelta la bomba y ya no se mueve con la barra
            bBomba = true;
            
            //Si se solto en la mitad izquierda de la pantalla, sale hacia la izquierda
            if(objBomba.getX() < 500){
                iMoveX = -5;
                iMoveY = -5;
            }
            //Si se solto en la mitad derecha de la pantalla, sale hacia la derecha
            else if(objBomba.getX() >= 500){
                iMoveX = 5;
                iMoveY = -5;
            }
        }
        //El juego se cierra si se presiona la tecla E
        if(keyEvent.getKeyCode() == KeyEvent.VK_E){
            System.exit(0);
        }
        //El juego comienza si se presiona la S 
        if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            bMenu = false;
            bStart = true;
            bInst = false;
            bPerdiste = false;
            bGanaste = false;
            iScore = 0;
        }
        //Se despliegan las instrucciones si se presiona I
        if(keyEvent.getKeyCode() == KeyEvent.VK_I){
            bMenu = false;
            bInst = true;
        }
        //Se regresa al Menu principal
        if(keyEvent.getKeyCode() == KeyEvent.VK_M){
            bMenu = true; 
            bInst = false;
            bPerdiste = false;
            bGanaste = false;
            iScore = 0;
        }
        //Se pone pausa al juego
        if(keyEvent.getKeyCode() == KeyEvent.VK_P){
            if(!bPausa){
                bPausa = true;
            }
            else{
                bPausa = false;
            }
        }
        
    }

    public void keyReleased(KeyEvent keyEvent) {
        //Mover la barra a la izquierda
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            iDireccion = 0;
        }
        //Mover la barra a la derecha
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            iDireccion = 0;
        }
    }
    
    public void paint(Graphics graGrafico){
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null){
                imaImagenApplet = createImage (this.getSize().width, 
                        this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics ();
        }

        // Actualiza el Foreground.
        graGraficaApplet.setColor (getForeground());
        paint1(graGraficaApplet);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }
    
    public void paint1(Graphics g){
        //Color para el texto
        g.setColor(Color.WHITE);
        
        g.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        //Se muestra el menu automaticamente
        g.drawImage(imgMenu, 0, 0, this);
        
        //Si se selecciono las instrucciones, se muestran
        if(bInst){
            g.drawImage(imgInst, 0, 0, this);
            g.drawImage(imgIGif, 30, 30, this);
        }
        
        //Si se selecciono start, se dibujan los elementos del juego
        if(bStart){
            //Pongo la imagen de fondo del juego
            g.drawImage(imgGame, 0, 0, this);
            
            
            //Dibujo la barra en la parte inferior de la pantalla
            g.drawImage(objBarra.getImagen(), objBarra.getX(),
                    objBarra.getY(), this);
            
            //Ciclo para checar todos los elementos del arreglo de Personajes
            for(int iI = 0; iI < objPersonajes.length; iI++){
                //Mientras no este vacio el arreglo
                if(objPersonajes[iI]!= null){
                //Dibujo cada personaje
                g.drawImage(objPersonajes[iI].getImagen(), objPersonajes[iI].getX(),
                    objPersonajes[iI].getY(), this);
                }
            }
            
            //Si la bomba ya se solto, comienza la animacion de la bomba
            if(bBomba){
                if(aniAnim != null){
                    g.drawImage(aniAnim.getImagen(), objBomba.getX(), objBomba.getY(), this);
                }
            }
            //Si aun no se suelta, solo muestro la imagen de la bomba
            else if(!bBomba){
                g.drawImage(objBomba.getImagen(), objBomba.getX(),
                    objBomba.getY(), this);
            }
            
            //Muestro el score y las vidas en la pantalla
            g.drawString("Score: " + iScore, 20, 50);
            g.drawString("Vidas: " + (iVidas - 1), 20, 100);
            g.drawString("Nivel: " + (iNivel), 20, 150);
        }
        
        //Si se pausa el juego, muestro la imagen de pausa
        if(bPausa){
            g.drawImage(imgPaused, getWidth()/2 - 128, getHeight()/2 - 128, this);
        }
        //Al perder se muestra el menu de perder
        if(bPerdiste){
            g.drawImage(imgPerdiste, 0, 0, this);
            g.setFont(new Font("Calibri", Font.PLAIN, 60));
            g.drawString("" + iScore, 440, 215);
            g.drawImage(imgPGif, 600, 50, this);
        }
        //Al ganar se muestra el menu de ganar
        if(bGanaste){
            g.drawImage(imgGanaste, 0, 0, this);
            g.setFont(new Font("Calibri", Font.PLAIN, 60));
            g.drawString("" + iScore, 200, 260);
            g.drawImage(imgWGif, 20, 350, this);
        }
        
    }
    
    public void reiniciarVariables(){
        
        //Inicializo las variables para la animacion
        aniAnim = new Animacion();
        aniAnim.sumaCuadro(imgBomb1, 20);
        aniAnim.sumaCuadro(imgBomb2, 20);
        aniAnim.sumaCuadro(imgBomb3, 20);
        aniAnim.sumaCuadro(imgBomb4, 20);
        aniAnim.sumaCuadro(imgBomb5, 20);
        aniAnim.sumaCuadro(imgBomb6, 20);
        aniAnim.sumaCuadro(imgBomb7, 20);
        aniAnim.sumaCuadro(imgBomb8, 20);
        aniAnim.sumaCuadro(imgBomb9, 20);
        aniAnim.sumaCuadro(imgBomb10, 20);
        aniAnim.sumaCuadro(imgBomb11, 20);
        aniAnim.sumaCuadro(imgBomb12, 20);
        
        
        //Inicializo booleans
        bMenu = true; //Para ver si esta activo el menu
        bInst = false; //Para ver si esta activa la ventana de instrucciones
        bStart = false; //Para ver si ya que inicio el juego
        bPausa = false; //Para ver si el juego esta en pausa
        bBomba = false; //Para ver si ya se solto la bomba
        
        //Variable que determina la direccion de la barra y la bomba
        iDireccion = 0;
        
        //Inicializo el resto de las variables
        iCont = 0;
        objPersonajes = new Objeto[36];
        
        bUp1 = false;
        bUp2 = false;
        
        //Velocidad de la barra
        iVelocidad = 15;
        
        iContP = 0;
        
        //Inicializo con 4 vidas
        iVidas = 4;
        
        //Posicion inicial de la bomba
        iXBomb = getWidth()/2 - 25;
        iYBomb = getHeight() - 65;
        
        //Posicion de la barra
        iXBarra = getWidth() / 2 - 75;
        iYBarra = getHeight() - 20;
        
        //Inicializo mis objetos
        objBomba = new Objeto(iXBomb, iYBomb, imgBomb1);
        objBarra = new Objeto(iXBarra, iYBarra, imgBarra);
        
        if(iNivel == 1){
            for (int iY = 0; iY < 6; iY++){

                for (int iX = 0; iX < 11 - (iY * 2); iX++){
                    //Inicializo las posiciones de los caminadores
                    iYPer = 100 + (iY * 53); //Que salgan del lado izquierdo
                    iXPer = 225 + (iX * 50) + (iY * 53);

                    // se crea el Objeto
                    objPersonaje = new Objeto(iXPer, iYPer, imgJesse);

                    //Guardo el objeto en la lista
                    //lnkPersonajes.add(objWhite);

                    if(iCont < 36){
                        objPersonajes[iCont] = objPersonaje;
                    }
                    iCont++;
                }
            }
        }
        else if(iNivel == 2){
            for (int iY = 0; iY < 6; iY++){

                for (int iX = 0; iX < 11 - (iY * 2); iX++){
                    //Inicializo las posiciones de los caminadores
                    iYPer = 100 + (iY * 53); //Que salgan del lado izquierdo
                    iXPer = 225 + (iX * 50) + (iY * 53);

                    // se crea el Objeto
                    objPersonaje = new Objeto(iXPer, iYPer, imgWhite);

                    //Guardo el objeto en la lista
                    //lnkPersonajes.add(objWhite);

                    if(iCont < 36){
                        objPersonajes[iCont] = objPersonaje;
                    }
                    iCont++;
                }
            }
        }
    }
}
