package baekjoonStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int a = Integer.parseInt(br.readLine());
			for (int i = 0; i < a; i++) {
				String tmp = br.readLine();
				String[] num = tmp.split("");
				
				bw.write((Integer.parseInt(tmp)+Integer.parseInt(tmp2))+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
