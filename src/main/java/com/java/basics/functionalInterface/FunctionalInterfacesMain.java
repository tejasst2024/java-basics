package com.java.basics.functionalInterface;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalInterfacesMain {

    public static void main1(String[] args) {
        Predicate<String> predicate = Predicate.isEqual("test1");
        Predicate<String> predicate1 = predicate.and(x -> x.length() == 5);
        System.out.println(predicate.test("test1"));
        System.out.println(predicate1.test("test1"));

        Consumer<String> consumer = System.out::println;
        consumer.accept("Test12344");
        Consumer<String> consumer1 = System.out::print;
        consumer1.andThen(consumer);

        Function<Boolean, String> val = Object::toString;
        Comparator<Boolean> comparable = Comparator.comparing(val);

        Supplier<String> s1 = String::new;

        Map<String, Integer> map = new HashMap<>();
        map.put("c", 21);
        map.put("q", 12);
        map.put("a", 17);
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(System.out::println);

    }

    public static void main(String[] args) throws Exception {

        List<String> domains = Arrays.asList("apple", "ugi", "loyalty", "1drap");
        Collections.sort(domains, Collections.reverseOrder());
        System.out.println(domains);

        if(null instanceof Integer) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
//        JsonPath testDataJSONString;
//        String strJSONPath = "";
//
//        int rowData = 0;
//        String strServiceFolder;
//        if (scenarioContext.getScenarioContext("FeatureFileName").toString().contains("_"))
//            strServiceFolder = scenarioContext.getScenarioContext("FeatureFileName").toString().split("_")[0];
//        else
//            strServiceFolder = scenarioContext.getScenarioContext("FeatureFileName").toString();
//        String strFeatureName = scenarioContext.getScenarioContext("FeatureFileName").toString();
//        String strScenarioOutLineName = scenarioContext.getScenarioContext("ScenarioName").toString();
//        String strEnvironment = scenarioContext.getScenarioContext("Environment").toString();
//        String path = CommonUtils.currentProjectPath();
//        String strTestDataFolderPath = path + strServiceFolder.substring(0, 1).toLowerCase()+strServiceFolder.substring(1) + File.separator + strFeatureName + ".json";
////        String testData =
//        String jsonTestData = readDataFromFile(strTestDataFolderPath);
//        strJSONPath = strFeatureName + "." + strScenarioOutLineName + "." + scenarioContext.getScenarioContext("host").toString() + "."+ strEnvironment + "[" + rowData + "]" + ".";
//        testDataJSONString = new JsonPath(jsonTestData);
//        scenarioContext.setScenarioContext("TestDataJSONString", testDataJSONString);
//        scenarioContext.setScenarioContext("JSONPath", strJSONPath);
//        HashMap<String, Object> map = new ObjectMapper().convertValue(testDataJSONString.getJsonObject(strJSONPath), HashMap.class);
//        scenarioContext.setScenarioContext("testDataMap" , map);
//        testDataMap = (HashMap<String, String>) scenarioContext.getScenarioContext("testDataMap");
//        writeContentToFile("src/main/resources/data.sql", "{\n" +
//                "    \"TransactionProcessingService\": {\n" +
//                "          {\"TransactionProfileCommit\": {\n" +
//                "             \"Cloud\": {\n" +
//                "                \"Q1\": \"\"\n" +
//                "               }\n" +
//                "          }\n" +
//                "}");
        String content = readDataFromFile("src/main/resources/data.sql");
        JsonNode json = new ObjectMapper().readValue(content, JsonNode.class);
        System.out.println(json);
    }

    public static String readDataFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void writeContentToFile(String strFile, String content) throws Exception {
        try {
            File file = new File(strFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            throw new Exception("Error while writting content to File :: " +e.getMessage());
        }
    }
}


