import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchService {

    BufferedReader br;

    public String searchByName(){

        String name = null;

        System.out.println("검색할 이름을 입력하세요.");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            name = br.readLine();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return name;
    }
}