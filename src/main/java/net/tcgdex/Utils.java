package net.tcgdex;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

class Utils {

	static String doGet(String url) throws IOException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;

		client = HttpClients.createDefault();
		HttpGet httpPost = new HttpGet(url);

		response = client.execute(httpPost);

		String output = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = null;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		output = builder.toString();
		return output;
	}

	public static BufferedImage getImage(String imageUrl) throws IOException {
		return ImageIO.read(new URL(imageUrl));
	}

	public static String prettifyEnumName(Enum<?> enumInstance) {
		boolean space = true;
		String rawRepresentation = enumInstance.name();
		StringBuilder output = new StringBuilder(rawRepresentation.length());
		for (int i = 0; i < rawRepresentation.length(); i++) {
			String character = rawRepresentation.substring(i, i + 1);
			if (character.equals("_")) {
				output.append(" ");
				space = true;
				continue;
			}
			if (space) {
				// keep upper case
				space = false;
				output.append(character);
			} else {
				output.append(character.toLowerCase());
			}
		}
		return output.toString();
	}

}
