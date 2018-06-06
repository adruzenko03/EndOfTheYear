package RefrenceCode;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Sound {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200,200);
        JButton button = new JButton("Click me");
        frame.add(button);
        button.addActionListener(new AL());
        frame.show(true);
    }
    public static class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e) {
            music();
        }}
    public static void music(){
        AudioPlayer BGP = AudioPlayer.player;
        //AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try {
            String gongFile = "wiiMusic.wav";
            InputStream in = new FileInputStream(gongFile);

            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);
            MD = audioStream.getData();


            //InputStream test = new FileInputStream("C:\\ wiiMusic.wav");
            //BGM = new AudioStream(test);
            /*BGM = new AudioStream(new FileInputStream("wiiMusic.wav"));
            MD = BGM.getData();*/
            loop = new ContinuousAudioDataStream(MD);
        }catch(IOException error) {
            System.out.println("Error");
        }
        BGP.start(loop);
    }
}
