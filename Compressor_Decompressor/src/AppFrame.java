import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame  implements ActionListener {
     JFrame frame;
    JButton compressButton;

    JButton decompressButton;

    AppFrame(){
        //initialize frame
        frame=new JFrame("Compressor Decompress");

        

        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        //initializing compress button
        compressButton=new JButton("Click to compress");
        compressButton.setBounds(200 ,200, 200, 30);
       //adding action listener to comressbutton of instance of Appframe class
        compressButton.addActionListener(this);
        compressButton.setFocusable(false);
        //compressButton.setIcon(icon);
        compressButton.setCursor(cursor);

        //initializing decompress button
        decompressButton =new JButton("Click to decompress");
        decompressButton.setBounds(200, 300, 200,30);
        //adding action listener to decomressbutton of instance of Appframe class
        decompressButton.addActionListener(this);
        decompressButton.setFocusable(false);
        decompressButton.setCursor(cursor);


        //adding buttons to frame
        frame.add(compressButton);
        frame.add(decompressButton);



        //setting properties of frame;

        frame.setSize(600,600);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(null); //help to place component absolutely
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop a running program when click on cross button


    }
    @Override
    public void actionPerformed(ActionEvent e) {
         //if clicked compressbutton
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int chooseoption=fileChooser.showSaveDialog(null);

            if(chooseoption==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
           //calling method of comressor with handling exceptions
                try {
                    compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }

        //if clicked decompressbutton
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int chooseoption=fileChooser.showSaveDialog(null);

            if(chooseoption==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());

                //calling method of decomressor with handling exceptions
                try {
                    decompressor.method(file);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
