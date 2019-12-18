/* MovieMediaList 클래스에서 리스트 안에 있는 각 요소를 추출하는 코드가 필요한데
   구현되어 있지 않음. 다행스럽게도 MovieMediaList에 있는 list 변수가 private이
   아니라 default로 되어 있어 상속된 클래스에서 list 변수에 접근 가능. 그래서 새로운
   자식 클래스를 만들고 필요한 함수들을 추가함
   Adapter 클래스는 ExtendedMovieMediaList를 사용하게 됨
 */
public class ExtendedMovieMediaList extends MovieMediaList {
    ExtendedMovieMediaList() {
        super();
    }

    MovieMedia get(int index) {
        return list.get(index);
    }

    int size() {
        return list.size();
    }
}
