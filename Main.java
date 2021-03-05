import Mk.HttpCon;
import Mk.HttpCon.*;
import Mk.TextFile;
import Mk.MD5;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String url = "https://lz4.overpass-api.de/api/interpreter";
        String[] headers = {"Content-Type: text/xml"};
        String data = TextFile.read("req.xml");
        final HttpCon.Request req = new HttpCon.Request(HttpCon.Type.POST, url, headers, data);

        final String filename = MD5.hash(req) + ".json";

        if(!new File(filename).exists())
            TextFile.write(req, filename);
            
        System.out.println(TextFile.overview(filename, 25));
    }
}