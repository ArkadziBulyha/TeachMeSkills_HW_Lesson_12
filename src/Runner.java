import java.io.*;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        ArrayList<String> listPTF = getListPTF();

        String dataFile;
        String infoFile = "";
        String PTFValidDocs = "C:\\Users\\messo\\Desktop\\Lessons\\TeachMeSkills_HW_Lesson_12\\ValidDocs.txt";

        Set<String> listDocs = new HashSet<>();
        Map<String, String> docsMap = new HashMap<>();

        for (String item : listPTF) {
            try (FileInputStream DocsFile = new FileInputStream(item);
                 BufferedReader DocsFileBuff = new BufferedReader(new InputStreamReader(DocsFile));
                 FileOutputStream ValidFile = new FileOutputStream(PTFValidDocs);
                 BufferedWriter ValidOutBuff = new BufferedWriter(new OutputStreamWriter(ValidFile))) {

                dataFile = DocsFileBuff.readLine();
                if (listDocs.add(dataFile)) {
                    infoFile = Docs.checkDocs(dataFile);
                    docsMap.put(dataFile, infoFile);
                }

                for (String key : docsMap.keySet()) {
                    ValidOutBuff.write(key + " - " + docsMap.get(key));
                    ValidOutBuff.newLine();
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Пожалуйста, укажите путь к файлу:"); //C:\Users\messo\Desktop\Lessons\TeachMeSkills_HW_Lesson_12\Lesson_12_Docs.txt
//        String PTF = sc.next(); // PTF - PathToFile
//
//        String dataFile;
//        String infoFile;
//        String PTFValidFile = "C:\\Users\\messo\\Desktop\\Lessons\\TeachMeSkills_HW_Lesson_12\\ValidDocs.txt";
//        String PTFNotValidFile = "C:\\Users\\messo\\Desktop\\Lessons\\TeachMeSkills_HW_Lesson_12\\NotValidDocs.txt";
//
//        try (FileInputStream DocsFile = new FileInputStream(PTF);
//             FileOutputStream ValidFile = new FileOutputStream(PTFValidFile);
//             FileOutputStream NotValidFile = new FileOutputStream(PTFNotValidFile);
//             BufferedReader DocsFileBuff = new BufferedReader(new InputStreamReader(DocsFile));
//             BufferedWriter ValidOutBuff = new BufferedWriter(new OutputStreamWriter(ValidFile));
//             BufferedWriter NotValidOutBuff = new BufferedWriter(new OutputStreamWriter(NotValidFile))) {
//
//            while ((dataFile = DocsFileBuff.readLine()) != null) {
//                infoFile = Docs.checkDocs(dataFile);
//                if (infoFile.isEmpty()) {
//                    ValidOutBuff.write(dataFile);
//                    ValidOutBuff.newLine();
//                    ValidOutBuff.flush();
//                } else {
//                    NotValidOutBuff.write(dataFile + " - " + infoFile);
//                    NotValidOutBuff.newLine();
//                    NotValidOutBuff.flush();
//                }
//                System.out.println(dataFile);
//            }
//
//            System.out.println("Хмм...Успешненько?!");
//
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

    }

    static ArrayList<String> getListPTF() {

        ArrayList<String> listPathToFile = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String PTF = "";

        boolean ok = false;
        while (!ok) {
            System.out.println("Пожалуйста, укажите путь к файлу или нажмите 0 для прекращения:");
            PTF = sc.next();

            if (!PTF.contains("0")) {
                listPathToFile.add(PTF);
            } else {
                ok = true;
            }
        }
        sc.close();
        return listPathToFile;
    }

}
