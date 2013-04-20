package com.adaptionsoft.games.trivia.test;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public abstract class AbstractTriviaTest {
	protected Checker checker;
	
	class Checker extends OutputStream{
		Checksum checksum = new CRC32();
		public void write (int b) throws IOException{
			checksum.update(b);
		}
	}
}
