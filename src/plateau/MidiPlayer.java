package plateau;

import javax.sound.midi.*;
import java.io.*;
/** Plays a midi file provided on command line */
public class MidiPlayer {

	public static void play(String string) {
		InputStream in = ChargerPlateau.class.getResourceAsStream("/musiques/"+string); 
		// Play once
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.setSequence(MidiSystem.getSequence(in));
			sequencer.open();
			sequencer.start();
			while(true) {
				if(sequencer.isRunning()) {
					try {
						Thread.sleep(1000); // Check every second
					} catch(InterruptedException ignore) {
						break;
					}
				} else {
					break;
				}
			}
			// Close the MidiDevice & free resources
			sequencer.stop();
			sequencer.close();
		} catch(MidiUnavailableException mue) {
			System.out.println("Midi device unavailable!");
		} catch(InvalidMidiDataException imde) {
			System.out.println("Invalid Midi data!");
		} catch(IOException ioe) {
			System.out.println("I/O Error!");
		} 		
	}
	
}
