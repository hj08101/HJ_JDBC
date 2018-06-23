package com.hj.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TempTest {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("account.txt");
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] infos = line.split("\\|");
			if (infos == null || infos.length < 2) {
				continue;
			}
			String username = infos[0];
			String password = infos[1];
			System.out.println(username + ", " + password);
		}
	}
}
