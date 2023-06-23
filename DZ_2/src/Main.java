import java.util.Arrays;


public class Main {

    public static String[] ReplaceStr(String line) {

        line = line.replace("{", "").replace("}", "").replace("\"", "");
        String[] arrayData = line.split(", ");
        return arrayData;
    }

    public static void main(String[] args) throws Exception {


        String[] list = lib.ReadLineFromFile("data.txt");
        String[] arrayData = ReplaceStr(list[0]);

        StringBuilder result = new StringBuilder("select * from students where ");


        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if (arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(" and ");
                }
                result.append(arrData[0]);
                result.append(" = \"");
                result.append(arrData[1]);
                result.append("\"");
            }

        }
        System.out.println(result);

        for (int i = 1; i < list.length; i++) {
            arrayData = ReplaceStr(list[i]);
            for (int k = 0; k < arrayData.length; k++) {
                String line2 = arrayData[k].replace("фамилия", "Студент ").replace("оценка", " получил ").replace("предмет", " по предмету ").replace(",","");
                String[] arrData = line2.split(":");
                result = new StringBuilder("");
                for (int j = 0; j < arrData.length; j++) {
                    result.append(arrData[j]);
                }
                System.out.println(result);
            }
        }

        String list2 = lib.ReadLineFromFile("data1.txt")[0];
        long start = System.nanoTime();
        list2 = list2.replace("j","J");
        System.out.println(System.nanoTime() - start);


        start = System.nanoTime();
        StringBuilder list3 = new StringBuilder(list2);
        int ind = list3.indexOf("J");
        while(ind > 0){
            list3.replace(ind-1,ind+1,"j");
            ind = list3.indexOf("J");
         }
        System.out.println(System.nanoTime() - start);

    }
}
