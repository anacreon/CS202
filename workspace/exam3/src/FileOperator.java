import java.io.*;

public class FileOperator  {

	public static void main(String[] args) throws Exception {
		if (args.length < 3) {
			System.out.println("usage:");
			System.out.println("java FileOperator copy <A> <B>");
			System.out.println("java FileOperator join <A> <B> <C>");
			System.out.println("java FileOperator split <A> <B> <C>");
			System.exit(0);
		}

		FileOperator op = new FileOperator();
		if (args[0].equals("copy")) {
			op.copy(args[1], args[2]);
		} else if (args[0].equals("join")) {
			op.join(args[1], args[2], args[3]);
		} else if (args[0].equals("split")) {
			op.split(args[1], args[2], args[3]);
		}
	}
	
	public void copy(String src, String dest) throws IOException {
		FileInputStream in = new FileInputStream(new File(src));
		FileOutputStream out = new FileOutputStream(new File(dest));

		int inSize = in.available();
		
		System.out.println("reading: " + src + " " + inSize + " bytes");
		byte[] buffer = new byte[8];
		
		int sz = 0;
		int count = 0;
		try {
			while ( (sz = in.read(buffer)) > -1) {
				out.write(buffer, 0, sz);
				count += sz;
			}
		} catch (IOException e) {
			throw e;
		}
		
		System.out.println("wrote: " + dest + " " + count + " bytes");
		out.close();
	}
	
	public void join(String fileA, String fileB, String fileC) 
	throws IOException {
		FileInputStream in = new FileInputStream(fileA);
		FileOutputStream out = new FileOutputStream(fileC , true); 
        int inSize = in.available();
		
		System.out.println("reading: " + fileA + " " + inSize + " bytes");
		byte[] buffer = new byte[8];
		
		int sz = 0;
		int count = 0;
		try {
			while ( (sz = in.read(buffer)) > -1) {
				out.write(buffer, 0, sz);
				count += sz;
			}
		} catch (IOException e) {
			throw e;
		}
		in = new FileInputStream(fileB);
        inSize = in.available();
		
		System.out.println("reading: " + fileB + " " + inSize + " bytes");
		buffer = new byte[8];
		
		try {
			while ( (sz = in.read(buffer)) > -1) {
				out.write(buffer, 0, sz);
				count += sz;
			}
		} catch (IOException e) {
			throw e;
		}
		System.out.println("wrote: " + fileC + " " + count + " bytes");
		out.close();


	}
	
	public void split(String fileA, String fileB, String fileC) 
	throws IOException {

	}

}
