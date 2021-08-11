package medium;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lijx
 * @date 2019/1/18 - 17:00
 * 621. 任务调度器
 */
public class LeastInterval {


    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        HashMap<Character, Integer> pool = removeDuplicate(tasks);
        ArrayList<Character> queue = new ArrayList<>();


        return 0;
    }

    private HashMap<Character, Integer> removeDuplicate(char[] tasks) {
        HashMap<Character, Integer> pool = new HashMap<Character, Integer>(27);
        for (int i = 0; i < tasks.length; i++) {
            Character tmp = tasks[i];
            if (pool.containsKey(tmp)) {
                pool.put(tmp, pool.get(tmp) + 1);
            } else {
                pool.put(tmp, 0);
            }
        }

        return pool;
    }


    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        PrintWriter printWriter = null;
        String inputPath = "C:\\Users\\ljx\\Desktop\\Content";
        String ouputPath = "d:/2.txt";
        String inputCharset = "UTF-16LE";
        String outputCharset = "GBK";
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(inputPath), inputCharset);
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ouputPath), outputCharset));
            char[] chs = new char[1024];
            int len;
            while ((len = inputStreamReader.read(chs)) != -1) {
                printWriter.write(chs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
