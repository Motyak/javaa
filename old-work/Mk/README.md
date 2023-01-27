# Classes
- [HttpCon](#httpcon)
- [MD5](#md5)
- [TextFile](#textfile)

# HttpCon
[(File)](https://raw.githubusercontent.com/Motyak/javaa/master/Mk/HttpCon.java)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp;
[HttpCon](#httpcon)
&emsp; &emsp; &emsp; &emsp;
[MD5](#md5)
&emsp; &emsp; &emsp; &emsp;
[TextFile](#textfile)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
[Back to top](#)


## `public class HttpCon`

Static class for sending HTTP requests

 * **Author:** Motyak

## `public static String request(Type reqType, String url, String[] headers, String data) throws IOException`

Send an HTTP request to a server

 * **Parameters:**
   * `reqType` — the HTTP method to use
   * `url` — the web server URL to send the request to (can contain query strings)
   * `headers` — the HTTP headers to use (can be set to null if none)
   * `data` — the data to send to the server if any (can be set to null if none)
 * **Returns:** a response from the server
 * **Exceptions:** `IOException` — if the connection with the server cannot be established

## `public static String exec(Request r) throws IOException`

Send an HTTP request to a server (URL)

 * **Parameters:** `r` — the HTTP request to execute
 * **Returns:** a response from the server
 * **Exceptions:** `IOException` — if the connection with the server cannot be established

## `static public enum Type`

Enum for each HTTP request method (GET and POST)

## `static public class Request`

Represents a request object

# MD5
[(File)](https://raw.githubusercontent.com/Motyak/javaa/master/Mk/MD5.java)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp;
[HttpCon](#httpcon)
&emsp; &emsp; &emsp; &emsp;
[MD5](#md5)
&emsp; &emsp; &emsp; &emsp;
[TextFile](#textfile)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
[Back to top](#)

## `public class MD5`

Static class to hash an object using MD5 algorithm

 * **Author:** Motyak

## `public static String hash(Serializable obj) throws IOException, NoSuchAlgorithmException`

Hash an object using MD5 algorithm

 * **Parameters:** `obj` — any object
 * **Returns:** the MD5 hash value as a String
 * **Exceptions:**
   * `IOException` — if writing the object to object output stream fails
   * `NoSuchAlgorithmException` — this will never happen

# TextFile
[(File)](https://raw.githubusercontent.com/Motyak/javaa/master/Mk/TextFile.java)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp;
[HttpCon](#httpcon)
&emsp; &emsp; &emsp; &emsp;
[MD5](#md5)
&emsp; &emsp; &emsp; &emsp;
[TextFile](#textfile)
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
[Back to top](#)

## `public class TextFile`

Static class for reading from / writing to text files

 * **Author:** Motyak

## `public static String read(String filePath) throws IOException`

Read file content

 * **Parameters:** `filePath` — the absolute path of the targeted file
 * **Returns:** the content of the targeted file as a String
 * **Exceptions:** `IOException` — if there's a problem finding/reading the file

## `public static void write(Object stringable, String filePath) throws IOException`

Write stringable to file (overwrite if exists, otherwise create it)

 * **Parameters:**
   * `stringable` — the content to write into the file, will use 'toString()' implementation
   * `filePath` — the absolute path of the file to create
 * **Exceptions:** `IOException` — if there's a problem finding/writing the file

## `public static void append(Object stringable, String filePath) throws IOException`

Append stringable to file (create the file if not exists)

 * **Parameters:**
   * `stringable` — the content to write into the file, will use 'toString()' implementation
   * `filePath` — the absolute path of the file to create
 * **Exceptions:** `IOException` — if there's a problem finding/writing the file

## `public static String overview(String filePath, int nbOfLines) throws IOException`

Read a file and return an overview of it

 * **Parameters:**
   * `filePath` — the absolute path of the targeted file
   * `nbOfLines` — the overview length
 * **Returns:** an overview of the targeted file
 * **Exceptions:** `IOException` — if there's a problem finding/reading the file

## `public static void rename(String dirPath, String fileName, String newFileName) throws Exception`

Rename a file

 * **Parameters:**
   * `dirPath` — the directory containing the file to rename
   * `fileName` — the name of the file to rename
   * `newFileName` — the new file name
 * **Exceptions:** `Exception` — if there's a problem finding/renaming the file

## `public static void renameAndOverwrite(String dirPath, String fileName, String newFileName) throws Exception`

Rename a file, overwrite if a file is already named as new file name

 * **Parameters:**
   * `dirPath` — the directory containing the file to rename
   * `fileName` — the name of the file to rename
   * `newFileName` — the new file name
 * **Exceptions:** `Exception` — if there's a problem finding/renaming the file
