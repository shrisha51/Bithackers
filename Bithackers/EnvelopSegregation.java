import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class EnvelopSegregation {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File infile=new File("/home/shri/inputFromOCR.txt");
		OutputStream os = null;
		String data="";
		
		
		FileInputStream fis = new FileInputStream(infile);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		char c;
		try{
			while((line = br.readLine()) != null){
				try{
					String[] parts = line.split(";;");
					
					data=parts[1]+'\n';
					c=parts[1].charAt(0);
					switch(c){
					case '1':	
					case '2':
				
						os = new FileOutputStream(new File("/home/shri/outputAfterSortingN.txt"),true);
					    os.write(data.getBytes(), 0, data.length());
					    break;
					case '4': 
						os = new FileOutputStream(new File("/home/shri/outputAfterSortingM.txt"),true);
					    os.write(data.getBytes(), 0, data.length());
					    break;
					case '5':	
					case '6':
						os = new FileOutputStream(new File("/home/shri/outputAfterSortingS.txt"),true);
				    os.write(data.getBytes(), 0, data.length());
				    break;
					case '7':
					case '8':os = new FileOutputStream(new File("/home/shri/outputAfterSortingE.txt"),true);
				    os.write(data.getBytes(), 0, data.length());
				    break;
					case '3':	os = new FileOutputStream(new File("/home/shri/outputAfterSortingW.txt"),true);
				    os.write(data.getBytes(), 0, data.length());
				    break;
					default:	os = new FileOutputStream(new File("/home/shri/outputAfterSortingU.txt"),true);
				    os.write(data.getBytes(), 0, data.length());
				    break;
					  
					}
					
				}catch (IOException e) {
				    e.printStackTrace();
				}finally{
				    try {
				        os.close();
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
			}
				
		}
			br.close();
	}catch(Exception e){
		System.out.println("e caught");
		e.printStackTrace();
	}

}
}