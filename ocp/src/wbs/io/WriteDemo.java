package wbs.io;

/*
 * java.io.OutputStream
 * 
 public abstract void write(int b)
 throws IOException

 Writes the specified byte to this output stream.
 The general contract for write is that one byte is written to the output stream.
 The byte to be written is the eight low-order bits of the argument b.
 The 24 high-order bits of b are ignored. 
 */

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// path is interface nio file
// file ist class 

public class WriteDemo {

	public static void main(String[] args) throws IOException {

		File path1 = new File("resources/io/os.data");
		File path2 = new File("resources/io/dos_1.data");
		File path3 = new File("resources/io/dos_2.data");

		int n = Integer.MAX_VALUE;

		try (OutputStream os = new FileOutputStream(path1);
				DataOutputStream dos1 = new DataOutputStream(new FileOutputStream(path2));
				DataOutputStream dos2 = new DataOutputStream(new FileOutputStream(path3))) {
			// Writes the specified byte
			// (the low eight bits of the argument b) to the underlying output
			// stream
			// obwohl die methode write(int b) als parameter int deklariert,
			// wird nur 1 byte geschrieben!
			os.write(n);
			// Writes the specified byte
			// (the low eight bits of the argument b) to the underlying output
			// stream
			// obwohl die methode write(int b) als parameter int deklariert,
			// wird nur 1 byte geschrieben!
			dos1.write(n);
			dos2.writeInt(n);
			

		}

		System.out.println(path1.length()); // 1   The general contract for write is that one byte is written to the output stream.
		//The byte to be written is the eight low-order bits of the argument b. The 24 high-order bits of b are ignored. 
		System.out.println(path2.length()); // 1
		System.out.println(path3.length()); // 4
	//	age writeLong bood 8 mishod
	}
}
