package no.tytraman.code;

import java.io.Console;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


    public static void main(String[] args) {
        Console console = System.console();
        if(console == null) {
            System.exit(-1);
        }
        if(args.length > 0) {
            try {
                URL url = new URL("https://www.nautiljon.com/membre/vu," + args[0] + ",anime.html");
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    String line;
                    String safeLine = "none";
                    long episodes = -1;
                    while ((line = reader.readLine()) != null) {
                        if(line.startsWith("<div class=\"stats_prix\">")) {
                            safeLine = line.replaceAll("\\<.*?\\>", "");
                        }
                    }
                    System.out.println(safeLine);
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }catch(MalformedURLException e) {
                System.out.println("URL incorrecte...");
            }
        }
    }
}
