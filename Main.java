import Mk.HttpCon;
import Mk.HttpCon.*;
import Mk.TextFile;
import Mk.MD5;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

class Request extends HttpCon.Request implements Serializable {
    Request(Type reqType, String url, String[] headers, String data) {
        super(reqType, url, headers, data);
    }
}

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String url = "https://lz4.overpass-api.de/api/interpreter";
        String[] headers = {"Content-Type: text/xml"};
        String data = TextFile.read("req.xml");
        final Request req = new Request(HttpCon.Type.POST, url, headers, data);

        final String filename = MD5.hash(req) + ".json";

        if(!new File(filename).exists())
            TextFile.write(req, filename);
            
        System.out.println(TextFile.overview(filename, 25));
    }
}