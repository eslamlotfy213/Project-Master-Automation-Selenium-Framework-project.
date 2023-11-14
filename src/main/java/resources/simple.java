package resources;

import java.io.IOException;
import java.util.ArrayList;

public class simple {


    public static void main(String[] args) throws IOException {

        String Values ;
        dataDriven getData = new dataDriven();

        ArrayList data=  getData.getData("Login","TestCases","TestData1","src/main/java/resources/Data.xlsx");

//        System.out.println(data.get(0));
//        System.out.println(data.get(1));
//        System.out.println(data.get(2));

        for (int i = 0; i< data.size();i++){
		Values =  data.get(i).toString();
		System.out.print(Values+" | ");
	}



    }
}

