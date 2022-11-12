package main.java.antonioHigueron;

import java.io.*;
import java.util.Hashtable;

public class ComandoConsola {

    public static void main(String[] args) {
        //ejecutarComando();
        try {
            Hashtable hashtable = getenv();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void ejecutarComando() {
        try {
            Runtime.getRuntime().exec("cmd /c start dir ");
            //Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && ping localhost\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Hashtable getenv() throws Throwable {
        Process p;
        if (File.separator.equals("\\")) {
            p = Runtime.getRuntime().exec("cmd /c set");
        } else {
            p = Runtime.getRuntime().exec("printenv");
        }

        InputStream in = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        Hashtable table = new Hashtable();

        while ((line = reader.readLine()) != null) {
            int i = line.indexOf('=');
            if (i > 0) {
                String name = line.substring(0, i);
                String value = line.substring(i + 1);
                table.put(name, value);
            }
        }

        in.close();
        p.waitFor();
        return table;
    }

}
