import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException{

        int result = -1;
        Connection conn = SQLiteManager.getConnection();
        List<Map<String, Object>> resultList;

        MenuShow m = new MenuShow();
        CRUD crudService = new CRUD();
        SearchService searchService = new SearchService();
        DDLService DDL = new DDLService(conn);
        DMLService DML = new DMLService(conn);
        DQLService DQL = new DQLService(conn);
        FileService fileService = new FileService();

        DDL.createTable();

        while(true) {
            try {
                String choose = m.showMenu();
                switch(choose){
                    case "1":
                        crudService.readData(DQL);
                        break;

                    case "2":
                        result = DML.insertDATA(crudService.createData());
                        if( result >= 0 ) {
                            System.out.println("스케쥴이 추가되었습니다.");
                        } else {
                            System.out.println("데이터 입력 실패");
                        }
                        //list.add(crudService.createData(list));
                        //System.out.println("스케쥴이 추가되었습니다.");
                        break;

                    case "3":
                        crudService.readData(DQL); // 데이터 출력

                        result = DML.updateData(crudService.updateData());
                        if( result >= 0 ) {
                            System.out.println("스케쥴이 수정되었습니다.");
                        } else {
                            System.out.println("데이터 수정 실패");
                        }


                        //crudService.readData(list);
                        //crudService.updateData(list);
                        System.out.println("스케쥴이 수정되었습니다.");
                        break;

                    case "4":
                        crudService.readData(DQL); // 데이터 출력

                        result = DML.deleteDATA(crudService.deleteData());
                        if( result >= 0 ) {
                            System.out.println("스케쥴이 삭제되었습니다.");
                        } else {
                            System.out.println("데이터 삭제 실패");
                        }

                        //crudService.readData(list);
                        //crudService.deleteData(list);
                        System.out.println("스케쥴이 삭제되었습니다.");
                        break;

                    case "5":
                        resultList = DQL.selectByName(searchService.searchByName());
                        DQL.printMapList(resultList);
                        break;

                    case "6":
                        resultList = DQL.selectAll();
                        fileService.saveFile(resultList);
                        System.out.println("스케쥴이 파일에 저장되었습니다.");

                        //fileService.saveFile(list);
                        //System.out.println("스케쥴이 파일에 저장되었습니다.");
                        break;

                    case "0":
                        System.out.println("종료");
                        return;

                    default:
                        System.out.println("잘못된 번호를 입력하셨습니다.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}