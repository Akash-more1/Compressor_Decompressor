import java.io.*;
import java.util.zip.GZIPOutputStream;

public class compressor {
    //here given file is decompressed one which has to compress
    public static void method (File file) throws IOException {
         //getting a path of file from file chooser  and want to save file in same directory

        //getting folder in which file has saved(i.e parent for given file)
        String fileDirectory=file.getParent();

        //fileinput strem read byte data from file
        FileInputStream fis=new FileInputStream(file);

        //to save out put file in same filedirectory of choosen file with mentioned name and type
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/compressedfile.gz");

        //compressing a file
        //writing bytes in compressed format in fos with a help of gzip
        GZIPOutputStream gzip= new GZIPOutputStream(fos);

        //byte arr to store read bytes
        byte[] buffer=new byte[1024];

        int length;      //length of input stream

        //reading fis file in chunk of 1024 in buffer and then writing that buffer bytes arr
        //in to outputstring until input file is over(if over read methos will return -1 and loop will stop)
        while((length=fis.read(buffer))!=-1){
            //writing in compressed formate
                gzip.write(buffer,0,length);
        }

        gzip.close();
        fis.close();
        fos.close();

    }
}
