package lab03_DecoratorPattern_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 정보 디스플레이 구성을 위해 디스플레이 이름들을 읽어서 리스트로 구성해서 반환하는 인터페이스 인터페이스를 구현하는 클래스에서는 정보
 * 디스플레이 구성을 일반 파일에서 디스플레이 구성 요소의 이름을 읽어서 처리함 load() 함수에는 구성 요소를 지정하는 파일 이름이 없기
 * 때문에 이를 구현하는 클래스에서는 생성자 등을 통해서 파일 이름을 전달 받고, load() 함수 내에서 사용할 수 있도록 해야 함
 * 
 */
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<String> load() {
		return list;
	}

}
