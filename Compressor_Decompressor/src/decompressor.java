import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
//here given file is compressed one which has to decompress
    public static void method (File file) throws IOException{
        //geting file location
        String filedirectory=file.getParent();

        //read bytes from compressed file as it is
        //but can not decompressed it
        FileInputStream fis=new FileInputStream(file);


        //gzip will read and decompresses at same time
        //passing it through Gzipinput stream to read a file cause its compressd file
        GZIPInputStream gzip= new GZIPInputStream(fis);

        //to store decompresse file in same directory
        //fos will write by while loop
        FileOutputStream fos=new FileOutputStream(filedirectory + "/decompressedfile");

        byte[] buffer=new byte[1024];
        int lenth;

        //reading fis file in chunk of 1024 in buffer and then writing that buffer bytes arr
        //in to outputstring until input file is over(if over read methos will return -1 and loop will stop)
        while((lenth=gzip.read(buffer))!=-1){
            fos.write(buffer,0,lenth);
        }
        gzip.close();
        fis.close();
        fos.close();

    }
}
