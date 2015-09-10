/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package damaschinas;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
/**
 *
 * @author ALEXIS
 */
public class Sonido {

    public static void Music() {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
       try{
         
          BGM = new AudioStream(new FileInputStream("Super Mario 3 - Start Stage.wav"));
          MD = BGM.getData();
          loop = new ContinuousAudioDataStream(MD);
           
       } catch(IOException error){
           MGP.start(loop);
       }

    }

}
