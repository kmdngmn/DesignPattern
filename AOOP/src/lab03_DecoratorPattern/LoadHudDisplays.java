package lab03_DecoratorPattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface {

	private ArrayList<String> list;

	public LoadHudDisplays(String filename) throws IOException {
		// 파일입출력

		list = new ArrayList<String>();

		String line = "";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<String> load() {
		// TODO Auto-generated method stub
		// 리스트반환
		return list;
	}

}

/**
 * load() 함수에는 구성 요소를 지정하는 파일 이름이 없기 때문에 이를 구현하는 클래스에서는 생성자 등을 통해서 파일 이름을 전달 받고,
 * load() 함수 내에서 사용할 수 있도록 해야 함
 * 
 */

/**
 * <p>
 * 파일을 읽고 각 줄에 있는 내용을 리스트로 구성해서 반환함
 * </p>
 * 
 * @param 없음
 * @return 파일에 있는 각 줄의 내용을 각각 요소로 갖는 리스트
 */