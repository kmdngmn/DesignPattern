package lab03_DecoratorPattern_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface {

	private ArrayList<String> list;

	public LoadHudDisplays(String filename) throws IOException {

		list = new ArrayList<String>();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = null;

			while ((line = reader.readLine()) != null) {

				list.add(line);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<String> load() {

		return list;
	}

}
