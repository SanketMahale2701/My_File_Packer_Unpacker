/// Decoration
// final code for filepacker
// convert this code in C language

import java.util.*;
import java.io.*;

public class FilePack
{
    public static void main(String arg[]) throws Exception
    {

       Scanner sobj = new Scanner(System.in);
       byte Buffer[] = new byte[1024];
       int iRet = 0;
       boolean bRet;
       int PackCount = 0;

       
       System.out.println("----------------------------------------------------------------------------");
       System.out.println("                            FILE PACKER-UNPACKER                            ");
       System.out.println("----------------------------------------------------------------------------");
       System.out.println("                                                                            ");
       System.out.println("Packing Activity Of the Application Is Started...");


       System.out.println("Enter the folder name that contains the files that you want to pack :");
       String FolderName = sobj.nextLine();


       File fobj = new File(FolderName); // object of file class name
       String Header = null;


       System.out.println("Enter the name of packed file that you want to create : ");
       String PackFile = sobj.nextLine();
     

       try 
       {
            File Packobj = new File(PackFile);
            bRet = Packobj.createNewFile();


            if(bRet == false)
            {
                System.out.println("Unable to create packed file");
                return;
            }
            

            System.out.println("Packed File gets successfully created in your current directory.");


            FileOutputStream outobj = new FileOutputStream(Packobj);  // for write a data


            bRet = fobj.isDirectory();
 

            if(bRet == true)
            {

                File List[] = fobj.listFiles();  // Display the list of all files from the directory
                System.out.println("Total number of files found in the directory are :"+List.length);
                

                for(int i = 0;i < List.length;i++)
                {

                    if(List[i].getName().endsWith(".txt"))
                    {
                       
                        Header = List[i].getName() + " " + List[i].length();

                        for(int j = Header.length();j < 100;j++ )
                        {
                           Header = Header + " ";
                        }

                        byte bHeader[] = Header.getBytes(); // data convert into bytes array
                        outobj.write(bHeader,0,bHeader.length); // write data header


                        FileInputStream inobj = new FileInputStream(List[i]);

                        // loop to write a data
                        while((iRet = inobj.read(Buffer)) != -1)
                        {
                            outobj.write(Buffer,0,iRet);
                        }
                        

                        System.out.println("File successfully packed with name "+List[i].getName());
                        inobj.close();
                        PackCount++;

                    }
                }
                System.out.println("---------------------------------------------------------------");
                System.out.println("                        Packing Summary                        ");
                System.out.println("---------------------------------------------------------------");
                System.out.println("Total number of file scanned :"+List.length);
                System.out.println("Total number of files packed :"+PackCount);
                System.out.println("---------------------------------------------------------------");
                System.out.println("Thank you for using Packer-Unpacker");
            }
       }    
       catch(Exception iobj)
       { 
          System.out.println("Exception Occured :"+iobj);
       }
    }
}    
// Done