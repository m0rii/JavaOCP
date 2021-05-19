package wbs.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * was sieht man, wenn man die datei 
data_output.data mit einem text-editor
öffnet? nur String konnen wir lesen weil es ist mit string aber andre mit byte generiet und konnen wir nicht lesen

wie gross ist die datei? kann man die groesse der
datei herleiten? falls ja: wie? 36 byte , ja java secificio

welchen typ erwartet der konstruktor
von DataOutputStream? FileOutputStream is sub class of DataOutputStream so it ist ok;

welches interface wird von DataOutputStream
implementiert, das methoden zum schreiben 
primitiver typen deklariert? interface DataOutput

was kann man über den inhalt der datei data_output.data 
sagen, wenn man nur die datei hat, und keine weiteren
informationen über die datei? 


 */
public class DataOutputStreamDemo {
	public static void main(String[] args) {
		String path = "resources/io/data_output.data";
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
			dos.writeBoolean(true); // 1 byte
			dos.writeByte(1); //  
			dos.writeShort(2); //
			dos.writeInt(3); //
			dos.writeLong(4); // 8 byte
			dos.writeFloat(5.0f); // 
			dos.writeDouble(6.0);//
			dos.writeUTF("sieben"); //  2 + unicode x -> x=6 "sieben"
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}