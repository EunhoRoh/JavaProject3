import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUD {

    BufferedReader br;

    public void readData(DQLService dql) {
        List<Map<String, Object>>  resultList = dql.selectAll();
        dql.printMapList(resultList);
    }


    public HashMap<String, Object> createData() {

        int num;
        String name;
        String regiDate;
        String part;
        int numOfSets;
        int reps;
        int weight;
        String exercise;

        final HashMap<String, Object> dataMap = new HashMap<String, Object>();

        try {
            System.out.print("이름 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            name = br.readLine();
            dataMap.put("NAME"   , name);
            System.out.print("부위 : ");
            part = br.readLine();
            dataMap.put("PART"   , part);
            System.out.print("운동 : ");
            exercise = br.readLine();
            dataMap.put("EXERCISE"   , exercise);
            System.out.print("셋트수 : ");
            numOfSets = Integer.parseInt(br.readLine());
            dataMap.put("NUM_OF_SETS"   , numOfSets);
            System.out.print("횟수 : ");
            reps = Integer.parseInt(br.readLine());
            dataMap.put("REPS"   , reps);
            System.out.print("무게(kg) : ");
            weight = Integer.parseInt(br.readLine());
            dataMap.put("WEIGHT"   , weight);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regiDate = date.format(formatter);

        dataMap.put("REG_DATE" , regiDate);

        /*DataManage d = new DataManage( num, regiDate, name, part,exercise, numOfSets, reps,
                weight);*/

        return dataMap;
    }

    public HashMap<String, Object> updateData() {
        int num;
        String name;
        String regiDate;
        String part;
        int numOfSets;
        int reps;
        int weight;
        String exercise;

        final HashMap<String, Object> updateMap = new HashMap<String, Object>();

        try {
            System.out.print("수정하고 싶은 스케쥴의 번호를 입력하시오(1~100) : ");
            br = new BufferedReader(new InputStreamReader(System.in));

            num = Integer.parseInt(br.readLine());
            updateMap.put("updateID" , num);

            System.out.print("이름 : ");
            name = br.readLine();
            updateMap.put("NAME"   , name);

            System.out.print("부위 : ");
            part = br.readLine();
            updateMap.put("PART"   , part);

            System.out.print("운동 : ");
            exercise = br.readLine();
            updateMap.put("EXERCISE"   , exercise);

            System.out.print("셋트수 : ");
            numOfSets = Integer.parseInt(br.readLine());
            updateMap.put("NUM_OF_SETS"   , numOfSets);

            System.out.print("횟수 : ");
            reps = Integer.parseInt(br.readLine());
            updateMap.put("REPS"   , reps);

            System.out.print("무게(kg) : ");
            weight = Integer.parseInt(br.readLine());
            updateMap.put("WEIGHT"   , weight);

            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            regiDate = date.format(formatter);
            updateMap.put("REG_DATE" , regiDate);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return updateMap;
    }

    public int deleteData() {

        int num = 0;

        try {
            System.out.println("삭제하고 싶은 스케쥴의 번호를 입력하시오(1 ~ 100) : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}
