import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	ArrayList<JLabel> list = new ArrayList<JLabel>();

	
	int lines;
	Stack<String> words = new Stack<String>();
	void setup() {
		String word= words.get(new Random().nextInt(words.size()));
		int length = word.length();
		frame.add(panel);
		for (int i = 0; i < word.length(); i++) {
			JLabel label = new JLabel();
			label.setText(word.substring(i, i+1));
			list.add(label);
			panel.add(label);
		}
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.pack();

		
		
	}
	
public static void main(String[] args) {
Hangman hangman = new Hangman();
hangman.words();
hangman.setup();
}
void words() {
	try {
		// Get the amount of lines
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File("/usr/share/dict/words")));
		lnr.skip(Long.MAX_VALUE);// Skip to the end
		lines = lnr.getLineNumber();// Get last line number

		System.out.println("Number of words: " + lines);
		lnr.close();
		BufferedReader br = new BufferedReader(new FileReader(new File("/usr/share/dict/words")));
		for (int i = 0; i < lines; i++) {
			words.push(br.readLine().toLowerCase()); // adds every line to the array
		}
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	

}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
