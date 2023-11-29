package com.ty;

import java.io.*;

public class Files {
	public static void main(String[] args) {
		File f = new File("new.txt");
		try {
			if (f.createNewFile()) {
				System.out.println("File created Sucessfully");
			} else {
				System.out.println("File not created");
			}

			FileWriter fw = new FileWriter(f);
			fw.write("Hi how are you");
			fw.close();
			FileReader fr = new FileReader(f);
			int x = fr.read();
			while (x != -1) {
				System.out.print((char) x);
				x = fr.read();
			}
			System.out.println();
			boolean flag=f.delete();
			if (flag) {
				System.out.println("File deleted sucessfully");
			} else {
				System.out.println("File is not been deleted");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
