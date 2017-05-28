import java.applet.Applet;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

/// <summary>
/// キー情報の管理クラス
/// </summary>
public class KeyInformation extends Applet {
    private String   _TxStr;
    private float    _width;
    private float    _height;

    private KeyInformation _key;
    private FontMetrics _f;
    //private BufferedReader _reader;

    /// <summary>
    /// コンストラクタ
    /// </summary>
    private KeyInformation( float width, float height ) {
        this._width       = width;
        this._height      = height;
        this._TxStr       = "";
        //this._reader      = new BufferedReader( new InputStreamReader( System.in ) );
     }

    /// <summary>
    /// Singleton パターンに対応。
    /// </summary>
    private KeyInformation getInstance(){
        return ( this._key );
    }

    /// <summary>
    /// paint()
    /// Argument : Graphics g
    /// </summary>
    public void paint( Graphics g ) {
        Initialize( );
	g.drawString( _TxStr , (width / 2) - (_f.stringWidth(_TxStr)) / 2 , (height / 2) );
    }
    
    /// <summary>
    /// Initalize( )
    /// Argument : Nothing
    /// </summary>
    public void Initialize() {
        try {
            addKeyListener (
                new KeyAdapter() {
		    public void keyPressed(final KeyEvent e) {
                         _TxStr = e.getKeyText( e.getKeyCode() );
                        repaint();
		    }
		}
            );
            System.out.println( "String is : " + this._TxStr );
        } 
        catch ( Exception e ) {
            System.out.println( "Exception :" + e );
        }
    }
}
